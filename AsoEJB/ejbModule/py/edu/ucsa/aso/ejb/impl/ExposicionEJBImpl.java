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

	
    
    

}
