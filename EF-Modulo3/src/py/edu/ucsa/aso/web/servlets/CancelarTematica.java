package py.edu.ucsa.aso.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import py.edu.ucsa.aso.ejb.TematicaParticExpoSocioEJB;
import py.edu.ucsa.aso.ejb.entities.TematicaParticExpoSocio;

/**
 * Servlet implementation class CancelarTematica
 */
@WebServlet("/CancelarTematica")
public class CancelarTematica extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName="java:global/AsoEJB/TematicaParticExpoSocioEJBImpl!py.edu.ucsa.aso.ejb.TematicaParticExpoSocioEJB")
    private TematicaParticExpoSocioEJB tematicaParticExpoSocioEJB;  
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarTematica() {
        super();
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

		String[] tematicaCancelada = request.getParameterValues("idTema");
		
		//NO HACE FALTA, cambiando la firma del metodo cancelarParticipacionTematica enviando como parametro el idTema y no un List<Objet>
		List<TematicaParticExpoSocio> listaTematicas = new ArrayList<TematicaParticExpoSocio>();
		
		for (String tematicaId : tematicaCancelada) {
			TematicaParticExpoSocio tematica = (TematicaParticExpoSocio) tematicaParticExpoSocioEJB.tematicaParticExpoSocioById(Integer.parseInt(tematicaId));
			listaTematicas.add(tematica);
		}
		 
    	 tematicaParticExpoSocioEJB.cancelarParticipacionTematica(listaTematicas);
		request.getRequestDispatcher("Exposiciones.jsp").forward(request, response);

		
	}

}
