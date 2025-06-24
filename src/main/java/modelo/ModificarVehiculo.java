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
 * Servlet implementation class ModificarVehiculo
 */
@WebServlet("/ModificarVehiculo")
public class ModificarVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarVehiculo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Llenar formulario
		
		int codVehiculo;
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
	
		codVehiculo = Integer.parseInt(request.getParameter("txtCodigo"));
		Vehiculo v = VehiculoDAO.ConsultarVehiculoPorCodigo(codVehiculo);
		//Llenar formulario
		
		salida.print("<head>");
		salida.print("<title>Actualizar Vehiculos</title>");
		salida.print("<link rel=\"stylesheet\" href=\"css/estilo.css\"/>");
		salida.print("</head>");
		salida.print("<body>");
		salida.print("<form action='ModificarVehiculo2' method='post'>");
		salida.print("<div class=\"main\">");
		salida.print("<div class=\"navbar\">");
		salida.print("<div class =\"icon\">");
		salida.print("<h1 class=\"logo\" >Actualizar</h1>");
		salida.print("</div>");
		salida.print("</div>");
		salida.print("<div class= \"menu\">");
		salida.print("<ul> ");
		salida.print("<li><a href='registroAuto.html'>Registro</a></li>");
		salida.print("<li><a href = \"ConsultarVehiculo\">Consulta de Vehiculo</a></li>");
		salida.print("<li><a href = >Actualizar Vehiculo</a></li>");
		salida.print("</ul> ");
		salida.print("<br> <br> <br> ");
		salida.print("<table>");
		salida.print("<tr><td></td><td><input type='hidden' name='txtCodigo' value='"+ v.getTxtCodigo() + "'/></td></tr>");
		salida.print("<tr><td><h2>Propietario:</h2></td><td><input type='text' name='txtPropietario' value='"+v.getTxtPropietario()+"'/></td></tr>");
		salida.print("<tr><td><h2>Tipo de Vehiculo:</h2></td><td>");
		salida.print("<select name='tipo' style='width:150px value='"+v.getTipo()+"'/>");
		salida.print("<option>Automovil</option>");
		salida.print("<option>Camioneta</option>");
		salida.print(" <option>Motocicleta</option>");
		salida.print("<option>Otros</option>");
		salida.print("</select>");
		salida.print("<tr><td><h2>Modelo:</td><td><input type='text' name='txtModelo' value='"+ v.getTxtModelo()+"'/></td></tr>");
		salida.print("<tr><td><h2>Marca:</h2></td><td>");
		salida.print("<select name='marca' style='width:150px value='"+v.getMarca()+"'/>");
		salida.print("<option>Toyota</option>");
		salida.print("<option>Honda</option>");
		salida.print(" <option>Hyundai</option>");
		salida.print("<option>Otros</option>");
		salida.print("</select>");
		salida.print("<tr><td><h2>Color:</td><td><input type='text' name='txtColor' value='"+ v.getTxtColor()+"'/></td></tr>");
		salida.print("<tr><td><h2>Precio:</td><td><input type='text' name='txtPrecio' value='"+ v.getTxtPrecio()+"'/></td></tr>");
		salida.print("<tr></tr>");
		salida.print("<tr></tr>");
		salida.print("<tr></tr>");
		salida.print("<tr></tr>");
		salida.print("<tr><td></td><td colspan='2'><input type='submit' value='Guardar' class=\"boton\"/></td></tr>");
		salida.print("</table>");
		salida.print("</form>");
		salida.close();
	}
}
