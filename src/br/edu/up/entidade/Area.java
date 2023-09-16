package br.edu.up.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Area {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nomeArea;
	private int capacidadeEspaco;
	private int espacoLivre;
	@OneToOne
	private Regiao regiao;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "area", fetch = FetchType.LAZY)
	private List <Animal> animais;
	
	public Area() {
		this.animais = new ArrayList<Animal>();
	}
	
	
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	public List<Animal> getAnimais() {
		return animais;
	}
	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	public String getNomeArea() {
		return nomeArea;
	}
	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidadeEspaco() {
		return capacidadeEspaco;
	}
	public void setCapacidadeEspaco(int capacidadeEspaco) {
		this.capacidadeEspaco = capacidadeEspaco;
	}
	public int getEspacoLivre() {
		return espacoLivre;
	}
	public void setEspacoLivre(int espacoLivre) {
		this.espacoLivre = espacoLivre;
	}	
}
