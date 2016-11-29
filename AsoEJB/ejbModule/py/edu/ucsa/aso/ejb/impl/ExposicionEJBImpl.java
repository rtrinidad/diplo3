package py.edu.ucsa.aso.ejb.impl;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.edu.ucsa.aso.ejb.ExposicionEJB;
import py.edu.ucsa.aso.ejb.entities.Exposicion;



/**
 * Session Bean implementation class ExposicionEJBImpl
 */

@Stateless
public class ExposicionEJBImpl implements ExposicionEJB {
  
	@PersistenceContext
	private EntityManager em;
	
    public ExposicionEJBImpl() {
      
    }

	@Override
	public List<Exposicion> listarExposiciones() {
		
		return em.createNamedQuery("Exposicion.findAll").getResultList();
		 
	}

	@Override
	public List<Exposicion> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exposicion getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Exposicion objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Exposicion objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	
    
    

}
