package com.lifeplaytrip.brain_new.model;

/**
 * Created by LifePlayTrip on 4/3/2018.
 */

public class PlaceSearch {
    private String placeName;
    private String cityName;
    private String distance;
    private String id;
    public PlaceSearch( String placeName,String cityName,String distance,String id){
        this.cityName=cityName;
        this.distance=distance;
        this.placeName=placeName;
        this.id=id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
