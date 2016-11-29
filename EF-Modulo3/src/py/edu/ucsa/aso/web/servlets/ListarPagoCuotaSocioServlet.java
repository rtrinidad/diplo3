package py.edu.ucsa.aso.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.edu.ucsa.aso.ejb.PagoCuotaSocioEJB;
import py.edu.ucsa.aso.ejb.entities.PagoCuotaSocio;



/**
 * Servlet implementation class ListarPagoCuotaSocioServlet
 */
@WebServlet("/ListarPagoCuotaSocioServlet")
public class ListarPagoCuotaSocioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB(mappedName="java:global/AsoEJB/PagoCuotaSocioEJBImpl!py.edu.ucsa.aso.ejb.PagoCuotaSocioEJB")
	private PagoCuotaSocioEJB pagoCuotaEJB;
	
	
    public ListarPagoCuotaSocioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PagoCuotaSocio> pagos = pagoCuotaEJB.listarCuotasPagadasPorSocio(1);
		
		HttpSession session = request.getSession(true);//CREAMOS UNA SESSION
		session.setAttribute("pagoCuota", pagos); //SETEAMOS UN ATRIBUTO A LA SESION
		request.getRequestDispatcher("PagoCuota.jsp").forward(request, response);//PASAMOS EL CONTROL DE LA PETICION AL RECURSO PagoCuota.jsp

		
		
		//IMPRIMIR EN LA CONSOLA
//		for (PagoCuotaSocio pcs : pagos) {
//			System.out.println(pcs.getEstado().getDescripcion());			
//		}
		
		
		//IMPRIMIR EN HTML
/*				PrintWriter out;
				out = response.getWriter();
				
				response.setContentType("text/html");
				
				out.println("<html>");
				out.println("<head><title>Ejemplo de Servlets</title></head>");
				out.println("<body>");
				out.println("<center><h1>Lista de Cuotas Pagadas por Socio</h1></center>");
				out.println("<br>");
				out.println("<br>");
				out.println("<table border=1 align=center bgcolor=#F0F8FF>");
				out.println("<tr>"
						+ "<th>Socio</th>"
						+ "<th>Mes/Año</th"
						+ "><th>Monto</th>"
						+ "<th>Estado</th>"
						+ "</tr>");
				for (PagoCuotaSocio pagoCuotasSocio : pagos) {
					out.println("<tr>");
					out.println("<td>" + pagoCuotasSocio.getSocio().getNombres() + " " 
					+ pagoCuotasSocio.getSocio().getApellidos() + "</td>");
					out.println("<td>" + pagoCuotasSocio.getMesCuota() + "/" 
					+ pagoCuotasSocio.getAnhoCuota() + "</td>");
					out.println("<td>" + pagoCuotasSocio.getMontoCuota() + "</td>");
					out.println("<td>" + pagoCuotasSocio.getEstado().getDescripcion() + "</td>");
					out.println("</tr>");
					
				}				
				out.println("</table>");
				out.println("<br>");
//				out.println("<br>");
//				for (PagoCuotaSocio pcs : pagos) {
//					out.println("<h4>Socio: " + pcs.getSocio().getNombres() + " " + pcs.getSocio().getApellidos() + 
//				" Mes/Año: " + pcs.getMesCuota() + "/" + pcs.getAnhoCuota()  + " Monto: " + pcs.getMontoCuota() + 
//				" Estado: " + pcs.getEstado().getDescripcion() + "</h4>");
//					
//				}
				out.println("</body></html>");
*/				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
