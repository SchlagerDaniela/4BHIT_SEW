package model;
/*
        Author: Schlager Daniela
        Date: 07.11.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 07.11.2019

 */

public class MagicEightBallAnswerGenerator implements AnswerGenerator{

    private String[] answers = {
            "Yes",
            "No",
            "Maybe",
            "Ask me later",
            "Ask again"
    };

    public String answer() {
        return answers[(int) Math.round(Math.random()*(answers.length-1))];
    }
}
