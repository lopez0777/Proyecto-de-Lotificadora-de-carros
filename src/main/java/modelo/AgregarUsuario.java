package modelo;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import controlador.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgregarAlumno
 */
@WebServlet("/AgregarUsuario")
public class AgregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		int estatus = 0;
		Usuario u = new Usuario();
		PrintWriter imprime = response.getWriter();
		
		String codigo = request.getParameter("codUsuario");
		String nombre = request.getParameter("nombreUsuario");
		String contrasena = request.getParameter("contrasena");
		String email = request.getParameter("email");
		boolean Estatus = request.getParameter("rbEstado") != null;
		
		u.setCodUsuario(codigo);
		u.setNombreUsuario(nombre);
		u.setContrasena(contrasena);
		u.setEmail(email);
		u.setRbEstado(Estatus);
		
		
		estatus = login.agregar(u);
		if (estatus>0) {
			imprime.print("<p> El Usuario ha sido agregado </p>");
			response.sendRedirect("index.html");
		}
		else {
			imprime.println(" No es posible agregar el registro del usuario");
		}
		
	}

}