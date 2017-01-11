package com.gkortsaridis.gdgthessalonikidevfest.Sponsors;

/**
 * Created by yoko on 07/01/2017.
 */

public class sponClass {

    private String name;
    private int picture;
    private String url;

    public sponClass(String name, int picture, String url) {
        this.name = name;
        this.picture = picture;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getUrl(){ return url; }

    public void setUrl(String url) { this.url = url; }
}