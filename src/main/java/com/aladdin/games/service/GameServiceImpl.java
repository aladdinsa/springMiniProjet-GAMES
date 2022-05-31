package com.aladdin.games.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aladdin.games.entities.Game;
import com.aladdin.games.entities.Genre;
import com.aladdin.games.repos.GameRepository;

@Service
public class GameServiceImpl implements GameService {
	@Autowired
	GameRepository gameRepository;

	@Override
	public Game saveGame(Game p) {
		return gameRepository.save(p);
	}

	@Override
	public Game updateGame(Game p) {
		return gameRepository.save(p);
	}

	@Override
	public void deleteGame(Game p) {
		gameRepository.delete(p);
	}

	@Override
	public void deleteGameById(Long id) {
		gameRepository.deleteById(id);
	}

	@Override
	public Game getGame(Long id) {
		return gameRepository.findById(id).get();
	}

	@Override
	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public Page<Game> getAllGamesParPage(int page, int size) {
		return gameRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Game> findByNomGameContains(String nom) {
		return gameRepository.findByNomGameContains(nom);
	}

	@Override
	public List<Game> findByNomPrix(String nom, Double prix) {
		return gameRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Game> findByGenre(Genre genre) {
		return gameRepository.findByGenreContains(genre);
	}

	@Override
	public List<Game> findByGenreIdGen(Long id) {
		return gameRepository.findByGenreIdGen(id);
	}

	@Override
	public List<Game> findByOrderByNomGameAsc() {
		return gameRepository.findByOrderByNomGameAsc();
	}

	@Override
	public List<Game> trierGamesNomsPrix() {
		return gameRepository.trierGamesNomsPrix();
	}

	@Override
	public List<Game> findByNomGame(String nom) {
		return gameRepository.findByNomGame(nom);
	}

	@Override
	public List<Game> findByNomGenreContains(String genre) {

		return gameRepository.findByNomGenreContains(genre);
	}

}
