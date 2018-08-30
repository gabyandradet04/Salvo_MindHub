package com.codeoftheweb.salvo;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Game {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private LocalDateTime creationDate;

    @OneToMany(mappedBy="game", fetch =FetchType.EAGER)
    Set<GamePlayer> gamePlayers = new HashSet<>();

    @OneToMany(mappedBy="game", fetch =FetchType.EAGER)
    Set<Score> scores = new HashSet<>();

    public Game() { }
    public Game(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }


    public Set<GamePlayer> getGamePlayers(){
        return gamePlayers;
    }
    public void addGamePlayer (GamePlayer gamePlayer){
        gamePlayer.setGame(this);
        gamePlayers.add(gamePlayer);
    }



    public void addScore ( Score score){
        score.setGame(this);
        scores.add(score);
    }

}
