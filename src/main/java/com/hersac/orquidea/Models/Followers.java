package com.hersac.orquidea.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "followers")
public class Followers{

    //Parameters

    @Id
    @Column(name = "followId")
    private Long followId;

    @ManyToOne
    private User follower;

    @OneToOne
    private User user;


    //Constructors

    public Followers(){
        super();
    }

    public Followers(Long followId, User follower, User user){
        super();
        this.followId = followId;
        this.follower = follower;
        this.user = user;
    }


    //Methods

    public Long getFollowId() {
        return followId;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


