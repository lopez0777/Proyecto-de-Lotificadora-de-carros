package modelo;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import controlador.login;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConsultarUsuario
 */
@WebServlet("/ConsultarUsuario")
public class ConsultarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		PrintWriter imprimir = response.getWriter();
		imprimir.println("<a href='menu.html'>Volver al menu principal</a>");
		imprimir.println("<h1>Lista de Usuarios Registrados</h1>");
		
		List<Usuario> lista = login.ConsultarTodosUsuarios();
		

		
		imprimir.print("<table border='1' width='100%'>");
		imprimir.print("<tr><th>Id</th><th>Codigo</th><th>Nombre</th><th>Email</th> " + 
				       "<th>Estatus</th><th>Modificar</th><th>Eliminar</th></tr>");
		
		for(Usuario u:lista) {
			//desplegar
			imprimir.print("<tr><td style=\"color: black\">"+ u.getId() + "</td><td style=\"color: black\">"+ u.getCodUsuario() + "</td><td style=\"color: black\">"+ u.getNombreUsuario()+
					       "</td><td style=\"color: black\">" + u.getEmail()+ "</td><td style=\"color: black\">"+  u.getisRbEstado()+"</td><td style=\"color: black\">" + "<a href = 'ModificarUsuario?id="+u.getId()  +"'>Modificar</a></<td><td> " +
					         "<a href= 'EliminarUsuario?id="+u.getId()+" '>Eliminar</a></td></tr> ");
			
		}//fin for

		imprimir.print("</table>");
		imprimir.close();
	}
		
	}

	

