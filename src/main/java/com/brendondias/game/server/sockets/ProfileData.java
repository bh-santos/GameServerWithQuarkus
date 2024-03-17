package com.brendondias.game.server.sockets;

import lombok.Data;

@Data
public class ProfileData {

    private String profileImage;

    private int level;

    private int experience;

    private int moonCoin;

    private int ryous;

    private String playerRank;

    private String playerTitle;

    private int wins;

    private int loses;

    private int maxLevel;

    private int streak;

    public ProfileData(){
        this.profileImage = "void";
        this.level = 1;
        this.experience = 0;
        this.moonCoin = 0;
        this.ryous = 0;
        this.playerRank = "RANK E";
        this.playerTitle = "untitled";
        this.wins = 0;
        this.loses = 0;
        this.maxLevel = 1;
        this.streak = 0;
    }
}
