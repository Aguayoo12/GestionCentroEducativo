package com.ajs.centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.ajs.centroEducativo.model.Materia;

public class PruebaController {
	
	public static List<Materia> MateriasPorCurso(int id){
		List<Materia> lm = new ArrayList<Materia>();
		Connection conn;
		try {
			conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement("select * from materia where curso_id = ?");
			ps.setInt(1, id); 
			ResultSet rs = ps.executeQuery();
			Materia m;
			while(rs.next()) {
				m = new Materia();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setAcronimo(rs.getString("acronimo"));
				m.setFecha(rs.getDate("fecha"));
				m.setAprobado(rs.getBoolean("aprobado"));
				m.setContrasena(rs.getString("contrasena"));
				lm.add(m);
			}
			rs.close();
			ps.close();
			conn.close();
			
			return lm;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lm;
	}
	
	public static void guardar(Materia m) {
		Connection conn;
		try {
			conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement("update materia set nombre = ?, acronimo = ?, curso_id = ?, fecha = ?, aprobado = ? where id = ?");
			ps.setInt(6, m.getId());
			ps.setString(1, m.getNombre());
			ps.setString(2, m.getAcronimo());
			ps.setInt(3, m.getCurso().getId());
			ps.setDate(4, m.getFecha());
			ps.setBoolean(5, m.isAprobado());
			int columasAfectadas = ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Columnas afectadas: "+columasAfectadas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
