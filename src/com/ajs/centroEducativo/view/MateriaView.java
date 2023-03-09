package com.ajs.centroEducativo.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ajs.centroEducativo.controller.CursoController;
import com.ajs.centroEducativo.controller.MateriaController;
import com.ajs.centroEducativo.controller.ValoracionMateriaController;
import com.ajs.centroEducativo.model.Curso;
import com.ajs.centroEducativo.model.Materia;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class MateriaView extends JPanel {

	
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfAcronimo;
	private JComboBox<Curso> jcb;
	JButton btnLastRegister, btnNextRegister, btnBeforeRegister, btnFirstRegister;
	/**
	 * Create the panel.
	 */
	public MateriaView() {
		setBackground(new Color(192, 192, 192));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_2 = new JLabel("Gestion de Materias");
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

		JLabel lblNewLabel_1 = new JLabel(" Nombre: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfNombre = new JTextField();
		jtfNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.weightx = 1.0;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 10);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel(" Acronimo: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 3;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jtfAcronimo = new JTextField();
		jtfAcronimo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfAcronimo.setColumns(10);
		GridBagConstraints gbc_jtfAcronimo = new GridBagConstraints();
		gbc_jtfAcronimo.insets = new Insets(0, 0, 5, 10);
		gbc_jtfAcronimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAcronimo.gridx = 1;
		gbc_jtfAcronimo.gridy = 3;
		add(jtfAcronimo, gbc_jtfAcronimo);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(" Id curso: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 4;
		add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		jcb = new JComboBox<Curso>();
		jcb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcb = new GridBagConstraints();
		gbc_jcb.insets = new Insets(0, 0, 5, 10);
		gbc_jcb.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb.gridx = 1;
		gbc_jcb.gridy = 4;
		add(jcb, gbc_jcb);
		llenarJcb();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
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
				anterior();
			}
		});
		btnBeforeRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnBeforeRegister);

		btnNextRegister = new JButton(">");
		btnNextRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguiente();
			}
		});
		btnNextRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNextRegister);

		btnLastRegister = new JButton(">>");
		btnLastRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ultimoRegistro();
			}
		});
		btnLastRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnLastRegister);

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Nuevo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nuevo();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Refresh");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescar();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton_3);
		
		findFirst();

		
	
	}
	
	private void siguiente() {
		Materia m1 = new Materia(Integer.parseInt(jtfId.getText()), jtfNombre.getText(), jtfAcronimo.getText());
		mostrarMateria(MateriaController.next(m1));
	}
	
	private void guardar() {
		Materia m1 = new Materia(Integer.parseInt(jtfId.getText()), jtfNombre.getText(), jtfAcronimo.getText());
		m1.setCurso((Curso)jcb.getSelectedItem());
		MateriaController.save(m1);
	}
	
	private void nuevo() {
		jtfId.setText("0");
		jtfNombre.setText("");
		jtfAcronimo.setText("");
		jcb.setSelectedIndex(1);
	}
	
	private void findFirst() {
		mostrarMateria(MateriaController.findFirst());

	}
	
	private void ultimoRegistro() {
		mostrarMateria(MateriaController.findLast());
	}
	
	private void anterior() {
		Materia m1 = new Materia(Integer.parseInt(jtfId.getText()), jtfNombre.getText(), jtfAcronimo.getText());
		mostrarMateria(MateriaController.previous(m1));
	}
	
	private void eliminar() {
		int borrar =  JOptionPane.showConfirmDialog(null, "¿Estas seguro de borrar este registro?");
		if(borrar == 0) {
			
			Materia m1 = new Materia(Integer.parseInt(jtfId.getText()), jtfNombre.getText(), jtfAcronimo.getText());
			MateriaController.delete(m1);
		}
	}
	
	private void llenarJcb() {
		List<Curso> lc = CursoController.findAll();
		for (Curso curso : lc) {
			jcb.addItem(curso);
		}
	}
	

	
	private void mostrarMateria (Materia m) {
		jtfId.setText(""+m.getId());
		jtfNombre.setText(m.getNombre());
		jtfAcronimo.setText(m.getAcronimo());
//		jcb.setSelectedIndex(index(jcb, m.getCurso()));
		jcb.setSelectedItem(m.getCurso());
		if(m.getId() == MateriaController.findFirst().getId()) {
			btnFirstRegister.setEnabled(false);
			btnBeforeRegister.setEnabled(false);
			btnLastRegister.setEnabled(true);
			btnNextRegister.setEnabled(true);
		}
		else if(m.getId() == MateriaController.findLast().getId()) {
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
	
	private void refrescar() {
		
		llenarJcb();
	}
	
//	private int index(JComboBox<Curso> jcb, Curso c) {
//		Curso c1 = null;
//		for (int i = 0; i < jcb.getItemCount(); i++) {
//			c1 = jcb.getItemAt(i);
//			if(c1.getId() == c.getId()) 
//				return i;
//		}
//		return 0;
//	}
}
