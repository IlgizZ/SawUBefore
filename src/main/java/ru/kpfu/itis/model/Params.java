package ru.kpfu.itis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by mikl on 30.04.2016.
 */
@Entity
public class Params {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String color;
    private String sex;
    private String TopColor;
    private String BottomColor;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "request_id")
    private UserRequest request;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTopColor() {
        return TopColor;
    }

    public void setTopColor(String topColor) {
        TopColor = topColor;
    }

    public String getBottomColor() {
        return BottomColor;
    }

    public void setBottomColor(String bottomColor) {
        BottomColor = bottomColor;
    }

    public UserRequest getRequest() {
        return request;
    }

    public void setRequest(UserRequest request) {
        this.request = request;
    }
}
