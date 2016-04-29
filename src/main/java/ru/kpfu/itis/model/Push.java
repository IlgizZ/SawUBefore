package ru.kpfu.itis.model;

import javax.persistence.*;

/**
 * Created by mikl on 29.04.2016.
 */
@Entity
public class Push {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id")
    private UserRequest userRequestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_user_id")
    private User fromUserId;

    public Push(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRequest getUserRequestId() {
        return userRequestId;
    }

    public void setUserRequestId(UserRequest userRequestId) {
        this.userRequestId = userRequestId;
    }

    public User getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(User fromUserId) {
        this.fromUserId = fromUserId;
    }
}
