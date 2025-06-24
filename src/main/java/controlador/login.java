package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.Vehiculo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class login {
	
	public static Connection establecerCon() {
		Connection con = null;
		
		try {						
			//inicializar conexión
			String dbDriver = "com.mysql.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/";
			String dbNombre = "proyectofinal";
			String dbUsuario = "root";
			String dbContrasena = "1234";
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbURL + dbNombre, dbUsuario, dbContrasena);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}//fin establecerCon()
	
	
	//public static String
	
	public static String  ConsultarUsuarioPorCodigo(String codUsuario)  {
		String contrasena = "";

		try {
			Connection con = login.establecerCon();
			PreparedStatement ps = con.prepareStatement("SELECT contrasena FROM Usuarios WHERE codigo = ? AND estatus = 1");
								
			ps.setString(1, codUsuario);
			//ps.setInt(2, 1);
									
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
				contrasena = rs.getString(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return contrasena;
	}//Fin modificar1 
	
	
	public static int inhabilitarestatusUsuario(String codUsuario) {
		
		int estatus = 0;
		
		try {
			Connection con  = login.establecerCon();
			PreparedStatement ps = con.prepareStatement("UPDATE Usuarios SET estatus = 0 WHERE codigo = ?");
			ps.setString(1, codUsuario);			
			estatus = ps.executeUpdate();
			con.close();			
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			estatus = 0;
		}
		return estatus;
	}//fin modificar
	
	
	public static int agregar(Usuario u) {
		
		int estatus = 0;
		
		try {
			Connection con = login.establecerCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Usuarios(codigo, nombre, contrasena, email, estatus) VALUES (?,?,?,?,?)");

			ps.setString(1, u.getCodUsuario());
			ps.setString(2, u.getNombreUsuario());
			ps.setString(3, u.getContrasena());
			ps.setString(4, u.getEmail());
			ps.setBoolean(5, u.getisRbEstado());			
			estatus = ps.executeUpdate();
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estatus;		
	}
	
	public static List<Usuario> ConsultarTodosUsuarios(){
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			Connection con = login.establecerCon();
			
			PreparedStatement ps = con.prepareStatement("SELECT id, codigo, nombre, email, estatus FROM Usuarios");
			 
			ResultSet rs = ps.executeQuery();
			
			
			Usuario u = new Usuario();
			
			
			while(rs.next() ){		
				
				u = new Usuario();		
				u.setId(rs.getInt(1));
				u.setCodUsuario(rs.getNString(2));
				u.setNombreUsuario(rs.getNString(3));
				u.setEmail(rs.getNString(4));
				u.setRbEstado(rs.getBoolean(5));
		
				//agregar a la lista
				lista.add(u);
			}//fin while
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public static Usuario ConsultarUsuarioPorCodigo(int id) {
		Usuario u = new Usuario();	
		
		try {
			Connection con = login.establecerCon();
			PreparedStatement ps = con.prepareStatement("Select * from Usuarios where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt(1));
				u.setCodUsuario(rs.getNString(2));
				u.setNombreUsuario(rs.getNString(3));
				u.setContrasena(rs.getNString(4));
				u.setEmail(rs.getNString(5));
				u.setRbEstado(rs.getBoolean(6));		
			
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return u;
	}//fin ConsultarVehiculoPorCodigo
	
	
	
	public static int actualizar(Usuario u) {
		int estatus=0;
		
		try {
			Connection con= login.establecerCon();
			PreparedStatement ps = con.prepareStatement("Update Usuarios set codigo=?, nombre=?, contrasena=?, email=?," + 
			                                            "estatus=? where id=?; ");
			ps.setString(1, u.getCodUsuario());
			ps.setString(2, u.getNombreUsuario());
			ps.setString(3, u.getContrasena());
			ps.setString(4, u.getEmail());
			ps.setBoolean(5, u.getisRbEstado());
			ps.setInt(6, u.getId());
			
			//ejecutar la sentencia
			estatus= ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estatus;
	}//fin actualizar
	
	public static int borrar (int id) {
		int estatus=0;
		
	try(Connection con= login.establecerCon();
			PreparedStatement ps = con.prepareStatement("Delete from Usuarios where id=?")){
		
		ps.setInt(1, id);
		estatus=ps.executeUpdate();
		con.close();
	}//fin try
	catch(Exception e) {
		//
	}
		
		
		return estatus;
	}//fin borrar
}
