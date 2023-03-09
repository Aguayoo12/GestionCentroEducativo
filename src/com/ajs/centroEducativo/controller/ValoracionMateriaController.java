package com.ajs.centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.ajs.centroEducativo.model.Estudiante;
import com.ajs.centroEducativo.model.Materia;
import com.ajs.centroEducativo.model.Profesor;
import com.ajs.centroEducativo.model.ValoracionMateria;

public class ValoracionMateriaController {
	public static Connection CONN = null; 
	
	public static ValoracionMateria findFirst() {
		
		try {
			CONN = ConnectionManagerV1.getConexion();
			Statement st = CONN.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.valoracionmateria order by id limit 1");
			ValoracionMateria vm = null;
			if (rs.next()) {
				vm = new ValoracionMateria(rs.getInt(1), rs.getFloat(5));
				vm.setProfesor(meterIdProfesor(rs.getInt(2)));
				vm.setEstudiante(meterIdEstudiante(rs.getInt(3)));
				vm.setMateria(meterIdMateria(rs.getInt(4)));
				
			}
			CONN.close();
			st.close();
			rs.close();
			return vm;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static ValoracionMateria previous(ValoracionMateria vm1) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			PreparedStatement ps = CONN.prepareStatement(
					"SELECT * FROM centroeducativo.valoracionmateria where id < ? order by id desc limit 1");
			ps.setInt(1, vm1.getId());
			ResultSet rs = ps.executeQuery();
			ValoracionMateria vm = null;
			if (rs.next()) {
				vm = new ValoracionMateria(rs.getInt(1), rs.getFloat(5));
				vm.setProfesor(meterIdProfesor(rs.getInt(2)));
				vm.setEstudiante(meterIdEstudiante(rs.getInt(3)));
				vm.setMateria(meterIdMateria(rs.getInt(4)));
				
			}
			CONN.close();
			ps.close();
			rs.close();
			
			return vm;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ValoracionMateria next (ValoracionMateria vm1) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			PreparedStatement ps = CONN.prepareStatement(
					"SELECT * FROM centroeducativo.valoracionmateria where id > ? order by id limit 1");
			ps.setInt(1, vm1.getId());
			ResultSet rs = ps.executeQuery();
			ValoracionMateria vm = null;
			if (rs.next()) {
				vm = new ValoracionMateria(rs.getInt(1), rs.getFloat(5));
				vm.setProfesor(meterIdProfesor(rs.getInt(2)));
				vm.setEstudiante(meterIdEstudiante(rs.getInt(3)));
				vm.setMateria(meterIdMateria(rs.getInt(4)));
				
			}
			CONN.close();
			ps.close();
			rs.close();
			return vm;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static ValoracionMateria findLast() {
		try {
			CONN = ConnectionManagerV1.getConexion();
			Statement st = CONN.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.valoracionmateria order by id desc limit 1");
			ValoracionMateria vm = null;
			if (rs.next()) {
				vm = new ValoracionMateria(rs.getInt(1), rs.getFloat(5));
				vm.setProfesor(meterIdProfesor(rs.getInt(2)));
				vm.setEstudiante(meterIdEstudiante(rs.getInt(3)));
				vm.setMateria(meterIdMateria(rs.getInt(4)));
			}
			CONN.close();
			st.close();
			rs.close();
			return vm;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static void save(ValoracionMateria vm) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			if (vm.getId() == 0 ) {
				PreparedStatement ps1 = CONN.prepareStatement("insert into valoracionmateria values (?, ?, ?, ?, ?)");
				ps1.setInt(1, siguienteId());
				ps1.setInt(2, vm.getProfesor().getId());
				ps1.setInt(3, vm.getEstudiante().getId());
				ps1.setInt(4, vm.getMateria().getId());
				ps1.setFloat(5, vm.getValoracion());
				int columasAfectadas = ps1.executeUpdate();
				JOptionPane.showMessageDialog(null, "Columnas afectadas: "+columasAfectadas);
			} 
			else {
				PreparedStatement ps = CONN.prepareStatement("update valoracionmateria set idProfesor = ?, idEstudiante = ?, idMateria = ?, valoracion = ? where id = ?");
				ps.setInt(5, vm.getId());
				ps.setInt(1, vm.getProfesor().getId());
				ps.setInt(2, vm.getEstudiante().getId());
				ps.setInt(3, vm.getMateria().getId());
				ps.setFloat(4, vm.getValoracion());
				int columasAfectadas = ps.executeUpdate();
				ps.close();
				JOptionPane.showMessageDialog(null, "Columnas afectadas: "+columasAfectadas);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void delete(ValoracionMateria vm) {
		PreparedStatement ps;
		try {
			CONN = ConnectionManagerV1.getConexion();
			ps = CONN.prepareStatement("delete from valoracionmateria where id = ?");
			ps.setInt(1, vm.getId());
			int columasAfectadas = ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Columnas afectadas: "+columasAfectadas);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private static int siguienteId() throws SQLException {
		CONN = ConnectionManagerV1.getConexion();
		PreparedStatement ps = CONN.prepareStatement("SELECT max(id) FROM centroeducativo.valoracionmateria");
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
	
	public static ValoracionMateria actual(ValoracionMateria vm1) {
		try {
			CONN = ConnectionManagerV1.getConexion();
			Statement st = CONN.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.valoracionmateria where id = "+vm1.getId());
			ValoracionMateria vm = null;
			if (rs.next()) {
				vm = new ValoracionMateria(rs.getInt(1), rs.getFloat(5));
				vm.setProfesor(meterIdProfesor(rs.getInt(2)));
				vm.setEstudiante(meterIdEstudiante(rs.getInt(3)));
				vm.setMateria(meterIdMateria(rs.getInt(4)));
			}
			CONN.close();
			st.close();
			rs.close();
			return vm;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	private static Profesor meterIdProfesor(int num) {
		Profesor p = new Profesor();
		p.setId(num);
		return p;
	}
	
	private static Estudiante meterIdEstudiante(int num) {
		Estudiante e = new Estudiante();
		e.setId(num);
		return e;
	}
	
	private static Materia meterIdMateria(int num) {
		Materia m = new Materia();
		m.setId(num);
		return m;
	}
}
