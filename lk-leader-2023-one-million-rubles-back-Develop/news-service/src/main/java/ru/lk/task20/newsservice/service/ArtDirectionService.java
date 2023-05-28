package ru.lk.task20.newsservice.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.lk.task20.newsservice.dto.InfoArtDirectionResponse;
import ru.lk.task20.newsservice.dto.ArtDirectionResponse;
import ru.lk.task20.newsservice.dto.NewsResponse;
import ru.lk.task20.newsservice.model.ArtDirection;
import ru.lk.task20.newsservice.model.ArtSchool;
import ru.lk.task20.newsservice.model.News;
import ru.lk.task20.newsservice.repository.ArtDirectionRepository;
import ru.lk.task20.newsservice.repository.ArtSchoolRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArtDirectionService {

    private final ArtDirectionRepository artDirectionRepository;
    private final ArtSchoolRepository artSchoolRepository;

    public ArtDirectionResponse getInfoAboutDirection(@NonNull String name) {
        ArtDirection artDirection = artDirectionRepository.findArtDirectionByAbbreviatedTitle(name);
        List<ArtSchool> artSchoolList = artSchoolRepository.findArtSchoolsBySubDirectionsIn(artDirection.getSubDirections());

        ArtDirectionResponse response = ArtDirectionResponse.builder()
                .name(name)
                .artSchools(artSchoolList)
                .build();
        return response;
    }

    public List<InfoArtDirectionResponse> getAllArtDirections() {
        List<ArtDirection> artDirections = artDirectionRepository.findAll();

        return artDirections.stream().map(this::mapToInfoArtDirection).toList();
    }

    //HELP METHODS

    private InfoArtDirectionResponse mapToInfoArtDirection(ArtDirection artDirection) {
        return InfoArtDirectionResponse.builder()
                .name(artDirection.getName())
                .abbreviatedTitle(artDirection.getAbbreviatedTitle())
                .subDirections(artDirection.getSubDirections())
                .build();
    }
}
