package com.brendondias.game.server.entities;

import com.brendondias.game.server.dtos.GameUserProfileDTO;
import io.quarkus.hibernate.orm.PersistenceUnit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class GameUserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name="gameUser_id")
    private GameUser gameUser;

    @Column
    private String profileImage;

    @Column
    private int level;

    @Column
    private float experience;

    @Column
    private int moonCoin;

    @Column
    private int ryous;

    @Column
    private String playerRank;

    @Column
    private String playerTitle;

    @Column
    private int wins;

    @Column
    private int loses;

    @Column
    private float winPercentage;

    @Column
    private int maxLevel;

    @Column
    private int streak;


    public GameUserProfile(GameUserProfileDTO data, GameUser gameUser){

        this.gameUser = gameUser;

        this.profileImage = data.profileImage();

        this.level = data.level();

        this.experience = data.experience();

        this.moonCoin = data.moonCoin();

        this.ryous = data.ryous();

        this.playerRank = data.playerRank();

        this.playerTitle = data.playerTitle();

        this.wins  = data.wins();

        this.loses = data.loses();

        this.winPercentage = (float) data.wins() /(data.wins() + data.loses());

        this.maxLevel = data.maxLevel();

        this.streak = data.streak();
    }

}
