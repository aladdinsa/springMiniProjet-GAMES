package com.aladdin.games.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aladdin.games.entities.Genre;

public interface GenreService {
	List<Genre> getAllGenres();

	Genre saveGenre(Genre genre);
	Page<Genre> getAllGenresParPage(int page, int size);
	void deleteGenreById(Long id);
	Genre getGenre(Long id);
	Genre updateGenre(Genre c);
}
