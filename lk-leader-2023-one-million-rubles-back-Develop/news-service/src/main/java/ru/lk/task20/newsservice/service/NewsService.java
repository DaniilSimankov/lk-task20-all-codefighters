package ru.lk.task20.newsservice.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.lk.task20.newsservice.dto.NewsResponse;
import ru.lk.task20.newsservice.exception.NewsNotFoundException;
import ru.lk.task20.newsservice.exception.RubricNotFoundException;
import ru.lk.task20.newsservice.model.News;
import ru.lk.task20.newsservice.model.Rubric;
import ru.lk.task20.newsservice.repository.NewsRepository;

import java.util.List;
import java.util.Objects;

/**
 * Service for working with news.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NewsService {

    private final NewsRepository newsRepository;

    /**
     * Get all news in the specified rubric.
     *
     * @param abbr the abbreviation of the rubric
     * @return the list of news in the specified rubric
     * @throws RubricNotFoundException if the rubric is not found
     */
    public List<NewsResponse> getAllNewsInRubric(@NonNull String abbr) {
        if (!Rubric.findByAbbr(abbr)) {
            throw new RubricNotFoundException(abbr);
        }

        List<News> news = newsRepository.getAllByRubric(abbr);
        return news.stream().map(this::mapToNewsResponse).toList();
    }

    /**
     * Get all news
     *
     * @return the list of news
     */
    public List<NewsResponse> getAllNews() {
        List<News> news = newsRepository.findAll();
        return news.stream().map(this::mapToNewsResponse).toList();
    }

    /**
     * Get news by the specified id.
     *
     * @param id the id of the news
     * @return the object with news information
     * @throws NewsNotFoundException if the news is not found
     */
    public NewsResponse getNewsById(@NonNull String id) {
        News news = newsRepository.getNewsById(id);
        if (Objects.isNull(news)) {
            throw new NewsNotFoundException(id);
        }
        return mapToNewsResponse(news);
    }

    // HELP METHODS

    /**
     * Map the News object to the NewsResponse object.
     *
     * @param news the news object
     * @return the object with news information
     */
    private NewsResponse mapToNewsResponse(News news) {
            return NewsResponse.builder()
                    .id(news.getId())
                    .title(news.getTitle())
                    .rubric(news.getRubric())
                    .content(news.getContent())
                    .build();
    }
}
