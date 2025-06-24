package modelo;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import controlador.VehiculoDAO;
import controlador.login;
/**
 * Servlet implementation class ModificarUsuario2
 */
@WebServlet("/ModificarUsuario2")
public class ModificarUsuario2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		int estatus=0;
		PrintWriter imprime= response.getWriter();
		//recuperar todos los parametros
		
		int codgUsuario = Integer.parseInt(request.getParameter("id"));
		String codigo = request.getParameter("codUsuario");
		String nombre = request.getParameter("nombreUsuario");
		String contrasena = request.getParameter("contrasena");
		String email = request.getParameter("email");
		boolean Estatus = request.getParameter("rbEstado") != null;
		
		Usuario u = new Usuario();
		u.setId(codgUsuario);
		u.setCodUsuario(codigo);
		u.setNombreUsuario(nombre);
		u.setContrasena(contrasena);
		u.setEmail(email);
		u.setRbEstado(Estatus);
				
		estatus= login.actualizar(u);
		if (estatus>0) {
			response.sendRedirect("ConsultarUsuario");
			
		}else {
			imprime.print("Ha ocurrido un error!");
		}
		imprime.close();
	}
	}


