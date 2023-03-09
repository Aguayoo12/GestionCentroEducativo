package com.ajs.centroEducativo.model;

public class Materia {
	public int id;
	public String nombre;
	public String acronimo;
	public Curso curso;
	
	

	/*
	 * 
	 */
	public Materia() {
		super();
	}
	public Materia(int id, String nombre, String acronimo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.acronimo = acronimo;

	}
	
	
	/*
	 * 
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return "Materia " + nombre + ", " + acronimo  ;
	}
	@Override
	public boolean equals(Object obj) {
		return this.id == ((Materia) obj).id;
	}	
	
	
}
