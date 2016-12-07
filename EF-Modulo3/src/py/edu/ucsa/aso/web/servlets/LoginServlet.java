package py.edu.ucsa.aso.web.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.edu.ucsa.aso.ejb.UsuarioEJB;
import py.edu.ucsa.aso.ejb.entities.Usuario;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		
	@EJB(mappedName="java:global/AsoEJB/UsuarioEJBImpl!py.edu.ucsa.aso.ejb.UsuarioEJB")
	private UsuarioEJB usuarioEJB;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if (validarDatosIngresados(request)){
			Usuario usu = usuarioEJB.autenticar(request.getParameter("usuario"), request.getParameter("clave"));
			if (usu != null){ //NOS LOGUEAMOS EXITOSAMENTE
				HttpSession session = request.getSession(true);//CREAMOS UNA SESSION
				session.setAttribute("usuario", usu); //SETEAMOS AL USUARIO EN LA SESSION, COMO ATRIBUTO
				
				
				request.getRequestDispatcher("Exposiciones.jsp").forward(request, response);//PASAMOS EL CONTROL DE LA PETICI�N AL RECURSO Exposiciones.jsp
			}else{//SI EL USUARIO NO SE AUTENTICO
				request.getRequestDispatcher("Login.jsp").forward(request, response);//PASAMOS EL CONTROL DE LA PETICI�N AL RECURSO Login.jsp
			}
		}else{//SI NO SE PUDIERON OBTENER LOS DATOS PARA LA AUTENTICACI�N: usuario y clave
			request.getRequestDispatcher("Login.jsp").forward(request, response);//PASAMOS EL CONTROL DE LA PETICI�N AL RECURSO Login.jsp
		}
	}

	private boolean validarDatosIngresados(HttpServletRequest request) {
		return request.getParameter("usuario") != null
				&& request.getParameter("clave") != null
				&& !"".equals(request.getParameter("usuario").trim())
				&& !"".equals(request.getParameter("clave").trim());
	}
	

}
