package ru.lk.task20.newsservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.lk.task20.newsservice.dto.NewsResponse;
import ru.lk.task20.newsservice.service.NewsService;

import java.util.List;

/**
 * Controller for managing news.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    /**
     * Get all news or news in a specific rubric.
     *
     * @param abbr the abbreviation of the rubric (optional)
     * @return the list of news
     */
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<NewsResponse> getAllNews(@RequestParam(name = "abbr", required = false) String abbr) {
        if (abbr == null) {
            return newsService.getAllNews();
        } else {
            return newsService.getAllNewsInRubric(abbr);
        }
    }

    /**
     * Get news by ID.
     *
     * @param id the ID of the news
     * @return the object with news information
     */
    @GetMapping("/one")
    @ResponseStatus(HttpStatus.OK)
    public NewsResponse getNewsById(@RequestParam(name = "id") String id) {
        return newsService.getNewsById(id);
    }
}
