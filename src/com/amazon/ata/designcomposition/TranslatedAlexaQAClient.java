package com.amazon.ata.designcomposition;

public class TranslatedAlexaQAClient {
    private final BestAnswerAlexaQAClient bestAnswerClient;
    private final AlexaTranslator translator;

    public TranslatedAlexaQAClient(BestAnswerAlexaQAClient bestAnswerClient, AlexaTranslator translator) {
        this.bestAnswerClient = bestAnswerClient;
        this.translator = translator;
    }

    public String findBestAnswerAndTranslate(AlexaQuestion question) {
        AlexaAnswer bestAnswer = bestAnswerClient.findBestAnswer(question);
        if (bestAnswer == null) {
            return null;
        }
        return translator.getTranslation(bestAnswer.getContent());
    }
}