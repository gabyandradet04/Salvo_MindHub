package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository
			, GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository, SalvoRepository salvoRepository, ScoreRepository scoreRepository) {
		return (args) -> {
			// save a couple of customers
			Player p1=new Player("j.bauer@ctu.gov");
			playerRepository.save(p1);
			Player p2 =(new Player("c.obrian@ctu.gov"));
			playerRepository.save(p2);
			Player p3 =(new Player("kim_bauer@gmail.com"));
			playerRepository.save(p3);
			Player p4=(new Player("t.almeida@ctu.gov"));
			playerRepository.save(p4);
            Game g1 = new Game (LocalDateTime.ofInstant(Instant.now(),ZoneOffset.UTC));
			gameRepository.save(g1);
            Game g2= (new Game (LocalDateTime.ofInstant(Instant.now(),ZoneOffset.UTC)));
			gameRepository.save(g2);
            Game g3=new Game (LocalDateTime.ofInstant(Instant.now(),ZoneOffset.UTC));
			gameRepository.save(g3);
			Game g4=(new Game (LocalDateTime.ofInstant(Instant.now(),ZoneOffset.UTC)));
			gameRepository.save(g4);
			Game g5=(new Game (LocalDateTime.ofInstant(Instant.now(),ZoneOffset.UTC)));
			gameRepository.save(g5);
			//Ship s1 = new Ship ("Submarine", Arrays.asList("E1","F1", "G1"));
			//shipRepository.save(s1);
			//Ship s2 = new Ship ("Patrol Boat", Arrays.asList("B4", "B5"));
			//shipRepository.save(s2);
			//Ship s3 = new Ship ("Destroyer", Arrays.asList("B5","C5", "D5"));
			//shipRepository.save(s3);
			//********************SHIPS********************
			Set<Ship> ships1=new HashSet<Ship>();
			ships1.add(new Ship ("Destroyer", Arrays.asList("H2","H3","H4")));
			ships1.add(new Ship ("Submarine", Arrays.asList("E1","F1", "G1")));
			ships1.add( new Ship ("Patrol Boat", Arrays.asList("B4", "B5")));
			Set<Ship> ships2=new HashSet<Ship>();
			ships2.add(new Ship ("Destroyer", Arrays.asList("B5","C5", "D5")));
			ships2.add(new Ship ("Patrol Boat", Arrays.asList("F1", "F2")));
			Set<Ship> ships3=new HashSet<Ship>();
			ships3.add(new Ship ("Destroyer", Arrays.asList("B5","C5", "D5")));
			ships3.add(new Ship ("Patrol Boat", Arrays.asList("C6","C7")));
			Set<Ship> ships4=new HashSet<Ship>();
			ships4.add(new Ship ("Submarine", Arrays.asList("A2","A3","A4")));
			ships4.add(new Ship ("Patrol Boat", Arrays.asList("G6","H6")));
			Set<Ship> ships5=new HashSet<Ship>();
			ships5.add(new Ship ("Destroyer", Arrays.asList("B5","C5", "D5")));
			ships5.add(new Ship ("Patrol Boat", Arrays.asList("C6","C7")));
			Set<Ship> ships6=new HashSet<Ship>();
			ships6.add(new Ship ("Submarine", Arrays.asList("A2","A3","A4")));
			ships6.add(new Ship ("Patrol Boat", Arrays.asList("G6","H6")));
			Set<Ship> ships7=new HashSet<Ship>();
			ships7.add(new Ship ("Destroyer", Arrays.asList("B5","C5", "D5")));
			ships7.add(new Ship ("Patrol Boat", Arrays.asList("C6","C7")));
			Set<Ship> ships8=new HashSet<Ship>();
			ships8.add(new Ship ("Submarine", Arrays.asList("A2","A3","A4")));
			ships8.add(new Ship ("Patrol Boat", Arrays.asList("G6","H6")));
			//***************************SALVO****************************************
			Set<Salvo> salvo1 = new HashSet<Salvo>();
			salvo1.add(new Salvo(1, Arrays.asList("B5","C5","F1")));
			salvo1.add(new Salvo(2, Arrays.asList("F2","D5")));
			Set<Salvo> salvo2 = new HashSet<Salvo>();
			salvo2.add(new Salvo(1, Arrays.asList("B4","B5","B6")));
			salvo2.add(new Salvo(2, Arrays.asList("E1","H3","A2")));
			Set<Salvo> salvo3 = new HashSet<Salvo>();
			salvo3.add(new Salvo(1, Arrays.asList("A2","A4","G6")));
			salvo3.add(new Salvo(2, Arrays.asList("A3","H6")));
			Set<Salvo> salvo4 = new HashSet<Salvo>();
			salvo4.add(new Salvo(1, Arrays.asList("B4","D5","C7")));
			salvo4.add(new Salvo(2, Arrays.asList("C5","C6")));
			Set<Salvo> salvo5 = new HashSet<Salvo>();
			salvo5.add(new Salvo(1, Arrays.asList("G6","H6","A4")));
			salvo5.add(new Salvo(2, Arrays.asList("A2","A3","D8")));
			Set<Salvo> salvo6 = new HashSet<Salvo>();
			salvo6.add(new Salvo(1, Arrays.asList("H1","H2","H3")));
			salvo6.add(new Salvo(2, Arrays.asList("E1","F2","G3")));
			Set<Salvo> salvo7 = new HashSet<Salvo>();
			salvo7.add(new Salvo(1, Arrays.asList("A3","A4","F7")));
			salvo7.add(new Salvo(2, Arrays.asList("A2","G6","H6")));
			Set<Salvo> salvo8 = new HashSet<Salvo>();
			salvo8.add(new Salvo(1, Arrays.asList("B5","C6","H1")));
			salvo8.add(new Salvo(2, Arrays.asList("C5","C7","D5")));
			//****************************SCORE*****************
            Score scor1= new Score(g1,p1,1.0F,LocalDateTime.now());
            scoreRepository.save(scor1);
            Score scor2= new Score(g1,p2,0.0F,LocalDateTime.now());
            scoreRepository.save(scor2);
            Score scor3= new Score(g2,p1,0.0F,LocalDateTime.now());
            scoreRepository.save(scor3);
			Score scor4= new Score(g2,p2,1.0F,LocalDateTime.now());
			scoreRepository.save(scor4);
			Score scor5= new Score(g3 ,p2,0.5F,LocalDateTime.now());
			scoreRepository.save(scor5);
			Score scor6= new Score(g3 ,p4,0.5F,LocalDateTime.now());
			scoreRepository.save(scor6);
			Score scor7= new Score(g4,p2,1.0F,LocalDateTime.now());
			scoreRepository.save(scor7);
			Score scor8= new Score(g4,p1,0.0F,LocalDateTime.now());
			scoreRepository.save(scor8);
			//****************GAMEPLAYER****************************************************
            gamePlayerRepository.save( new GamePlayer(LocalDateTime.now(),g1 ,p1,ships1, salvo1));
			gamePlayerRepository.save( new GamePlayer(LocalDateTime.now(),g1 ,p2,ships2, salvo2));
			gamePlayerRepository.save( new GamePlayer(LocalDateTime.now(),g2 ,p1,ships3, salvo3));
			gamePlayerRepository.save( new GamePlayer(LocalDateTime.now(),g2 ,p2,ships4, salvo4));
			gamePlayerRepository.save( new GamePlayer(LocalDateTime.now(),g3 ,p2,ships5, salvo5));
			gamePlayerRepository.save( new GamePlayer(LocalDateTime.now(),g3 ,p4,ships6, salvo6));
			gamePlayerRepository.save( new GamePlayer(LocalDateTime.now(),g4 ,p2,ships7, salvo7));
			gamePlayerRepository.save( new GamePlayer(LocalDateTime.now(),g4 ,p1,ships8, salvo8));




		};
	}


}
