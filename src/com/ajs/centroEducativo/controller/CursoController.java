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

public class CursoController {

	public static Connection CONN = null; 
	
	public static Curso findFirst() {
		
		try {
			CONN = ConnectionManagerV1.getConexion();
			Statement st = CONN.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso order by id limit 1");
			Curso c = null;
			if (rs.next()) {
				c = new Curso(rs.getInt(1), rs.getString(2));
			}
			CONN.close();
			st.close();
			rs.close();
			return c;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Curso previous(Curso c) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			PreparedStatement ps = CONN.prepareStatement(
					"SELECT * FROM centroeducativo.curso where id < ? order by id desc limit 1");
			ps.setInt(1, c.getId());
			ResultSet rs = ps.executeQuery();
			Curso c1 = null;
			if (rs.next()) {
				c1 = new Curso(rs.getInt(1), rs.getString(2));
			}
			CONN.close();
			ps.close();
			rs.close();
			
			return c1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Curso next (Curso c) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			PreparedStatement ps = CONN.prepareStatement(
					"SELECT * FROM centroeducativo.curso where id > ? order by id limit 1");
			ps.setInt(1, c.getId());
			ResultSet rs = ps.executeQuery();
			Curso c1 = null;
			if (rs.next()) {
				c1 = new Curso(rs.getInt(1), rs.getString(2));
			}
			CONN.close();
			ps.close();
			rs.close();
			return c1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Curso findLast() {
			
			try {
				CONN = ConnectionManagerV1.getConexion();
				Statement st = CONN.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso order by id desc limit 1");
				Curso c = null;
				if (rs.next()) {
					c = new Curso(rs.getInt(1), rs.getString(2));
				}
				CONN.close();
				st.close();
				rs.close();
				return c;
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	public static void save(Curso c) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			if (c.getId() == 0) {
				PreparedStatement ps = CONN.prepareStatement("insert into curso values (" + siguienteId() + ", '" + c.getDescripcion() + "')");
				int columasAfectadas = ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Columnas afectadas: "+columasAfectadas);
			} else {
				PreparedStatement ps = CONN.prepareStatement("update curso set descripcion = '"+ c.getDescripcion() +"' where id = "+c.getId());
				int columasAfectadas = ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Columnas afectadas: "+columasAfectadas);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int siguienteId() throws SQLException {
		CONN = ConnectionManagerV1.getConexion();
		PreparedStatement ps = CONN.prepareStatement("SELECT max(id) FROM centroeducativo.curso");
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
	
	public static void delete(Curso c) {
		PreparedStatement ps;
		try {
			CONN = ConnectionManagerV1.getConexion();
			ps = CONN.prepareStatement("delete from curso where id = ?");
			ps.setInt(1, c.getId());
			int columasAfectadas = ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Columnas afectadas: "+columasAfectadas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<Curso> findAll(){
		List<Curso> lc = new ArrayList<Curso>();
		Curso c = findFirst();
		do {
			lc.add(c);
			c = next(c);
		}while(c != null);
		return lc;
	}
	 

}
