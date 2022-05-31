package com.aladdin.games.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aladdin.games.entities.Game;
import com.aladdin.games.entities.Genre;
import com.aladdin.games.service.GameService;
import com.aladdin.games.service.GenreService;

@Controller
public class GameController {
	@Autowired
	GameService gameService;
	@Autowired
	GenreService genreService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("game", new Game());
		modelMap.addAttribute("mode", "new");
		List<Genre> genre = genreService.getAllGenres();

		modelMap.addAttribute("genres", genre);
		return "formGame";
	}

	@RequestMapping("/saveGame")
	public String saveGame(@Valid Game game, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formGame";

		gameService.saveGame(game);
		return "redirect:/ListeGames";
	}

	@RequestMapping("/ListeGames")
	public String listeGames(ModelMap modelMap,

			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{
		Page<Game> prods = gameService.getAllGamesParPage(page, size);
		modelMap.addAttribute("games", prods);

		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);

		modelMap.addAttribute("currentPage", page);

		return "listeGames";
	}

	@RequestMapping("/supprimerGame")
	public String supprimerGame(@RequestParam("id") Long id,

			ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{
		gameService.deleteGameById(id);
		Page<Game> prods = gameService.getAllGamesParPage(page,

				size);

		modelMap.addAttribute("games", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeGames";
	}

	@RequestMapping("/modifierGame")
	public String editerGame(@RequestParam("id") Long id, ModelMap modelMap) {
		Game p = gameService.getGame(id);
		modelMap.addAttribute("game", p);
		modelMap.addAttribute("mode", "edit");

		List<Genre> cats = genreService.getAllGenres();

		modelMap.addAttribute("genres", cats);
		return "formGame";
	}

	@RequestMapping("/updateGame")
	public String updateGame(@ModelAttribute("game") Game game, @RequestParam("date") String date, ModelMap modelMap)
			throws ParseException

	{

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		game.setDateCreation(dateCreation);
		gameService.updateGame(game);
		List<Game> prods = gameService.getAllGames();
		modelMap.addAttribute("games", prods);
		return "listeGames";

	}

	@RequestMapping("/chercherNom")
	public String chercherGame(@RequestParam("nomGam") String nom, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{

		List<Game> prods = gameService.findByNomGameContains(nom);

		modelMap.addAttribute("Games", prods);
		System.out.println(prods);

		return "resultat";
	}

	@RequestMapping("/chercherNomPrix")
	public String chercherGame(@RequestParam("nomProd") String nom, @RequestParam("PrixProd") String prix,
			ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{
		System.out.println(nom + "        " + prix);
		double p = Double.parseDouble(prix);
		List<Game> prods = gameService.findByNomPrix(nom, p);
		System.out.println(prods);
		modelMap.addAttribute("Game", prods);

		return "ChercherNOMPRIX";
	}

	@RequestMapping("/filter")
	public String findByOrderByNomGameAsc(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{

		List<Game> prods = gameService.findByOrderByNomGameAsc();
		System.out.println(prods);
		modelMap.addAttribute("Game", prods);
		System.out.println(prods);
		return "filternom";
	}

}