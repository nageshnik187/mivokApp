package com.example.myapplication;

public class FamilyMember {

    private String englishTransistion;
    private String mivokTransistion;
    private int imageResource;
    private int familyMemberId;

    public FamilyMember(String english, String mivok){
        englishTransistion = english;
        mivokTransistion = mivok;
    }

    public FamilyMember(String english, String mivok, int image, int familyMember){
        englishTransistion = english;
        mivokTransistion = mivok;
        imageResource = image;
        familyMemberId = familyMember;

    }

    public int getImageResourceId() {
        return  imageResource;
    }

    public String getEnglishTransistion(){
        return  englishTransistion;
    }

    public String getMivokTransistion() {
        return mivokTransistion;
    }

    public int getFamilyMemberId(){
        return familyMemberId;
    }

}
