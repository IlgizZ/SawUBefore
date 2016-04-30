package ru.kpfu.itis.model;

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
    private Integer TopColor;
    private Integer BottomColor;


    @ManyToOne
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

    public Integer getTopColor() {
        return TopColor;
    }

    public void setTopColor(Integer topColor) {
        TopColor = topColor;
    }

    public Integer getBottomColor() {
        return BottomColor;
    }

    public void setBottomColor(Integer bottomColor) {
        BottomColor = bottomColor;
    }
}
