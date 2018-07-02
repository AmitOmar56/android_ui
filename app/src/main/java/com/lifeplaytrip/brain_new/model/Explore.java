package com.lifeplaytrip.brain_new.model;

/**
 * Created by LifePlayTrip on 3/30/2018.
 */

public class Explore {
    private String explore_name;
    private String explore_image;
    private String explore_id;

    public Explore(String explore_name, String explore_image, String explore_id) {
        this.explore_name = explore_name;
        this.explore_image = explore_image;
        this.explore_id = explore_id;
    }

    public String getExplore_name() {
        return explore_name;
    }

    public void setExplore_name(String explore_name) {
        this.explore_name = explore_name;
    }

    public String getExplore_image() {
        return explore_image;
    }

    public void setExplore_image(String explore_image) {
        this.explore_image = explore_image;
    }

    public String getExplore_id() {
        return explore_id;
    }

    public void setExplore_id(String explore_id) {
        this.explore_id = explore_id;
    }
}