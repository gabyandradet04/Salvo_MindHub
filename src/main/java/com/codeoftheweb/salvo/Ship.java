package com.codeoftheweb.salvo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ship {



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gamePlayer_id")
    private GamePlayer gamePlayer;

    @ElementCollection
    @Column(name= "ListLocation")
    private List<String> listLocation = new ArrayList<>();

//Constructor
    public Ship() {}

    public Ship(String type, List<String> listLocation){
        this.type = type;
        this.listLocation= listLocation;
    }


//Metodos Get y Set
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }
    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public List<String> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<String> listLocation) {
        this.listLocation = listLocation;
    }
}
