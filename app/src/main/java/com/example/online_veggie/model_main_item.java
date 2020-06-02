package com.example.online_veggie;

public class model_main_item {
    private int vegeimage;
    private String offerpercent;
    private String vegename;
    private String vegeweight;
    private String vegeprice;

    public model_main_item(int vegeimage, String offerpercent, String vegename, String vegeweight, String vegeprice) {
        this.vegeimage = vegeimage;
        this.offerpercent = offerpercent;
        this.vegename = vegename;
        this.vegeweight = vegeweight;
        this.vegeprice = vegeprice;
    }

    public int getVegeimage() {
        return vegeimage;
    }

    public void setVegeimage(int vegeimage) {
        this.vegeimage = vegeimage;
    }

    public String getOfferpercent() {
        return offerpercent;
    }

    public void setOfferpercent(String offerpercent) {
        this.offerpercent = offerpercent;
    }

    public String getVegename() {
        return vegename;
    }

    public void setVegename(String vegename) {
        this.vegename = vegename;
    }

    public String getVegeweight() {
        return vegeweight;
    }

    public void setVegeweight(String vegeweight) {
        this.vegeweight = vegeweight;
    }

    public String getVegeprice() {
        return vegeprice;
    }

    public void setVegeprice(String vegeprice) {
        this.vegeprice = vegeprice;
    }
}
