package com.youi.hellooo;

//A&E
public class Planta {
    Planta(){}

    String name;
    String shortdesc;
    String info;
    String date;
    String image;
    String imagebig;
    public Planta(String name, String shortdesc, String info, String date, String image,String imagebig) {
        this.name = name;
        this.shortdesc = shortdesc;
        this.info = info;
        this.date = date;
        this.image = image;
        this.imagebig = imagebig;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImagebig() {
        return imagebig;
    }

    public void setImagebig(String imagebig) {
        this.imagebig = imagebig;
    }

}
