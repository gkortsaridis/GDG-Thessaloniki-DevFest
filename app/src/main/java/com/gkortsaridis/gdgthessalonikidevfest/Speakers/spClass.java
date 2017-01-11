package com.gkortsaridis.gdgthessalonikidevfest.Speakers;

/**
 * Created by yoko on 07/01/2017.
 */

public class spClass {

    String name;
    String desc;
    int picture;

    public spClass(String name, String desc, int picture) {
        this.name = name;
        this.desc = desc;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}

