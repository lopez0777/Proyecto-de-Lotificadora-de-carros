package modelo;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import controlador.VehiculoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConsultarVehiculo
 */
@WebServlet("/ConsultarVehiculo")
public class ConsultarVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarVehiculo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//especificar el tipo que se envia
		PrintWriter imprimir = response.getWriter();
		
		
		
		List<Vehiculo> lista= VehiculoDAO.ConsultarTodosVehiculos();
		imprimir.print("<head>");
		imprimir.print("<title>Consulta de Vehiculos</title>");
		imprimir.print("<link rel=\"stylesheet\" href=\"css/estilo.css\"/>");
		imprimir.print("</head>");
		imprimir.print("<body>");
		imprimir.print("<div class=\"main\">");
		imprimir.print("<div class=\"navbar\">");
		imprimir.print("<div class =\"icon\">");
		imprimir.print("<h1 class=\"logo\" >Consulta </h1>");
		imprimir.print("</div>");
		imprimir.print("</div>");
		imprimir.print("<div class= \"menu\">");
		imprimir.print("<ul> ");
		imprimir.print("<li><a href=index.html>Registro</a></li>");
		imprimir.print("<li><a href = \"ConsultarVehiculo\">Consulta de Vehiculo</a></li>");
		imprimir.print("</ul> ");
		imprimir.print("<br> <br> <br> ");
		imprimir.print("<table  border='3'  width='100%' >");
		imprimir.print("<tr><th style=\"color: #ffffff\">CODIGO</th><th style=\"color: #ffffff\">PROPIETARIO</th><th style=\"color: #ffffff\">TIPO DE VEICULO</th><th style=\"color: #ffffff\">MODELO</th> " +
		               "<th style=\"color: #ffffff\">MARCA</th><th style=\"color: #ffffff\">COLOR</th><th style=\"color: #ffffff\">PRECIO</th><th style=\"color: #ffffff\">MODIFICAR</th><th style=\"color: #ffffff\">ELIMINAR</th></tr>");
		
		
		//para cada fila
		for(Vehiculo v:lista) {
			//desplegar
			imprimir.print("<tr><td style=\"color: #ffffff\">"+ v.getTxtCodigo() + "</td><td style=\"color: #ffffff\">"+ v.getTxtPropietario() + "</td><td style=\"color: #ffffff\">"+ v.getTipo()+
					       "</td><td style=\"color: #ffffff\">" +v.getTxtModelo() + "</td><td style=\"color: #ffffff\">"+ v.getMarca()+"</td><td style=\"color: #ffffff\">"+v.getTxtColor()+"</td><td style=\"color: #ffffff\">"+
					      v.getTxtPrecio() + "</td><td>"+ "<a href = 'ModificarVehiculo?txtCodigo="+v.getTxtCodigo()  +"'>Modificar</a></<td><td> " +
					         "<a href= ' EliminarVehiculo?txtCodigo="+v.getTxtCodigo()+" '>Eliminar</a></td></tr> ");
			
		}//fin for

		imprimir.print("</table>");
		imprimir.close();
	}

	}


