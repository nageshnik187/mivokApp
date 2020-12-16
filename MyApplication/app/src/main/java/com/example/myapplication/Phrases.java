package com.example.myapplication;

public class Phrases {

    private String englishTransistion;
    private String mivokTransistion;
    private int image;
    final int noImage = -1;
    private int phraseId;


    public Phrases(String english, String mivok){
        englishTransistion = english;
        mivokTransistion = mivok;
    }

    public Phrases(String english, String mivok, int imageId, int phrase){
        englishTransistion = english;
        mivokTransistion = mivok;
        image = imageId;
        phraseId = phrase;
    }

    public Phrases(String s, String minto_wuksus, int phrase_where_are_you_going) {
         englishTransistion = s;
         mivokTransistion = minto_wuksus;
         phraseId = phrase_where_are_you_going;
    }


    public String getEnglishTransistion(){
        return  englishTransistion;
    }

    public String getMivokTransistion() {
        return mivokTransistion;
    }

    public int getImageResourceId() {
        return image;
    }

    public int getPhraseId(){
        return phraseId;
    }

    public boolean hasImage() {
        return (image == noImage) ;
    }
}
