package ru.kpfu.itis.form;

/**
 * Created by Ilgiz on 30.04.2016.
 */
public class UserRequestForm {
    private Long userId;
    private Double lat;
    private Double lg;
    private String date;
    private String sex;
    private String topcolor;
    private String bottomcolor;
    private String color;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public String getBottomcolor() {
        return bottomcolor;
    }

    public void setBottomcolor(String bottomcolor) {
        this.bottomcolor = bottomcolor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
