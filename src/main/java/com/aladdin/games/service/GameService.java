package com.aladdin.games.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aladdin.games.entities.Game;
import com.aladdin.games.entities.Genre;

public interface GameService {

	Game saveGame(Game p);
	Game updateGame(Game p);
	void deleteGame(Game p);
	void deleteGameById(Long id);
	Game getGame(Long id);
	List<Game> getAllGames();
	List<Game> findByNomGameContains(String nom);
	List<Game> findByNomPrix (String nom, Double prix);
	List<Game> findByGenre (Genre genre);
	List<Game> findByGenreIdGen(Long id);
	List<Game> findByOrderByNomGameAsc();
	List<Game> trierGamesNomsPrix();
	 List<Game> findByNomGame(String nom);
	List<Game> findByNomGenreContains (String nom);

	
	
	Page<Game> getAllGamesParPage(int page, int size);
	
}
