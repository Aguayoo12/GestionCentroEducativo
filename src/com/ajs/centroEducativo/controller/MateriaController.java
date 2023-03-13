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
import com.ajs.centroEducativo.model.Materia;
import com.ajs.centroEducativo.model.Materia;

public class MateriaController {
	public static Connection CONN = null; 
	
	public static Materia findFirst() {
		
		try {
			CONN = ConnectionManagerV1.getConexion();
			Statement st = CONN.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.materia order by id limit 1");
			Materia m = getEntidadFromRs(rs);
			rs.close();
			st.close();
			CONN.close();
			return m;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static Materia previous(Materia m1) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			PreparedStatement ps = CONN.prepareStatement(
					"SELECT * FROM centroeducativo.materia where id < ? order by id desc limit 1");
			ps.setInt(1, m1.getId());
			ResultSet rs = ps.executeQuery();
			Materia m = getEntidadFromRs(rs);
			rs.close();
			ps.close();
			CONN.close();
			return m;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Materia next (Materia m1) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			PreparedStatement ps = CONN.prepareStatement(
					"SELECT * FROM centroeducativo.materia where id > ? order by id limit 1");
			ps.setInt(1, m1.getId());
			ResultSet rs = ps.executeQuery();
			Materia m = getEntidadFromRs(rs);
			rs.close();
			ps.close();
			CONN.close();
			return m;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static Materia findLast() {
			
			try {
				CONN = ConnectionManagerV1.getConexion();
				Statement st = CONN.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.materia order by id desc limit 1");
				Materia m = getEntidadFromRs(rs);
				rs.close();
				st.close();
				CONN.close();
				return m;
	
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;
	}
	
	public static void save(Materia m) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			if (m.getId() == 0 ) {
				PreparedStatement ps = CONN.prepareStatement("insert into materia values (?, ?, ?, ?)");
				ps.setInt(1, siguienteId());
				ps.setString(2, m.getNombre());
				ps.setString(3, m.getAcronimo());
				ps.setInt(4, m.getCurso().getId());
				int columasAfectadas = ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Columnas afectadas: "+columasAfectadas);
			} 
			else if(m.getId() != 0 ){
				PreparedStatement ps = CONN.prepareStatement("update materia set nombre = ?, acronimo = ?, curso_id = ? where id = ?");
				ps.setInt(4, m.getId());
				ps.setString(1, m.getNombre());
				ps.setString(2, m.getAcronimo());
				ps.setInt(3, m.getCurso().getId());
				int columasAfectadas = ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Columnas afectadas: "+columasAfectadas);
			}
			CONN.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	
	private static int siguienteId() throws SQLException {
		CONN = ConnectionManagerV1.getConexion();
		PreparedStatement ps = CONN.prepareStatement("SELECT max(id) FROM centroeducativo.materia");
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
	
	public static void delete(Materia m) {
		PreparedStatement ps;
		try {
			CONN = ConnectionManagerV1.getConexion();
			ps = CONN.prepareStatement("delete from materia where id = ?");
			ps.setInt(1, m.getId());
			int columasAfectadas = ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Columnas afectadas: "+columasAfectadas);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private static Materia getEntidadFromRs(ResultSet rs) throws SQLException {
		Materia m = null;
		if (rs.next()) {
			m = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("acronimo"));
			Curso c = new Curso();
			c.setId(rs.getInt("curso_id"));
			m.setCurso(c);
		}
		return m;
	}
	
	public static List<Materia> findAll(){
		List<Materia> lp = new ArrayList<Materia>();
		Materia p = findFirst();
		do {
			lp.add(p);
			p = next(p);
		}while(p != null);
		return lp;
	}
}
