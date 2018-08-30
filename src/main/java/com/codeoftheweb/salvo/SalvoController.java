package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api")
public class SalvoController {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GamePlayerRepository gamePlayerRepository;
    @Autowired
    private SalvoRepository salvoRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @RequestMapping("/games")
    public List<Map<String, Object>> getGames(){
        return gameRepository.findAll()
                .stream()
                .map(game -> makeGameDTO(game))
                .collect(Collectors.toList());
    }
     private Map<String,Object>makeGameDTO( Game game){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", game.getId());
        dto.put("created", game.getCreationDate());
        dto.put("gamePlayer",game.getGamePlayers().stream().map(this::makeGamePlayerDTO).collect(Collectors.toList()));
        //dto.put("score", game.getScores().stream().map(this::scoreDTO));
        return dto;
    }
    private Map<String,Object>makeGamePlayerDTO( GamePlayer gamePlayer){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
       dto.put("id", gamePlayer.getId());
       dto.put("player", makePlayersDTO(gamePlayer.getPlayer()));
       if (gamePlayer.getScore()==null)
           dto.put("score", this.scoreDTO(new Score()));
       else
           dto.put("score",  scoreDTO(gamePlayer.getScore()));
       return dto;
    }
    private Map<String, Object> makePlayersDTO(Player player) {
      Map<String, Object> dto = new LinkedHashMap<String, Object>();
      dto.put("id", player.getId());
      dto.put("email", player.getUserName());
      return dto;
    }
    private Map<String, Object> scoreDTO (Score score) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("finished", score.getFinishDate());
        dto.put("score", score.getScore());
        return dto;
    }
     @RequestMapping("/game_view/{id}")
     public Map<String, Object> getGameView(@PathVariable Long id){
         return makeViewDTO(gamePlayerRepository.findById(id).get());
    }
    private Map<String, Object> makeViewDTO(GamePlayer gamePlayer) {
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", gamePlayer.getGame().getId());
        dto.put("created", gamePlayer.getGame().getCreationDate());
        dto.put("gamePlayers", gamePlayer.getGame().gamePlayers.stream().map(this::makeGamePlayerDTO));
        dto.put("ships", gamePlayer.getShips().stream().map(this::shipsDTO));
        //dto.put("salvo", gamePlayer.getGame().getGamePlayers().stream().flatMap(gamePlayer.getSalvos().stream().map(this::salvoDTO)));
        dto.put("salvos", gamePlayer.getGame().getGamePlayers().stream().flatMap(gamePlayerSalvos -> gamePlayerSalvos.getSalvos().stream().map(this::salvoDTO)));
       // dto.put("score", gamePlayer.getGame().getGamePlayers().stream().flatMap(gamePlayerScore -> gamePlayerScore.get().stream().map(this::scoreDTO)));
        return dto;
    }
    private Map<String, Object> shipsDTO(Ship ship){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", ship.getId());
        dto.put("type", ship.getType());
        dto.put("location", ship.getListLocation());
        return dto;
    }
    private Map<String, Object> salvoDTO( Salvo salvo){
         Map<String, Object> dto = new LinkedHashMap<>();
         dto.put("id", salvo.getId());
         dto.put("turn",salvo.getTurn());
         dto.put("player", salvo.getGamePlayer().getPlayer().getId());
         dto.put("salvoLocation", salvo.getCell());
         return dto;
    }
}
