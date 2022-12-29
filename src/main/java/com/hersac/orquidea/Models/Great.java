package com.hersac.orquidea.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "great")
public class Great{

    //Parameters

    @Id
    @Column(name = "greatId")
    private Long greatId;

    @ManyToOne
    private Seed seed;

    @ManyToOne
    private User user;

    @Column(name = "greatCreationDate")
    private String greatCreationDate;

    //Contructors

    public Great(){
        super();
    }

    public Great(Long greatId, Seed seed, User user, String greatCreationDate){
        super();
        this.greatId = greatId;
        this.seed = seed;
        this.user = user;
        this.greatCreationDate = greatCreationDate;
    }


    //Methods

    public Long getGreatId() {
        return greatId;
    }

    public Seed getSeed() {
        return seed;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGreatCreationDate() {
        return greatCreationDate;
    }

    public void setGreatCreationDate(String greatCreationDate) {
        this.greatCreationDate = greatCreationDate;
    }
}


