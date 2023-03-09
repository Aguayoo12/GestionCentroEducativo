package com.ajs.centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.ajs.centroEducativo.model.Curso;
import com.ajs.centroEducativo.model.Profesor;

public class ProfesorController {
	private static Connection CONN = null;
	
	public static Profesor findFirst() {

		try {
			CONN = ConnectionManagerV1.getConexion();
			Statement st = CONN.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.Profesor order by id limit 1");
			Profesor e1 = null;
			if (rs.next()) {
				e1 = new Profesor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
			}
			CONN.close();
			st.close();
			rs.close();
			return e1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Profesor previous(Profesor e2) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			PreparedStatement ps = CONN
					.prepareStatement("SELECT * FROM centroeducativo.profesor where id < ? order by id desc limit 1");
			ps.setInt(1, e2.getId());
			ResultSet rs = ps.executeQuery();
			Profesor e1 = null;
			if (rs.next()) {
				e1 = new Profesor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
			}
			CONN.close();
			ps.close();
			rs.close();

			return e1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static Profesor next(Profesor e2) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			PreparedStatement ps = CONN
					.prepareStatement("SELECT * FROM centroeducativo.profesor where id > ? order by id limit 1");
			ps.setInt(1, e2.getId());
			ResultSet rs = ps.executeQuery();
			Profesor e1 = null;
			if (rs.next()) {
				e1 = new Profesor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
			}
			CONN.close();
			ps.close();
			rs.close();
			return e1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Profesor findLast() {

		try {
			CONN = ConnectionManagerV1.getConexion();
			Statement st = CONN.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.profesor order by id desc limit 1");
			Profesor e1 = null;
			if (rs.next()) {
				e1 = new Profesor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
			}
			CONN.close();
			st.close();
			rs.close();
			return e1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void save(Profesor e1) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			if(e1.getId() == 0) {
				PreparedStatement ps = CONN.prepareStatement("insert into profesor values (?, ?, ?, ?, ?, ?, ?, ?)");
				ps.setInt(1, siguienteId());
				ps.setString(2, e1.getNombre());
				ps.setString(3, e1.getApellido1());
				ps.setString(4, e1.getApellido2());
				ps.setString(5, e1.getDni());
				ps.setString(6, e1.getDireccion());
				ps.setString(7, e1.getEmail());
				ps.setString(8, e1.getTelefono());
				
				int columnasAfectadas = ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Numero de columnas afectadas: "+columnasAfectadas);
			}
			else {
				PreparedStatement ps = CONN.prepareStatement("update profesor set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, direccion = ?, email = ?, telefono = ? where id = ?");
				ps.setInt(8, e1.getId());
				ps.setString(1, e1.getNombre());
				ps.setString(2, e1.getApellido1());
				ps.setString(3, e1.getApellido2());
				ps.setString(4, e1.getDni());
				ps.setString(5, e1.getDireccion());
				ps.setString(6, e1.getEmail());
				ps.setString(7, e1.getTelefono());
				
				int columnasAfectadas = ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Numero de columnas afectadas: "+columnasAfectadas);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int siguienteId() throws SQLException {
		CONN = ConnectionManagerV1.getConexion();
		PreparedStatement ps = CONN.prepareStatement("SELECT max(id) FROM centroeducativo.profesor");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int siguiente = rs.getInt(1) + 1;
			rs.close();
			ps.close();
			return (siguiente);
		}
		rs.close();
		ps.close();
		return 1;
	}
	
	public static void delete(Profesor e1) {
		PreparedStatement ps;
		try {
			CONN = ConnectionManagerV1.getConexion();
			ps = CONN.prepareStatement("delete from profesor where id = ?");
			ps.setInt(1, e1.getId());
			int columasAfectadas = ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Columnas afectadas: "+columasAfectadas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<Profesor> findAll(){
		List<Profesor> lp = new ArrayList<Profesor>();
		Profesor p = findFirst();
		do {
			lp.add(p);
			p = next(p);
		}while(p != null);
		return lp;
	}
}
