package com.gkortsaridis.gdgthessalonikidevfest.Speakers;

/**
 * Created by yoko on 07/01/2017.
 */

public class spClass {

    private String name;
    private String desc;
    private int picture;
    private String title;
    private String room;
    private String time;
    private String fbUrl;
    private String webUrl;
    private String instaUrl;
    private String gplusUrl;
    private String twitterUrl;
    private String githubUrl;
    private String linkedinUrl;

    public spClass(String title, String name, String desc, int picture, String room, String time) {
        this.name = name;
        this.desc = desc;
        this.picture = picture;
        this.title = title;
        this.room = room;
        this.time = time;
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

    public String getTitle(){ return title; }

    public String getRoom(){ return room; }

    public String getTime(){ return time; }

    public String getFbUrl() {
        return fbUrl;
    }

    public void setFbUrl(String fbUrl) {
        this.fbUrl = fbUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getInstaUrl() {
        return instaUrl;
    }

    public void setInstaUrl(String instaUrl) {
        this.instaUrl = instaUrl;
    }

    public String getGplusUrl() {
        return gplusUrl;
    }

    public void setGplusUrl(String gplusUrl) {
        this.gplusUrl = gplusUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }
}

