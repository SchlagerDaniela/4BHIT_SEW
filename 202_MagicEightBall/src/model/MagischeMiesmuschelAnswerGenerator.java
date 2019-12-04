package model;
/*
        Author: Schlager Daniela
        Date: 07.11.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 07.11.2019
 */

public class MagischeMiesmuschelAnswerGenerator implements AnswerGenerator{
    private String[] answers = {
            "Ja",
            "Nein",
            "Vielleicht",
            "Weiß nicht",
            "Frag mich später",
            "Frag nochmal"
    };

    public String answer() {
        return answers[(int) Math.round(Math.random()*(answers.length-1))];
    }
}
