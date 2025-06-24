package modelo;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;


import controlador.VehiculoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificarVehiculo2
 */
@WebServlet("/ModificarVehiculo2")
public class ModificarVehiculo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarVehiculo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int estatus=0;
		PrintWriter imprime= response.getWriter();
		//recuperar todos los parametros
		int codgVehiculo = Integer.parseInt(request.getParameter("txtCodigo"));
		String propietario= request.getParameter("txtPropietario");
		String tipo= request.getParameter("tipo");
		String modelo= request.getParameter("txtModelo");
		String marca= request.getParameter("marca");
		String color= request.getParameter("txtColor");
		String precio= request.getParameter("txtPrecio");
		
		Vehiculo v = new Vehiculo();
		v.setTxtCodigo(codgVehiculo);
		v.setTxtPropietario(propietario);
		v.setTipo(tipo);
		v.setTxtModelo(modelo);
		v.setMarca(marca);
		v.setTxtColor(color);
		v.setTxtPrecio(precio);
		
		
		estatus= VehiculoDAO.actualizar(v);
		if (estatus>0) {
			response.sendRedirect("ConsultarVehiculo");
			
		}else {
			imprime.print("Ha ocurrido un error!");
		}
		imprime.close();
	}
	}


