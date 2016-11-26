package py.edu.ucsa.aso.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import py.edu.ucsa.aso.ejb.PagoCuotaSocioEJB;
import py.edu.ucsa.aso.ejb.entities.PagoCuotaSocio;


@Stateless
public class PagoCuotaSocioEJBImpl implements PagoCuotaSocioEJB {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<PagoCuotaSocio> listarCuotasPagadasPorSocio(int idSocio) {
	
			Query q = em.createNamedQuery("PagoCuotaSocio.findByIdSocio");
			q.setParameter("idSocio", idSocio);
			return q.getResultList();
	}

}
