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
    @JoinColumn(name = "reauest_id")
    private Request requestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_user_id")
    private User fromUserId;


}
