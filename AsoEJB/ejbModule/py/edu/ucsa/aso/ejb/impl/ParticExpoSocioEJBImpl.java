package py.edu.ucsa.aso.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import py.edu.ucsa.aso.ejb.ParticExpoSocioEJB;
import py.edu.ucsa.aso.ejb.entities.ParticExpoSocio;

@Stateless
public class ParticExpoSocioEJBImpl implements ParticExpoSocioEJB {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<ParticExpoSocio> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParticExpoSocio getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(ParticExpoSocio objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(ParticExpoSocio objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ParticExpoSocio> listarParticExpoSocioBySocio(int idSocio) {
		
		
		Query q = em.createNamedQuery("ParticExpoSocio.findBySocio");
		q.setParameter("idSocio", idSocio);
		return q.getResultList();
		
	}

}
