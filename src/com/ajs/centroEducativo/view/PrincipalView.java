package com.ajs.centroEducativo.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;




public class PrincipalView extends JFrame {

	
	public PrincipalView () {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(getPanelesTabulados());
	}
	
	public static JTabbedPane getPanelesTabulados () {
		
		JTabbedPane tabPanel = new JTabbedPane();		
		
		tabPanel.addTab("Tabla Curso", new CursoView());
		tabPanel.addTab("Tabla Estudiante", new EstudianteView());
		tabPanel.addTab("Tabla Profesor", new ProfesorView());
		tabPanel.addTab("Tabla Materia", new MateriaView());
		tabPanel.addTab("Tabla Valoracion Materia", new ValoracionMateriaView());
		tabPanel.addTab("Prueba", new PruebaView());
		
		
		return tabPanel;
	}
}
