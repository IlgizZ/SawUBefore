package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mikl on 29.04.2016.
 */
@Entity
public class Geolocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double lat;

    private Double lg;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
