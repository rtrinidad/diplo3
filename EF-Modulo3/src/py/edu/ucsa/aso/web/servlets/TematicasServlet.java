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

import com.google.gson.Gson;

import py.edu.ucsa.aso.ejb.TematicaParticExpoSocioEJB;
import py.edu.ucsa.aso.ejb.entities.TematicaParticExpoSocio;







/**
 * Servlet implementation class TematicasServlet
 */
@WebServlet("/Tematicas")
public class TematicasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName="java:global/AsoEJB/TematicaParticExpoSocioEJBImpl!py.edu.ucsa.aso.ejb.TematicaParticExpoSocioEJB")
    private TematicaParticExpoSocioEJB tematicaParticExpoSocioEJB;  
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TematicasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<TematicaParticExpoSocio> tematicas = tematicaParticExpoSocioEJB.listarTematicaParticExpoSocioByParticExpoSocio(Integer.parseInt(request.getParameter("id_expo")));
		//List<TematicaParticExpoSocio> tematicas = tematicaParticExpoSocioEJB.listarTematicaParticExpoSocioByParticExpoSocio(1);

		//HttpSession session = request.getSession(true);//CREAMOS UNA SESSION
		//session.setAttribute("tematicas", tematicas); //SETEAMOS LA LISTA DE PARTICIPACIONES DEL SOCIO A LA SESSION, COMO ATRIBUTO 

		//request.getRequestDispatcher("Exposiciones.jsp").forward(request, response);//PASAMOS EL CONTROL DE LA PETICION AL RECURSO Exposiciones.jsp
		
		String json = new Gson().toJson(tematicas);
		response.getWriter().write(json);
		//System.out.println(json);
	}

}
