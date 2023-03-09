package com.ajs.centroEducativo.model;

public class ValoracionMateria {
	private int id;
	private float valoracion;
	private Materia materia;
	private Profesor profesor;
	private Estudiante estudiante;
	
	/*
	 * 
	 */
	public ValoracionMateria() {
		super();
	}
	public ValoracionMateria(int id, float valoracion) {
		super();
		this.id = id;
		this.valoracion = valoracion;
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
	public float getValoracion() {
		return valoracion;
	}
	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	@Override
	public String toString() {
		return "ValoracionMateria [id=" + id + ", valoracion=" + valoracion + ", materia=" + materia + ", profesor="
				+ profesor + ", estudiante=" + estudiante + "]";
	}
	
	
	
	


}
