package com.aladdin.games.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aladdin.games.entities.Game;
import com.aladdin.games.entities.Genre;

@RepositoryRestResource(path = "rest")
public interface GameRepository extends JpaRepository<Game, Long> {
	
	List<Game> findByNomGameContains(String nom);

	@Query("select g from Game g where g.nomGame like %?1 and g.prixGame < ?2")
	List<Game> findByNomPrix(String nom, Double prix);

	@Query("select g from Game g where g.genre = ?1")
	List<Game> findByGenreContains(Genre genre);

	List<Game> findByGenreIdGen(Long id);
	
	
	List<Game> findByOrderByNomGameAsc();

	@Query("select g from Game g order by g.nomGame ASC, g.prixGame DESC")
	List<Game> trierGamesNomsPrix();

	@Query("select g from Game g  where g.nomGame like 'PC'")
	List<Game> findByNomGame(@Param("nomGam") String nom);

	@Query("select g from Game g where g.genre.nomGen like ?1")
	List<Game> findByNomGenreContains(String nom);
}