package com.aladdin.games.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGame;
	@NotNull
	@Size(min = 4, max = 50)
	@Column(unique = true)
	private String nomGame;
	@NotNull
	@Size(min = 4, max = 50)
	private String publisher;
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixGame;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent

	private Date dateCreation;
	@ManyToOne
	private Genre genre;

	public Game() {
		super();
	}

	public Game(String nomGame, Double prixGame, Date dateCreation, Genre cat) {
		super();
		this.nomGame = nomGame;
		this.prixGame = prixGame;
		this.dateCreation = dateCreation;
		this.setGenre(cat);
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Long getIdGame() {
		return idGame;
	}

	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}

	public String getNomGame() {
		return nomGame;
	}

	public void setNomGame(String nomGame) {
		this.nomGame = nomGame;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Double getPrixGame() {
		return prixGame;
	}

	public void setPrixGame(Double prixGame) {
		this.prixGame = prixGame;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
}