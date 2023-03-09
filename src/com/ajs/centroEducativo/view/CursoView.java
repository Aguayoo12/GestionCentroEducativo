package com.ajs.centroEducativo.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ajs.centroEducativo.controller.CursoController;
import com.ajs.centroEducativo.model.Curso;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;

public class CursoView extends JPanel {
	private JTextField jtfId;
	private JTextField jtfDescipcion;
	/**
	 * Create the panel.
	 */
	public CursoView() {
		setBackground(new Color(192, 192, 192));
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_2 = new JLabel("Gestion de Cursos");
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

		JLabel lblNewLabel_1 = new JLabel("Descipcion: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfDescipcion = new JTextField();
		jtfDescipcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfDescipcion = new GridBagConstraints();
		gbc_jtfDescipcion.weightx = 1.0;
		gbc_jtfDescipcion.insets = new Insets(0, 0, 5, 10);
		gbc_jtfDescipcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescipcion.gridx = 1;
		gbc_jtfDescipcion.gridy = 2;
		add(jtfDescipcion, gbc_jtfDescipcion);
		jtfDescipcion.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnFirstRegister = new JButton("<<");
		btnFirstRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findFirst();
			}
		});
		btnFirstRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnFirstRegister);

		JButton btnBeforeRegister = new JButton("<");
		btnBeforeRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = new Curso(Integer.parseInt(jtfId.getText()), jtfDescipcion.getText());
				Curso c1 = CursoController.previous(c);
				if(c1 != null) {
					jtfId.setText(""+c1.getId());
					jtfDescipcion.setText(c1.getDescripcion());
				}
			}
		});
		btnBeforeRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnBeforeRegister);

		JButton btnNextRegister = new JButton(">");
		btnNextRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = new Curso(Integer.parseInt(jtfId.getText()), jtfDescipcion.getText());
				Curso c1 = CursoController.next(c);
				if(c1 != null) {
					jtfId.setText(""+c1.getId());
					jtfDescipcion.setText(c1.getDescripcion());
				}
			}
		});
		btnNextRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNextRegister);

		JButton btnLastRegister = new JButton(">>");
		btnLastRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = CursoController.findLast();
				jtfId.setText(""+c.getId());
				jtfDescipcion.setText(c.getDescripcion());
			}
		});
		btnLastRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnLastRegister);

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = new Curso(Integer.parseInt(jtfId.getText()), jtfDescipcion.getText());
				CursoController.save(c);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Nuevo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfId.setText(""+0);
				jtfDescipcion.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int borrar =  JOptionPane.showConfirmDialog(null, "¿Estas seguro de borrar este registro?");
				if(borrar == 0) {
					Curso c = new Curso(Integer.parseInt(jtfId.getText()), jtfDescipcion.getText());
					CursoController.delete(c);
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton_2);
		
		findFirst();

	}
	
	private void findFirst () {
		Curso c = CursoController.findFirst();
		jtfId.setText(""+c.getId());
		jtfDescipcion.setText(c.getDescripcion());
	}
	
	
}
