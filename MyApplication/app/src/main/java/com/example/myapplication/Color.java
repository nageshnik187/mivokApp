package com.example.myapplication;

public class Color {

    private static int imageResource;
    private String englishTransistion;
    private String mivokTransistion;
    private int colorId;


    public Color(String english, String mivok){
        englishTransistion = english;
        mivokTransistion = mivok;
    }

    public Color(String english, String mivok, int image, int color){
        englishTransistion = english;
        mivokTransistion = mivok;
        imageResource = image;
        colorId = color;
    }

    public static int getImageResourceId(){ return imageResource; }

    public String getEnglishTransistion(){
        return  englishTransistion;
    }

    public String getMivokTransistion() {
        return mivokTransistion;
    }

    public int getColorsId(){
        return colorId;
    }
}
