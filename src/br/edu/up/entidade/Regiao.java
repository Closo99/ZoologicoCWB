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

@Entity
public class Regiao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nomeRegiao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "regiao", fetch = FetchType.LAZY)
	private List<Area> areas;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "regiao", fetch = FetchType.LAZY)
	private List<Edificio> edificios;
	
	public Regiao() {
		this.areas = new ArrayList<Area>();
		this.edificios = new ArrayList<Edificio>();
	}
	
	
	public List<Area> getAreas() {
		return areas;
	}
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	public List<Edificio> getEdificios() {
		return edificios;
	}
	public void setEdificios(List<Edificio> edificios) {
		this.edificios = edificios;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeRegiao() {
		return nomeRegiao;
	}
	public void setNomeRegiao(String nomeRegiao) {
		this.nomeRegiao = nomeRegiao;
	}
}
