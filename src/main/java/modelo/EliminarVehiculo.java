package modelo;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;


import controlador.VehiculoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EliminarVehiculo
 */
@WebServlet("/EliminarVehiculo")
public class EliminarVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarVehiculo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sCodVehiculo= request.getParameter("txtCodigo");
		int  codigo= Integer.parseInt(sCodVehiculo);
		VehiculoDAO.borrar(codigo);
		response.sendRedirect("ConsultarVehiculo");
	}

}
