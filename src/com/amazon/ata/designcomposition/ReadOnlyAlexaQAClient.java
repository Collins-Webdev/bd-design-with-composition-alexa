package com.amazon.ata.designcomposition;

import java.util.List;

public class ReadOnlyAlexaQAClient implements AlexaQA {
    private final AlexaQA alexaQA;

    public ReadOnlyAlexaQAClient(AlexaQA alexaQA) {
        this.alexaQA = alexaQA;
    }

    @Override
    public List<AlexaAnswer> findAnswers(AlexaQuestion question) {
        return alexaQA.findAnswers(question);
    }

    @Override
    public void submitQuestionAnswerSuggestion(AlexaQuestion question, AlexaAnswer answer) {
        // Do nothing - this method is intentionally left empty to prevent write access
    }
}