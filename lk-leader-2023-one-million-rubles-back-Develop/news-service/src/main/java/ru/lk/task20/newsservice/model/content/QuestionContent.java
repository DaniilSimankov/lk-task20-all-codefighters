package ru.lk.task20.newsservice.model.content;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import ru.lk.task20.newsservice.model.content.question.Question;

import java.util.List;

@JsonTypeName("QuestionContent")
public class QuestionContent extends NewsContent {

    public QuestionContent(List<Question> questionList) {
        super("QuestionContent");
        this.add("questionList", questionList);
    }

    public List<Question> getQuestionList() {
        return (List<Question>) this.getData().get("questionList");
    }
}
