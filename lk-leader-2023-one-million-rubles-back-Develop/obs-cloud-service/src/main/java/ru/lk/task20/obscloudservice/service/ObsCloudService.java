package ru.lk.task20.obscloudservice.service;



import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.*;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.lk.task20.obscloudservice.model.Pair;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a service for handling file uploads, downloads, and deletion using OBS (Object Storage Service).
 */
@Service
public class ObsCloudService {

    private ObsClient obsClient;

    /**
     * Constructs a new Service object with the necessary OBS configurations.
     */
    public ObsCloudService() {
        String endPoint = "https://obs.ru-moscow-1.hc.sbercloud.ru";
        System.out.println(System.getenv("AK"));
        String ak = "ZRJ6XOR1QZTGCT5LMNOW";
        String sk = "YvBHkvxtspKmt3psOHPngyUbHBTaPGupWRhtaPtE";

        obsClient = new ObsClient(ak, sk, endPoint);
    }

    /**
     * Adds a new file element to the specified bucket.
     *
     * @param bucketName The name of the bucket to add the file to.
     * @param file       The MultipartFile representing the file to be uploaded.
     */
    public void addNewElement(String bucketName, MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            String objectKey = file.getOriginalFilename();
            obsClient.putObject(bucketName, objectKey, inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file to OBS", e);
        }
    }

    /**
     * Retrieves the specified file from the given bucket.
     *
     * @param bucketName The name of the bucket containing the file.
     * @param objectKey  The key of the file to retrieve.
     * @return A Pair containing an InputStreamResource representing the file content and a String representing the MIME type.
     *         Returns null if an error occurs during retrieval.
     */
    public Pair<InputStreamResource, String> getFile(String bucketName, String objectKey) {
        try {
            if (!isBucketExists(bucketName)) {
                throw new IOException("Bucket doesn't exist");
            }
            GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, objectKey);
            ObsObject obsObject = obsClient.getObject(getObjectRequest);
            InputStreamResource resource = new InputStreamResource(obsObject.getObjectContent());
            String mimeType = obsObject.getMetadata().getContentType();
            Pair<InputStreamResource, String> pair = new Pair<>(resource, mimeType);
            return pair;
        } catch (ObsException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Deletes the specified file from the given bucket.
     *
     * @param bucketName The name of the bucket containing the file.
     * @param objectKey  The key of the file to delete.
     */
    public void deleteFile(String bucketName, String objectKey) {
        try {
            if (!isBucketExists(bucketName)) {
                throw new IOException("Bucket doesn't exist");
            }
            obsClient.deleteObject(bucketName, objectKey);
        } catch (ObsException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Performs a multipart upload for a file larger than 100MB to the specified bucket.
     *
     * @param bucketName The name of the bucket to upload the file to.
     * @param file       The MultipartFile representing the file to be uploaded.
     */
    public void multipartUpload(String bucketName, MultipartFile file) {
        try {
            if (!isBucketExists(bucketName)) {
                throw new IOException("Bucket doesn't exist");
            }
            String objectKey = file.getOriginalFilename();
            InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(bucketName, objectKey);
            InitiateMultipartUploadResult result = obsClient.initiateMultipartUpload(request);

            List<PartEtag> partETags = new ArrayList<>();
            long partSize = 5 * 1024 * 1024L;
            byte[] fileBytes = file.getBytes();
            long fileLength = fileBytes.length;
            int partCount = (int) (fileLength / partSize);
            if (fileLength % partSize != 0) {
                partCount++;
            }
            for (int i = 0; i < partCount; i++) {
                long offset = i * partSize;
                long currPartSize = (offset + partSize < fileLength) ? partSize : fileLength - offset;
                InputStream inStream = new ByteArrayInputStream(fileBytes, (int) offset, (int) currPartSize);

                UploadPartRequest uploadPartRequest = new UploadPartRequest();
                uploadPartRequest.setBucketName(bucketName);
                uploadPartRequest.setObjectKey(objectKey);
                uploadPartRequest.setUploadId(result.getUploadId());
                uploadPartRequest.setInput(inStream);
                uploadPartRequest.setPartSize(currPartSize);
                uploadPartRequest.setPartNumber(i + 1);
                UploadPartResult uploadPartResult = obsClient.uploadPart(uploadPartRequest);

                partETags.add(new PartEtag(uploadPartResult.getEtag(), uploadPartResult.getPartNumber()));
            }

            CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(bucketName, objectKey, result.getUploadId(), partETags);
            obsClient.completeMultipartUpload(compRequest);
        } catch (IOException | ObsException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if the specified bucket exists.
     *
     * @param bucketName The name of the bucket to check.
     * @return true if the bucket exists, false otherwise.
     * @throws IOException if an error occurs during the existence check.
     */
    private boolean isBucketExists(String bucketName) throws IOException {
        return obsClient.headBucket(bucketName);
    }
}
