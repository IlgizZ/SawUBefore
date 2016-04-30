package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mikl on 30.04.2016.
 */
@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double lat;

    private Double lg;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Point() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
