package com.hersac.orquidea.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seed")
public class Seed{

    //Parameters

    @Id
    @Column(name = "seedId")
    private Long seedId;

    @Column(name = "seedText")
    private String seedText;
    
    @Column(name = "seedCreationDate")
    private String seedCreationDate;

    @ManyToOne
    private User user;

    @OneToOne
    private Seed seedShare;

    @Column(name = "seedImage1")
    private String seedImage1;

    @Column(name = "seedImage2")
    private String seedImage2;

    @Column(name = "seedImage3")
    private String seedImage3;

    @Column(name = "seedImage4")
    private String seedImage4;

    @Column(name = "seedImage5")
    private String seedImage5;

    @Column(name = "seedGif")
    private String seedGif;
    
    @Column(name = "seedVideo")
    private String seedVideo;

    @OneToOne
    private Type seedType;


    //Constructors

    public Seed(){
        super();
    }

    public Seed(Long seedId, String seedText, User user, Seed seedShare, String seedImage1, String seedImage2, String seedImage3, String seedImage4, String seedImage5, String seedGif, String seedVideo, Type seedType){
        super();
        this.seedId = seedId;
        this.seedText = seedText;
        this.user = user;
        this.seedShare = seedShare;
        this.seedImage1 = seedImage1;
        this.seedImage2 = seedImage2;
        this.seedImage3 = seedImage3;
        this.seedImage4 = seedImage4;
        this.seedImage5 = seedImage5;
        this.seedGif = seedGif;
        this.seedVideo = seedVideo;
        this.seedType = seedType;
    }


    //Methods

    public Long getSeedId() {
        return seedId;
    }

    public String getSeedText() {
        return seedText;
    }

    public void setSeedText(String seedText) {
        this.seedText = seedText;
    }

    public String getSeedCreationDate() {
        return seedCreationDate;
    }

    public void setSeedCreationDate(String seedCreationDate) {
        this.seedCreationDate = seedCreationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seed getSeedShare() {
        return seedShare;
    }

    public void setSeedShare(Seed seedShare) {
        this.seedShare = seedShare;
    }

    public String getSeedImage1() {
        return seedImage1;
    }

    public void setSeedImage1(String seedImage1) {
        this.seedImage1 = seedImage1;
    }

    public String getSeedImage2() {
        return seedImage2;
    }

    public void setSeedImage2(String seedImage2) {
        this.seedImage2 = seedImage2;
    }

    public String getSeedImage3() {
        return seedImage3;
    }

    public void setSeedImage3(String seedImage3) {
        this.seedImage3 = seedImage3;
    }

    public String getSeedImage4() {
        return seedImage4;
    }

    public void setSeedImage4(String seedImage4) {
        this.seedImage4 = seedImage4;
    }

    public String getSeedImage5() {
        return seedImage5;
    }

    public void setSeedImage5(String seedImage5) {
        this.seedImage5 = seedImage5;
    }

    public String getSeedGif() {
        return seedGif;
    }

    public void setSeedGif(String seedGif) {
        this.seedGif = seedGif;
    }

    public String getSeeVideo() {
        return seedVideo;
    }

    public void setSeeVideo(String seedVideo) {
        this.seedVideo = seedVideo;
    }

    public Type getSeedType() {
        return seedType;
    }

    public void setSeedType(Type seedType) {
        this.seedType = seedType;
    }
}


