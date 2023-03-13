package com.ajs.centroEducativo.model;

import java.sql.Date;

public class Materia {
	public int id;
	public String nombre;
	public String acronimo;
	public Curso curso;
	public Date fecha;
	public boolean aprobado;
	public String contrasena;

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
	
	
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isAprobado() {
		return aprobado;
	}
	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}
	@Override
	public String toString() {
		return "Materia " + nombre + ", " + acronimo  ;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null && this.id == ((Materia) obj).id)
			return true;
		return false;
	}	
	
	
}
