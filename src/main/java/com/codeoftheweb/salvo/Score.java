package com.codeoftheweb.salvo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private float score;
    private LocalDateTime finishDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gameId")
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="playerId")
    private Player player;

    public Score(){};

    public Score(Game game, Player player,float score,LocalDateTime finishDate ){
       this.game=game;
       game.addScore(this);
       this.player=player;
       player.addScore(this);
       this.score=score;
       this.finishDate=finishDate;
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
