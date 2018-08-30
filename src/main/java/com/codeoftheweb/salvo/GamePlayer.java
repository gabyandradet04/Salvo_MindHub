package com.codeoftheweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private LocalDateTime date_game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id")
    private Player player;

    @OneToMany(mappedBy="gamePlayer", fetch =FetchType.EAGER, cascade = {CascadeType.ALL})
    Set<Ship> ships = new HashSet<>();

    @OneToMany(mappedBy="gamePlayer", fetch =FetchType.EAGER, cascade = {CascadeType.ALL})
    Set<Salvo> salvos = new HashSet<>();


    public GamePlayer(){}

    public GamePlayer(LocalDateTime now, LocalDateTime localDateTime){}

    public GamePlayer(LocalDateTime date_game, Game game, Player player, Set<Ship> ships, Set<Salvo> salvos) {
        this.date_game= date_game;
        this.game=game;
        this.player=player;
        ships.stream().forEach(this::addShip);
        salvos.stream().forEach(this::addSalvo);
    }
    public long getId() {  return id;  }
    public void setId(long id) {  this.id = id;  }

     public LocalDateTime getDate_game(){
        return date_game;
     }
     public void setDate_game(LocalDateTime date_game){
        this.date_game = date_game;
     }

    @JsonIgnore
     public Game getGame(){
        return game;
     }
     public void setGame(Game game){
        this.game = game;
     }

    @JsonIgnore
    public Player getPlayer() { return player;  }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Set<Ship> getShips() {
        return ships;
    }
    public void setShips(Set<Ship> ships) {
        ships = ships;
    }
    public void addShip(Ship ship){
        ship.setGamePlayer(this);
        ships.add(ship);
    }

    public Set<Salvo> getSalvos() {
        return salvos;
    }

    public void setSalvos(Set<Salvo> salvos) {
        this.salvos = salvos;
    }

    public void addSalvo(Salvo salvo){
        salvo.setGamePlayer(this);
        salvos.add(salvo);
    }
    //METODO GET SCORE;
    public Score getScore(){
        return player.getScore(this.game);
    }

}
