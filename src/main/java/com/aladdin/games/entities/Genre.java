package com.aladdin.games.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGen;
	@Column(unique = true)

	private String nomGen;
	private String descriptionGen;
	@JsonIgnore
	@OneToMany(mappedBy = "genre")
	private List<Game> games;

	public Long getIdGen() {
		return idGen;
	}

	public void setIdGen(Long idGen) {
		this.idGen = idGen;
	}

	public String getNomGen() {
		return nomGen;
	}

	public void setNomGen(String nomGen) {
		this.nomGen = nomGen;
	}

	public String getDescriptionGen() {
		return descriptionGen;
	}

	public void setDescriptionGen(String descriptionGen) {
		this.descriptionGen = descriptionGen;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
}
