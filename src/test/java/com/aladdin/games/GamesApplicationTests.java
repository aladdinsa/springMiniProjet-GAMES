package com.aladdin.games;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aladdin.games.entities.Game;
import com.aladdin.games.repos.GameRepository;

@SpringBootTest
class GamesApplicationTests {
	@Autowired
	private GameRepository gameRepository;
//	@Autowired
//	private GameService gameService;

	@Test
	public void testFindGame() {
		Game p = gameRepository.findById(1L).get();

		System.out.println(p);
	}

	@Test
	public void testUpdateGame() {
		Game p = gameRepository.findById(1L).get();
		p.setPrixGame(1000.0);
		gameRepository.save(p);
	}

	@Test
	public void testDeleteGame() {
		gameRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousGames() {
		List<Game> prods = gameRepository.findAll();
		for (Game p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testFindByNomGame() {
		List<Game> prods = gameRepository.findByNomGame("Imprimante Epson");
		for (Game p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomGameContains() {
		List<Game> prods = gameRepository.findByNomGameContains("Dell");
		for (Game p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testfindByNomPrix() {
		List<Game> prods = gameRepository.findByNomPrix("PC Dell", 1000.0);
		for (Game p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void findByGenreIdGen() {
		List<Game> prods = gameRepository.findByGenreIdGen(1L);
		for (Game p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByOrderByNomGameAsc() {
		List<Game> prods = gameRepository.findByOrderByNomGameAsc();
		for (Game p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testTrierGamesNomsPrix() {
		List<Game> prods = gameRepository.trierGamesNomsPrix();
		for (Game p : prods) {
			System.out.println(p);
		}
	}

}