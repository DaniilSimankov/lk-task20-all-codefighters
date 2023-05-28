package ru.lk.task20.newsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rubric {
    INTERVIEWS_WITH_WELL_KNOWN_FIGURES("ИНТЕРВЬЮ С ИЗВЕСТНЫМИ ДЕЯТЕЛЯМИ КУЛЬТУРЫ И ИСКУССТВА", "IWKF"),
    FACTS_ABOUT_SCHOOL("ФАКТЫ О ШКОЛАХ", "FAS"),
    FACTS_ABOUT_MUSICIANS_AND_ARTISTS_WITH_LINKS_TO_SCHOOLS("ФАКТЫ О МУЗЫКАНТАХ И ХУДОЖНИКАХ С ПРИВЯЗКОЙ К ШКОЛАМ", "FAMAWLTS"),
    FIVE_QUESTIONS_TO_TEACHER("5 ВОПРОСОВ ПЕДАГОГУ ", "FQTT"),
    PLAYLIST("ПЛЕЙЛИСТ МШИ", "PL"),
    INTERESTING("ИНТЕРЕСНОЕ МШИ", "INT"),
    QUIZ("КВИЗ #АВыЗнаете", "QZ"),
    UNUSUAL_OCCUPATIONS("НЕОБЫЧНЫЕ ПРОФЕССИИ МШИ", "UO");

    private String title;
    private String abbr;

    public static boolean findByAbbr(String abbr) {
        for (Rubric value : Rubric.values()) {
            if (value.getAbbr().equals(abbr)) {
                return true;
            }
        }
        return false;
    }
}
