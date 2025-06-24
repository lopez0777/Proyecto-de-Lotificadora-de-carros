package modelo;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import controlador.login;


/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int estatus = 0;
		int codUsuario;
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
	
		salida.println("<h1>Modificar Usuario</h1>");
		codUsuario = Integer.parseInt(request.getParameter("id"));
		Usuario u = login.ConsultarUsuarioPorCodigo(codUsuario);

		//Llenar formulario
		
		salida.print("<form action='ModificarUsuario2' method='post'>");
		salida.print("<table>");
		salida.print("<tr><td></td><td><input type='hidden' name='id' value='"+ u.getId() + "'/></td></tr>");
		salida.print("<tr><td>Codigo</td><td><input type='text' name='codUsuario' value='"+u.getCodUsuario()+"'/></td></tr>");
		salida.print("<tr><td>Nombre</td><td><input type='text' name='nombreUsuario' value='"+u.getNombreUsuario() +"'/></td></tr>");
		salida.print("<tr><td>Contrasena</td><td><input type='text' name='contrasena' value='"+ u.getContrasena()+"'/></td></tr>");
		salida.print("<tr><td>Email</td><td><input type='text' name='email' value='"+ u.getEmail()+"'/></td></tr>");
		salida.print("<tr><td>Estado</td><td>   <input type=\"radio\" name=\"rbEstado\" id=\"hab\" value=" + u.getisRbEstado()+ "checked=\"checked\">\r\n"
				+ "   			<label for=\"hab\">Habilitado</label>\r\n"
				+ "   			<input type=\"radio\" name=\"rbEstado\" id=\"inh\" value="+ u.getisRbEstado() + "checked=\"checked\">\r\n"
				+ "   			<label for=\"inh\">Inhabilitado</label></td></tr>");
		salida.print("<tr><td colspan='2'><input type='submit' value='Guardar'/></td></tr>");
		salida.print("</table>");
		salida.print("</form>");
		salida.close();
		
	}

}
