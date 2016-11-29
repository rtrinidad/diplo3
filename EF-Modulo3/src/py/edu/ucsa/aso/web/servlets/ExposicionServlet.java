package py.edu.ucsa.aso.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.edu.ucsa.aso.ejb.ExposicionEJB;
import py.edu.ucsa.aso.ejb.entities.Exposicion;





/**
 * Servlet implementation class ExposicionServlet
 */
@WebServlet("/ExposicionServlet")
public class ExposicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName="java:global/AsoEJB/ExposicionEJBImpl!py.edu.ucsa.aso.ejb.ExposicionEJB")
	private ExposicionEJB expoEJB;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExposicionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Exposicion> expos = expoEJB.listarExposiciones();
		
		HttpSession session = request.getSession(true);//CREAMOS UNA SESSION
		session.setAttribute("exposicion", expos); //SETEAMOS AL USUARIO EN LA SESSION, COMO ATRIBUTO
		request.getRequestDispatcher("listarExposicion.jsp").forward(request, response);//PASAMOS EL CONTROL DE LA PETICION AL RECURSO listarExposicion.jsp
	
/*		
		//IMPRIMIR EN CONSOLA
		for (Exposicion exposicion : expos) {
			
			System.out.println(exposicion.getDescripcion());
		} 
		
		//IMPRIMIR EN HTML
		PrintWriter out;
		out = response.getWriter();
		
		response.setContentType("text/html");
		
		out.println("<html>");
		out.println("<head><title>Ejemplo de Servlets</title></head>");
		out.println("<body>");
		out.println("<h1>Lista de Exposiciones</h1>");
		out.println("<br>");
		for (Exposicion exposicion : expos) {
			out.println("<h3>" + exposicion.getDescripcion() + "</h3>");
			
		}
		out.println("</body></html>");
*/		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
//		RequestDispatcher a=request.getRequestDispatcher("listarExposicion.jsp");
//		a.forward(request, response);
	}

}
