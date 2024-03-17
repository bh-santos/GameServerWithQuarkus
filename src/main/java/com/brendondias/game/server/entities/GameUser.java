package com.brendondias.game.server.entities;

import com.brendondias.game.server.dtos.GameUserDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.agroal.api.AgroalDataSource;
import io.quarkus.hibernate.orm.PersistenceUnit;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class GameUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "gameUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private GameUserProfile userProfile;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String nickname;

    @Column(unique = true)
    private String email;

    @JsonFormat
    @Column
    private LocalDate birthday;

    @Column
    private String gameUserType;

    @Column
    private LocalDateTime created;

    @Column
    private String LoginCode;

    public GameUser(GameUserDTO data){
        this.username = data.username();
        this.password = data.password();
        this.email = data.email();
        this.nickname = data.nickname();
        this.birthday = data.birthday();
        this.gameUserType=data.gameUserType();
        created = LocalDateTime.now();
        System.out.println("TESTADO USUARIO CRIADO");
    }
}
