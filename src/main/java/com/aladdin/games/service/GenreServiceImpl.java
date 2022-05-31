package com.aladdin.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aladdin.games.entities.Genre;
import com.aladdin.games.repos.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	GenreRepository genreRepository;

	@Override
	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}

	@Override
	public Genre saveGenre(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	public Page<Genre> getAllGenresParPage(int page, int size) {
		return genreRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public void deleteGenreById(Long id) {
		genreRepository.deleteById(id);
	}

	@Override
	public Genre getGenre(Long id) {
		return genreRepository.findById(id).get();
	}

	@Override
	public Genre updateGenre(Genre c) {
		return genreRepository.save(c);
	}

}
