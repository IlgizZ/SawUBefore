package ru.kpfu.itis.form;

import java.util.Date;

/**
 * Created by mikl on 30.04.2016.
 */
public class GeolocationForm {
    private Long userId;
    private Double lat;
    private Double lg;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
