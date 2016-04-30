package ru.kpfu.itis.form;

import java.util.Date;

/**
 * Created by Ilgiz on 30.04.2016.
 */
public class UserRequestForm {
    private Long userId;
    private Double lat;
    private Double lg;
    private String date;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLg() {
        return lg;
    }

    public void setLg(Double lg) {
        this.lg = lg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
