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
 * Servlet implementation class RegistrarVehiculo
 */
@WebServlet("/RegistrarVehiculo")
public class RegistrarVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarVehiculo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//contenido que se enviara el tipo
		int estatus=0;//confimar exitoso o no agregar 
		Vehiculo v = new Vehiculo();//instancia de la clase 
		PrintWriter imprime= response.getWriter();
		//defino variables y recupero el parametro 
		int codigo= Integer.parseInt(request.getParameter("txtCodigo")) ;//parametro el que esta en el index
		String propietario= request.getParameter("txtPropietario");
		String tipo= request.getParameter("tipo");
		String modelo= request.getParameter("txtModelo");
		String marca= request.getParameter("txtMarca");
		String color= request.getParameter("txtColor");
		String precio= request.getParameter("txtPrecio");
		//pasar todos los parametros a la instancia 
		v.setTxtCodigo(codigo);
		v.setTxtPropietario(propietario);
		v.setTipo(tipo);
		v.setTxtModelo(modelo);
		v.setMarca(marca);
		v.setTxtColor(color);
		v.setTxtPrecio(precio);
		//ejecutar 
		estatus= VehiculoDAO.registrar(v);
		if (estatus>0) {
			imprime.print("<p>El Vehiculo ha sido Registrado </p>");
			request.getRequestDispatcher("registroAuto.html").include(request, response);
			
		}else {
			imprime.print("No es posible agregar el registro");
		}
		
		
	}
	
	}


