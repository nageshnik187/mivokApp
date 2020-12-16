package com.example.myapplication;

public class Word {

    private static int imageResource;
    private String englishTransistion;
    private String mivokTransistion;
    private int audioId;


    public Word(String english, String mivok){
        englishTransistion = english;
        mivokTransistion = mivok;
    }

    public Word(String english, String mivok, int image, int audio){
        englishTransistion = english;
        mivokTransistion = mivok;
        imageResource = image;
        audioId = audio;
    }

    public static int getImageResourceId(){ return imageResource; }

    public String getEnglishTransistion(){
        return  englishTransistion;
    }

    public String getMivokTransistion() {
        return mivokTransistion;
    }

    public int getAudioResourceId(){
        return audioId;
    }
}
