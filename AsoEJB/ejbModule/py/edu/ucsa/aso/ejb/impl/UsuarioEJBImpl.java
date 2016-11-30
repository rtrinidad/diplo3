package py.edu.ucsa.aso.ejb.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import py.edu.ucsa.aso.ejb.UsuarioEJB;
import py.edu.ucsa.aso.ejb.entities.Usuario;

/**
 * Session Bean implementation class UsuarioEJBImpl
 */
@Stateless
public class UsuarioEJBImpl implements UsuarioEJB {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UsuarioEJBImpl() {
        // TODO Auto-generated constructor stub
    }



	@Override
	public Usuario autenticar(String usuario, String clave) {
		
		Usuario usu = null;
				
	
		
			if (usu != null){
				Query q = em.createNamedQuery("Usuario.findByUsuario");
				q.setParameter("usuario", usuario);
				q.setParameter("clave", clave);
				usu = (Usuario) q.getSingleResult();
				
			}
			
			
			 em.createQuery("SELECT u FROM Usuario u WHERE u.usuario like :usuario and u.clave = ;clave");
			 em.setParameter("usuario", usuario);
			 em.setParameter("clave", clave);
			 .getResulList()
		
		return usu;

	}

	@Override
	public List<Usuario> listar() {
		
		//return em.createQuery("From Usuario").getResultList();
	}

	@Override
	public Usuario getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Usuario usu) {
		em.persist(usu);
		
	}

	@Override
	public void actualizar(Usuario objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}




}
