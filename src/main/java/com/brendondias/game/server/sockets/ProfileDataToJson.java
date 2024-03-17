package com.brendondias.game.server.sockets;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileDataToJson {

    private String profileImage;

    private int level;

    private float experience;

    private int moonCoin;

    private int ryous;

    private String playerRank;

    private String playerTitle;

    private int wins;

    private int loses;

    private float winPercentage;

    private int maxLevel;

    private int streak;

}
