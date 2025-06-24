package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import modelo.Vehiculo;

public class VehiculoDAO {
	//metodo establecercon
		public static Connection establecerCon() {
			Connection con = null;
			try {
				//inicializar conexion
				String dbDriver = "com.mysql.jdbc.Driver";
				String dbURL = "jdbc:mysql://localhost:3306/";
				String dbName = "proyectoFinal2";
				String dbUsername = "root";
				String dbcontrasena = "1234";
				Class.forName(dbDriver);
				con= DriverManager.getConnection(dbURL + dbName, dbUsername, 
															dbcontrasena);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
			
		}//fin establecerCon
		
		public static int registrar(Vehiculo v ) {
			int estatus=0;
			
			try {
				Connection con = VehiculoDAO.establecerCon();
				PreparedStatement ps= con.prepareStatement("INSERT INTO Vehiculo(codigoVehi,propietariovehi,tipoVehi,modelo,marca,color,precio) VALUES(?,?,?,?,?,?,?)");
				
				ps.setInt(1, v.getTxtCodigo());
				ps.setString(2, v.getTxtPropietario());
				ps.setString(3, v.getTipo());
				ps.setString(4, v.getTxtModelo());
				ps.setString(5, v.getMarca());
				ps.setString(6, v.getTxtColor());
				ps.setString(7, v.getTxtPrecio());
				estatus=ps.executeUpdate();
				con.close();
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return estatus;
			
		}//fin agregar
		
		public static List<Vehiculo> ConsultarTodosVehiculos(){
			List<Vehiculo> lista= new ArrayList<Vehiculo>();
			
			try {
				Connection con = VehiculoDAO.establecerCon();
				
				PreparedStatement ps= con.prepareStatement("Select * from Vehiculo");
				 
				ResultSet rs = ps.executeQuery();
				
				//ciclo para agregar el siguiente
				while( rs.next() ){
				Vehiculo v = new Vehiculo();
				v.setTxtCodigo(rs.getInt(1));
				v.setTxtPropietario(rs.getString(2));
				v.setTipo(rs.getString(3));
				v.setTxtModelo(rs.getString(4));
				v.setMarca(rs.getString(5));
				v.setTxtColor(rs.getString(6));
				v.setTxtPrecio(rs.getString(7));
			
				//agregar a la lista
				lista.add(v);
				}//fin while
				
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
			
		}//fin ConsultarTodosVehiculos
		public static Vehiculo ConsultarVehiculoPorCodigo(int txtCodigo) {
			Vehiculo v = new Vehiculo();
			
			try {
				Connection con = VehiculoDAO.establecerCon();
				PreparedStatement ps = con.prepareStatement("Select * from Vehiculo where codigoVehi=?");
				ps.setInt(1, txtCodigo);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					v.setTxtCodigo(rs.getInt(1));
					v.setTxtPropietario(rs.getString(2));
					v.setTipo(rs.getString(3));
					v.setTxtModelo(rs.getString(4));
					v.setMarca(rs.getString(5));
					v.setTxtColor(rs.getString(6));
					v.setTxtPrecio(rs.getString(7));
					
				
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return v;
		}//fin ConsultarVehiculoPorCodigo
		
		
		public static int actualizar(Vehiculo v ) {
			int estatus=0;
			
			try {
				Connection con= VehiculoDAO.establecerCon();
				PreparedStatement ps = con.prepareStatement("Update Vehiculo set propietariovehi=?,tipoVehi=?,modelo=?,marca=?," + 
				                                            "color=?, precio=? where codigoVehi=?; ");
				ps.setString(1,v.getTxtPropietario() );
				ps.setString(2, v.getTipo());
				ps.setString(3, v.getTxtModelo());
				ps.setString(4, v.getMarca());
				ps.setString(5, v.getTxtColor());
				ps.setString(6, v.getTxtPrecio());
				ps.setInt(7, v.getTxtCodigo());
				
				//ejecutar la sentencia
				estatus= ps.executeUpdate();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return estatus;
		}//fin actualizar
		
		public static int borrar (int txtCodigo) {
			int estatus=0;
			
		try(Connection con= VehiculoDAO.establecerCon();
				PreparedStatement ps = con.prepareStatement("Delete from Vehiculo where codigoVehi=?")){
			
			ps.setInt(1, txtCodigo);
			estatus=ps.executeUpdate();
			con.close();
		}//fin try
		catch(Exception e) {
			//
		}
			
			
			return estatus;
		}//fin borrar
		
}
