package py.edu.ucsa.aso.ejb.impl;

import java.util.List;


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
		
	//Usuario	usu = null;	
	Usuario usu= (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.usuario like :usuario and u.clave like :clave")
				.setParameter("usuario", usuario)
				.setParameter("clave", clave)
				.getSingleResult();

	
	
	 return	usu;

	}

	@Override
	public List<Usuario> listar() {
		
		
		return em.createNamedQuery("Usuario.findAll").getResultList();
		//return null;
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
