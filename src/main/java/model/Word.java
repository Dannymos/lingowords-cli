package model;

public class Word {

    private String text;

    private String language;

    public Word(String text) {
        this.text = text;
        this.language = "NL";
    }

    public String getText() {
        return this.text;
    }

    public String getLanguage() {
        return this.language;
    }
}
