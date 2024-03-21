package com.ulpdroid.traductor;

public class Palabra {

    private String español, ingles;

    private int img;

    public Palabra() {
    }

    public Palabra(String español, String ingles, int img) {
        this.español = español;
        this.ingles = ingles;
        this.img = img;
    }

    public String getEspañol() {
        return español;
    }

    public String getIngles() {
        return ingles;
    }

    public int getImg() {
        return img;
    }

}
