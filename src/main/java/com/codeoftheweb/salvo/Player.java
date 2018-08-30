package com.codeoftheweb.salvo;




import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String userName;

    @OneToMany(mappedBy="player", fetch =FetchType.EAGER)
    Set<GamePlayer> gamePlayers = new HashSet<>();

    @OneToMany(mappedBy="player", fetch =FetchType.EAGER)
    Set<Score> scores = new HashSet<>();

    public Player() { }

    public Player(String user) {
        this.userName = user;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String email) {
        this.userName = email;
    }

     public String toString() {
        return userName;
    }

    public Set<GamePlayer> getGamePlayers(){
        return gamePlayers;
    }

    public void addGamePlayer (GamePlayer gamePlayer){
        gamePlayer.setPlayer(this);
        gamePlayers.add(gamePlayer);
    }

    public Set<Score> getScores() {
        return scores;
    }

    public Score getScore(Game game) {
        return scores.stream().filter(score -> {
          return  score.getGame().getId()== game.getId();
        }).findFirst().orElse(null);
    }

    public void addScore ( Score score){
        score.setPlayer(this);
        scores.add(score);
    }



}
