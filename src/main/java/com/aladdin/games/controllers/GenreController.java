package com.aladdin.games.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aladdin.games.entities.Game;
import com.aladdin.games.entities.Genre;
import com.aladdin.games.service.GameService;
import com.aladdin.games.service.GenreService;

@Controller
public class GenreController {
	@Autowired
	GenreService genreService;
	@Autowired
	GameService gameService;

	@RequestMapping("/CreateGenre")
	public String CreateGen(ModelMap modelMap) {

		modelMap.addAttribute("genre", new Genre());
		modelMap.addAttribute("mode", "new");

		return "formGenre";
	}

	@RequestMapping("/saveGenre")
	public String saveGenre(Genre genre) {
		genreService.saveGenre(genre);
		return "redirect:/ListeGenres";
	}

	@RequestMapping("/ListeGenres")
	public String listeGenres(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Genre> cats = genreService.getAllGenresParPage(page, size);
		modelMap.addAttribute("genres", cats);
		modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listegenre";
	}

	@RequestMapping("/supprimerGenre")
	public String supprimerGame(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		genreService.deleteGenreById(id);
		Page<Genre> cats = genreService.getAllGenresParPage(page, size);
		modelMap.addAttribute("genres", cats);
		modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listegenre";
	}

	@RequestMapping("/modifierGenre")
	public String editerGenre(@RequestParam("id") Long id, ModelMap modelMap) {
		Genre c = genreService.getGenre(id);
		modelMap.addAttribute("genre", c);
		modelMap.addAttribute("mode", "edit");
		return "formGenre";
	}

	@RequestMapping("/updateGenre")
	public String updateGenre(@ModelAttribute("genre") Genre genre, ModelMap modelMap) throws ParseException {

		genreService.updateGenre(genre);
		List<Genre> cats = genreService.getAllGenres();
		modelMap.addAttribute("genres", cats);
		return "listegenre";
	}

	@RequestMapping("/chercherGenre")

	public String chercherGenre(@RequestParam("nomGen") String nom, ModelMap modelMap)

	{

		System.out.println(nom);
		List<Game> prods = gameService.findByNomGenreContains(nom);
		System.out.println(prods);
		modelMap.addAttribute("genres", prods);

		return "chercherGen";
	}

}
