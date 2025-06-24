package modelo;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import controlador.login;

/**
 * Servlet implementation class buscarUsuario
 */
@WebServlet("/buscarUsuario")
public class buscarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static int NoIntentos = 0;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String strcodUsuario = request.getParameter("codUsuario");		
		String strContrasena = request.getParameter("contrasena");
		String dbcontrasena = login.ConsultarUsuarioPorCodigo(strcodUsuario);
		
		
		PrintWriter imprime = response.getWriter();
		
		if (dbcontrasena != "") {
			if(strContrasena.equals(dbcontrasena.toString())) {
				
				imprime.print("Bienvenido al Sistema sr. " + strcodUsuario);
				
				 response.sendRedirect("menu.html");
				
			}else {
				NoIntentos += 1;
				
				imprime.print("NoIntentos " + NoIntentos + " el usuario se bloqueara despues del tercer intento");
				if(NoIntentos > 3) {
					login.inhabilitarestatusUsuario(strcodUsuario);
					imprime.print("El usuario: " + strcodUsuario + " se encuentra deshabilitado por que excedio los 3 intentos");
				}
				
			}
		} else {
			imprime.print(" Usuario no existe o esta deshabilitado " );
		}
		
		

		
		
		//imprime.print(" - dbContrasena  -" + dbcodUsuario + "- usrContrasena -" + strContrasena + "-");
		
		 
		
	}



}
