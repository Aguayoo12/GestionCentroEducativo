package com.ajs.centroEducativo.view;

import javax.swing.JPanel;


import com.ajs.centroEducativo.controller.CursoController;
import com.ajs.centroEducativo.controller.MateriaController;
import com.ajs.centroEducativo.controller.PruebaController;
import com.ajs.centroEducativo.model.Curso;
import com.ajs.centroEducativo.model.Materia;


import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class PruebaView extends JPanel {
	JComboBox <Materia> jcbMaterias;
	JComboBox <Curso> jcbCursos;
	private JTextField jtfNombre;
	private JTextField jtfAcronimo;
	private JTextField jtfFecha;
	private JCheckBox chkAprobado;
	
	private com.ajs.centroEducativo.CacheImagenes cacheImagenes;
	private JPasswordField jpfContrasena;
	/**
	 * Create the panel.
	 */
	public PruebaView() {
		cacheImagenes = new com.ajs.centroEducativo.CacheImagenes();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_2 = new JLabel("MATERIAS DISPONIBLES SEGUN EL CURSO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Materias");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMaterias = new JComboBox();
		jcbMaterias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbMaterias = new GridBagConstraints();
		gbc_jcbMaterias.weightx = 1.0;
		gbc_jcbMaterias.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMaterias.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMaterias.gridx = 1;
		gbc_jcbMaterias.gridy = 1;
		add(jcbMaterias, gbc_jcbMaterias);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantallaMateria();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 1;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Cursos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbCursos = new JComboBox();
		jcbCursos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbCursos = new GridBagConstraints();
		gbc_jcbCursos.weightx = 1.0;
		gbc_jcbCursos.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCursos.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCursos.gridx = 1;
		gbc_jcbCursos.gridy = 2;
		add(jcbCursos, gbc_jcbCursos);
		
		JButton btnNewButton = new JButton("Ver Materias");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = (Curso)jcbCursos.getSelectedItem();
				verMateriasPorCurso(c.getId());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 10);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfNombre = new JTextField();
		jtfNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 3;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Acronimo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfAcronimo = new JTextField();
		jtfAcronimo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfAcronimo = new GridBagConstraints();
		gbc_jtfAcronimo.gridwidth = 2;
		gbc_jtfAcronimo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAcronimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAcronimo.gridx = 1;
		gbc_jtfAcronimo.gridy = 4;
		add(jtfAcronimo, gbc_jtfAcronimo);
		jtfAcronimo.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Fecha");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1.gridx = 0;
		gbc_lblNewLabel_4_1.gridy = 5;
		add(lblNewLabel_4_1, gbc_lblNewLabel_4_1);
		
		jtfFecha = new JTextField();
		jtfFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfFecha.setColumns(10);
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 5;
		add(jtfFecha, gbc_jtfFecha);
		
		chkAprobado = new JCheckBox("Aprobado");
		chkAprobado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_chkAprobado = new GridBagConstraints();
		gbc_chkAprobado.gridwidth = 3;
		gbc_chkAprobado.insets = new Insets(0, 0, 5, 0);
		gbc_chkAprobado.gridx = 0;
		gbc_chkAprobado.gridy = 6;
		add(chkAprobado, gbc_chkAprobado);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Contraseña");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1_1.gridx = 0;
		gbc_lblNewLabel_4_1_1.gridy = 7;
		add(lblNewLabel_4_1_1, gbc_lblNewLabel_4_1_1);
		
		jpfContrasena = new JPasswordField();
		jpfContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jpfContrasena = new GridBagConstraints();
		gbc_jpfContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_jpfContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpfContrasena.gridx = 1;
		gbc_jpfContrasena.gridy = 7;
		add(jpfContrasena, gbc_jpfContrasena);
		
		JButton btnNewButton_3 = new JButton("Validar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarContrasena();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 7;
		add(btnNewButton_3, gbc_btnNewButton_3);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		add(panel, gbc_panel);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String posiblesRespuestas[] = {"Sí","No", "Salir Programa"};
				int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea guardar el registro?", "Guardar", 
				        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, cacheImagenes.getIcono("guardar(1).png"), posiblesRespuestas, posiblesRespuestas[1]);
			    if(opcionElegida == 0) {
			      System.out.println("hola");      
			    }
			}
		});
		panel.add(btnNewButton_2);
		

		llenarJcbCurso();
	}

	private void llenarJcbCurso() {
		List<Curso> lc = CursoController.findAll();
		for (Curso curso : lc) {
			jcbCursos.addItem(curso);
		}
	}
	
	private void llenarJcbMateria() {
		List<Materia> lm = MateriaController.findAll();
		for (Materia materia : lm) {
			jcbMaterias.addItem(materia);
		}
		
	}
	
	private void verMateriasPorCurso(int id) {
		List<Materia> lm = PruebaController.MateriasPorCurso(id);
		for (Materia materia : lm) {
			jcbMaterias.addItem(materia);
		}

	}
	
	private void cargarEnPantallaMateria() {
		Materia m = (Materia) jcbMaterias.getSelectedItem();
		jtfNombre.setText(m.getNombre());
		jtfAcronimo.setText(m.getAcronimo());
		jtfFecha.setText(new SimpleDateFormat("dd/MM/yyy").format(m.getFecha()));
		chkAprobado.setSelected(m.isAprobado());
		jpfContrasena.setText(m.getContrasena());
		
	}
	
	private void validarContrasena() {
		String posiblesRespuestas[] = {"Ok", "Salir Programa"};
		String str = jpfContrasena.getText();
		int contMayus = 0, contMinus = 0, contNum = 0, contNoAlfa = 0;
		String str1[] = str.split("[ ]{1,}");
		for (int i = 0; i < str1.length; i++) {
			char[] letra = str1[i].toCharArray();
			contMayus = 0;
			contMinus = 0;
			contNum = 0;
			contNoAlfa = 0;
			for (int j = 0; j < letra.length; j++) {
				if (Character.isUpperCase(letra[j]))
					contMayus++;
				if (Character.isLowerCase(letra[j]))
					contMinus++;
				if (Character.isDigit(letra[j]))
					contNum++;
				if (!Character.isLetterOrDigit(letra[j]))
					contNoAlfa++;
			}
			if (contMayus > 0 && contMinus > 1 && contNum > 0 && contNoAlfa > 0) {
				
			}
			else	JOptionPane.showOptionDialog(null, "La contraseña no cumple con los requisitos minimos", "Contraseña", 
				        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, cacheImagenes.getIcono("guardar(1).png"), posiblesRespuestas, posiblesRespuestas[0]);
		}
	}
}
