package com.ajs.centroEducativo.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ajs.centroEducativo.controller.EstudianteController;
import com.ajs.centroEducativo.controller.MateriaController;
import com.ajs.centroEducativo.controller.ProfesorController;
import com.ajs.centroEducativo.controller.ValoracionMateriaController;
import com.ajs.centroEducativo.model.Estudiante;
import com.ajs.centroEducativo.model.Materia;
import com.ajs.centroEducativo.model.Profesor;
import com.ajs.centroEducativo.model.ValoracionMateria;

import javax.swing.JComboBox;

public class ValoracionMateriaView extends JPanel {
	private JTextField jtfId;
	private JTextField jtfValoracion;
	private JComboBox jcbProfesor, jcbEstudiante, jcbMateria;
	private JButton btnFirstRegister, btnBeforeRegister, btnNextRegister, btnLastRegister;
	/**
	 * Create the panel.
	 */
	public ValoracionMateriaView() {
		setBackground(new Color(192, 192, 192));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_2 = new JLabel("Gestion de Valoración de Materias");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 50));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("ID: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		jtfId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.insets = new Insets(0, 0, 5, 10);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel(" Id profesor: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox();
		jcbProfesor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 10);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 2;
		add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNewLabel_1_1 = new JLabel(" Id estudiante: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 3;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jcbEstudiante = new JComboBox();
		jcbEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbEstudiante = new GridBagConstraints();
		gbc_jcbEstudiante.insets = new Insets(0, 0, 5, 10);
		gbc_jcbEstudiante.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbEstudiante.gridx = 1;
		gbc_jcbEstudiante.gridy = 3;
		add(jcbEstudiante, gbc_jcbEstudiante);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(" Id materia: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 4;
		add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		jcbMateria = new JComboBox();
		jcbMateria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 10);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 4;
		add(jcbMateria, gbc_jcbMateria);
		
		llenarJcbs();
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(" Valoracion: ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1.gridy = 5;
		add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);
		
		jtfValoracion = new JTextField();
		jtfValoracion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfValoracion.setColumns(10);
		GridBagConstraints gbc_jtfValoracion = new GridBagConstraints();
		gbc_jtfValoracion.insets = new Insets(0, 0, 5, 10);
		gbc_jtfValoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfValoracion.gridx = 1;
		gbc_jtfValoracion.gridy = 5;
		add(jtfValoracion, gbc_jtfValoracion);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnFirstRegister = new JButton("<<");
		btnFirstRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findFirst();
			}
		});
		btnFirstRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnFirstRegister);

		btnBeforeRegister = new JButton("<");
		btnBeforeRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previous();
			}
		});
		btnBeforeRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnBeforeRegister);

		btnNextRegister = new JButton(">");
		btnNextRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNextRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNextRegister);

		btnLastRegister = new JButton(">>");
		btnLastRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findLast();
			}
		});
		btnLastRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnLastRegister);

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
				if(Integer.parseInt(jtfId.getText()) == 0) {
					findLast();
				}
				else {
					mostrarRegistroActual();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Nuevo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newRegister();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton_2);
		
		findFirst();
	}
	
	private void findFirst() {
		mostrarValoracionMateria(ValoracionMateriaController.findFirst());
	}
	
	private void next() {
		ValoracionMateria vm1 = new ValoracionMateria();
		vm1.setId(Integer.parseInt(jtfId.getText()));
		mostrarValoracionMateria(ValoracionMateriaController.next(vm1));
	}
	
	private void previous() {
		ValoracionMateria vm1 = new ValoracionMateria();
		vm1.setId(Integer.parseInt(jtfId.getText()));
		mostrarValoracionMateria(ValoracionMateriaController.previous(vm1));
	}
	
	private void findLast() {
		mostrarValoracionMateria(ValoracionMateriaController.findLast());
	}
	
	private void save() {
		ValoracionMateria vm1 = new ValoracionMateria();
		vm1.setId(Integer.parseInt(jtfId.getText()));
		vm1.setEstudiante((Estudiante)jcbEstudiante.getSelectedItem());
		vm1.setProfesor((Profesor)jcbProfesor.getSelectedItem());
		vm1.setMateria((Materia)jcbMateria.getSelectedItem());
		vm1.setValoracion(Float.parseFloat(jtfValoracion.getText()));
		ValoracionMateriaController.save(vm1);
				
	}
	
	private void mostrarRegistroActual() {
		ValoracionMateria vm1 = new ValoracionMateria();
		vm1.setId(Integer.parseInt(jtfId.getText()));
		vm1.setEstudiante((Estudiante)jcbEstudiante.getSelectedItem());
		vm1.setProfesor((Profesor)jcbProfesor.getSelectedItem());
		vm1.setMateria((Materia)jcbMateria.getSelectedItem());
		vm1.setValoracion(Float.parseFloat(jtfValoracion.getText()));
		mostrarValoracionMateria(ValoracionMateriaController.actual(vm1));
	}
	
	private void newRegister() {
		jtfId.setText("0");
		jtfValoracion.setText("");
		jcbProfesor.setSelectedIndex(0);
		jcbEstudiante.setSelectedIndex(0);
		jcbMateria.setSelectedIndex(0);
	}
	
	private void delete() {
		int borrar =  JOptionPane.showConfirmDialog(null, "¿Estas seguro de borrar este registro?");
		if(borrar == 0) {
			ValoracionMateria vm1 = new ValoracionMateria();
			vm1.setId(Integer.parseInt(jtfId.getText()));
			ValoracionMateriaController.delete(vm1);
		}
		
		previous();
	}
	
	private void mostrarValoracionMateria(ValoracionMateria vm) {
		jtfId.setText(""+vm.getId());
		jtfValoracion.setText(""+vm.getValoracion());
		jcbProfesor.setSelectedItem(vm.getProfesor());
		jcbEstudiante.setSelectedItem(vm.getEstudiante());
		jcbMateria.setSelectedItem(vm.getMateria());
		
		if(vm.getId() == ValoracionMateriaController.findFirst().getId()) {
			btnFirstRegister.setEnabled(false);
			btnBeforeRegister.setEnabled(false);
			btnLastRegister.setEnabled(true);
			btnNextRegister.setEnabled(true);
		}
		else if(vm.getId() == ValoracionMateriaController.findLast().getId()) {
			btnLastRegister.setEnabled(false);
			btnNextRegister.setEnabled(false);
			btnFirstRegister.setEnabled(true);
			btnBeforeRegister.setEnabled(true);
		}
		else {
			btnLastRegister.setEnabled(true);
			btnNextRegister.setEnabled(true);
			btnFirstRegister.setEnabled(true);
			btnBeforeRegister.setEnabled(true);
		}
	}
	
	private void llenarJcbs () {
		List<Profesor> lp = ProfesorController.findAll();
		for (Profesor profesor : lp) {
			jcbProfesor.addItem(profesor);
		}
		
		List<Estudiante> le = EstudianteController.findAll();
		for (Estudiante estudiante : le) {
			jcbEstudiante.addItem(estudiante);
		}
		
		List<Materia> lm = MateriaController.findAll();
		for (Materia materia : lm) {
			jcbMateria.addItem(materia);
		}
	}

}
