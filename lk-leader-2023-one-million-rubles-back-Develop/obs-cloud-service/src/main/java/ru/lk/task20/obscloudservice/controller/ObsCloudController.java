package ru.lk.task20.obscloudservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.lk.task20.obscloudservice.model.Pair;
import ru.lk.task20.obscloudservice.service.ObsCloudService;


/**
 * This class represents a RESTful web service for handling file upload, download, and deletion.
 */
@RestController
@RequestMapping("/api/obs")
public class ObsCloudController {

    private final ObsCloudService service;

    /**
     * Constructs a new Web object with the specified Service dependency.
     *
     * @param service The Service object to be used for file operations.
     */
    @Autowired
    public ObsCloudController(ObsCloudService service) {
        this.service = service;
    }

    /**
     * Handles the upload of a file to the specified bucket.
     *
     * @param multipartFile The MultipartFile representing the file to be uploaded.
     * @param bucketName    The name of the bucket to upload the file to.
     */
    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void handleFileUpload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("bucketName") String bucketName) {
        System.out.println(System.getenv("AK"));
//        long sizeInMb = multipartFile.getSize() / (1024 * 1024);
//        if (sizeInMb > 100) {
//            service.multipartUpload(bucketName, multipartFile);
//        } else {
//            service.addNewElement(bucketName, multipartFile);
//        }
    }

    /**
     * Retrieves the specified file from the given bucket and returns it as a ResponseEntity.
     *
     * @param bucketName The name of the bucket containing the file.
     * @param objectKey  The key of the file to retrieve.
     * @return A ResponseEntity containing an InputStreamResource representing the file content and the corresponding MIME type.
     */
    @GetMapping("/file/{bucketName}/{objectKey}")
    public ResponseEntity<InputStreamResource> getFile(@PathVariable String bucketName, @PathVariable String objectKey) {
        Pair<InputStreamResource, String> fileAndMimeType = service.getFile(bucketName, objectKey);
        InputStreamResource resource = fileAndMimeType.first();
        String mimeType = fileAndMimeType.second();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .body(resource);
    }

    /**
     * Retrieves the specified file from the given bucket and returns it as a ResponseEntity.
     *
     * @param bucketName The name of the bucket containing the file.
     * @param objectKey  The key of the file to retrieve.
     * @return A ResponseEntity containing an InputStreamResource representing the file content and the corresponding MIME type.
     */
    @DeleteMapping("/file/{bucketName}/{objectKey}")
    public ResponseEntity<Void> deleteFile(@PathVariable String bucketName, @PathVariable String objectKey) {
        service.deleteFile(bucketName, objectKey);
        return ResponseEntity.noContent().build();
    }
}
