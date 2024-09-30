package com.amazon.ata.designcomposition;

import java.util.Comparator;
import java.util.List;

public class BestAnswerAlexaQAClient implements AlexaQA {
    private final AlexaQA alexaQA;

    public BestAnswerAlexaQAClient(AlexaQA alexaQA) {
        this.alexaQA = alexaQA;
    }

    @Override
    public List<AlexaAnswer> findAnswers(AlexaQuestion question) {
        return alexaQA.findAnswers(question);
    }

    @Override
    public void submitQuestionAnswerSuggestion(AlexaQuestion question, AlexaAnswer answer) {
        alexaQA.submitQuestionAnswerSuggestion(question, answer);
    }

    public AlexaAnswer findBestAnswer(AlexaQuestion question) {
        return findAnswers(question).stream()
                .max(Comparator.comparingDouble(AlexaAnswer::getAnswerQuality))
                .orElse(null);
    }

    public void submitQuestionAnswerSuggestions(AlexaQuestion question, List<AlexaAnswer> answers) {
        for (AlexaAnswer answer : answers) {
            submitQuestionAnswerSuggestion(question, answer);
        }
    }
}