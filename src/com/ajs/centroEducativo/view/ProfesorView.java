package com.ajs.centroEducativo.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ajs.centroEducativo.controller.ProfesorController;
import com.ajs.centroEducativo.model.Profesor;

public class ProfesorView extends JPanel {

	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	/**
	 * Create the panel.
	 */
	public ProfesorView() {
		setBackground(new Color(192, 192, 192));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel_2 = new JLabel("Gestion de Profesor");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 50));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("ID:  ");
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

		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
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

		JLabel lblNewLabel_3 = new JLabel(" Primer Apellido: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfApellido1 = new JTextField();
		jtfApellido1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 10);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 3;
		add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel(" Segundo Apellido: ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 0;
		gbc_lblNewLabel_3_1.gridy = 4;
		add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);

		jtfApellido2 = new JTextField();
		jtfApellido2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfApellido2.setColumns(10);
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 10);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 4;
		add(jtfApellido2, gbc_jtfApellido2);

		JLabel lblNewLabel_3_1_1 = new JLabel(" DNI: ");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_1.gridx = 0;
		gbc_lblNewLabel_3_1_1.gridy = 5;
		add(lblNewLabel_3_1_1, gbc_lblNewLabel_3_1_1);

		jtfDni = new JTextField();
		jtfDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfDni.setColumns(10);
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 10);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		add(jtfDni, gbc_jtfDni);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Direccion: ");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_1_1.gridx = 0;
		gbc_lblNewLabel_3_1_1_1.gridy = 6;
		add(lblNewLabel_3_1_1_1, gbc_lblNewLabel_3_1_1_1);

		jtfDireccion = new JTextField();
		jtfDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfDireccion.setColumns(10);
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 10);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 6;
		add(jtfDireccion, gbc_jtfDireccion);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Email: ");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_3_1_1_1_1.gridy = 7;
		add(lblNewLabel_3_1_1_1_1, gbc_lblNewLabel_3_1_1_1_1);

		jtfEmail = new JTextField();
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfEmail.setColumns(10);
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 10);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		add(jtfEmail, gbc_jtfEmail);

		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Telefono: ");
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_3_1_1_1_1_1.gridy = 8;
		add(lblNewLabel_3_1_1_1_1_1, gbc_lblNewLabel_3_1_1_1_1_1);

		jtfTelefono = new JTextField();
		jtfTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfTelefono.setColumns(10);
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 10);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 8;
		add(jtfTelefono, gbc_jtfTelefono);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
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
				Profesor e2 = new Profesor(Integer.parseInt(jtfId.getText()), jtfNombre.getText(), jtfApellido1.getText(), jtfApellido2.getText(),
						jtfDni.getText(), jtfDireccion.getText(), jtfEmail.getText(), jtfTelefono.getText());
				Profesor e1 = ProfesorController.previous(e2);
				if(e1 != null) {
					jtfId.setText("" + e1.getId());
					jtfNombre.setText(e1.getNombre());
					jtfApellido1.setText(e1.getApellido1());
					jtfApellido2.setText(e1.getApellido2());
					jtfDni.setText(e1.getDni());
					jtfDireccion.setText(e1.getDireccion());
					jtfEmail.setText(e1.getEmail());
					jtfTelefono.setText(e1.getTelefono());
				}
			}
		});
		btnBeforeRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnBeforeRegister);

		JButton btnNextRegister = new JButton(">");
		btnNextRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profesor e2 = new Profesor(Integer.parseInt(jtfId.getText()), jtfNombre.getText(), jtfApellido1.getText(), jtfApellido2.getText(),
						jtfDni.getText(), jtfDireccion.getText(), jtfEmail.getText(), jtfTelefono.getText());
				Profesor e1 = ProfesorController.next(e2);
				if(e1 != null) {
					jtfId.setText("" + e1.getId());
					jtfNombre.setText(e1.getNombre());
					jtfApellido1.setText(e1.getApellido1());
					jtfApellido2.setText(e1.getApellido2());
					jtfDni.setText(e1.getDni());
					jtfDireccion.setText(e1.getDireccion());
					jtfEmail.setText(e1.getEmail());
					jtfTelefono.setText(e1.getTelefono());
				}
			}
		});
		btnNextRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNextRegister);

		JButton btnLastRegister = new JButton(">>");
		btnLastRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profesor e1 = ProfesorController.findLast();
				jtfId.setText("" + e1.getId());
				jtfNombre.setText(e1.getNombre());
				jtfApellido1.setText(e1.getApellido1());
				jtfApellido2.setText(e1.getApellido2());
				jtfDni.setText(e1.getDni());
				jtfDireccion.setText(e1.getDireccion());
				jtfEmail.setText(e1.getEmail());
				jtfTelefono.setText(e1.getTelefono());
			}
		});
		btnLastRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnLastRegister);

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profesor e2 = new Profesor(Integer.parseInt(jtfId.getText()), jtfNombre.getText(), jtfApellido1.getText(), jtfApellido2.getText(),
						jtfDni.getText(), jtfDireccion.getText(), jtfEmail.getText(), jtfTelefono.getText());
				ProfesorController.save(e2);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Nuevo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfId.setText("0");
				jtfNombre.setText("");
				jtfApellido1.setText("");
				jtfApellido2.setText("");
				jtfDni.setText("");
				jtfDireccion.setText("");
				jtfEmail.setText("");
				jtfTelefono.setText("");

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int borrar =  JOptionPane.showConfirmDialog(null, "¿Estas seguro de borrar este registro?");
				if(borrar == 0) {
					Profesor e2 = new Profesor(Integer.parseInt(jtfId.getText()), jtfNombre.getText(), jtfApellido1.getText(), jtfApellido2.getText(),
							jtfDni.getText(), jtfDireccion.getText(), jtfEmail.getText(), jtfTelefono.getText());
					ProfesorController.delete(e2);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton_2);

		findFirst();
		
	}

	private void findFirst() {
		Profesor e1 = ProfesorController.findFirst();
		jtfId.setText("" + e1.getId());
		jtfNombre.setText(e1.getNombre());
		jtfApellido1.setText(e1.getApellido1());
		jtfApellido2.setText(e1.getApellido2());
		jtfDni.setText(e1.getDni());
		jtfDireccion.setText(e1.getDireccion());
		jtfEmail.setText(e1.getEmail());
		jtfTelefono.setText(e1.getTelefono());
	}
}


