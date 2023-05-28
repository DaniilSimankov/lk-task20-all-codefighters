package ru.lk.task20.newsservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.lk.task20.newsservice.dto.ArtDirectionResponse;
import ru.lk.task20.newsservice.dto.InfoArtDirectionResponse;
import ru.lk.task20.newsservice.service.ArtDirectionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news/art-directions")
public class ArtDirectionController {
    private final ArtDirectionService artDirectionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InfoArtDirectionResponse> getInfoAboutAllDirections() {
        return artDirectionService.getAllArtDirections();
    }

    @GetMapping("/one")
    @ResponseStatus(HttpStatus.OK)
    public ArtDirectionResponse getInfoAboutDirectionByName(@RequestParam(name = "name") String name) {
        return artDirectionService.getInfoAboutDirection(name);
    }
}
