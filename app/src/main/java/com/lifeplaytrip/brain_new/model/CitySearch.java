package com.lifeplaytrip.brain_new.model;

/**
 * Created by LifePlayTrip on 4/2/2018.
 */

public class CitySearch {
    private String cityName;
    private String cityId;

    public CitySearch(String cityName, String cityId) {
        this.cityName = cityName;
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
