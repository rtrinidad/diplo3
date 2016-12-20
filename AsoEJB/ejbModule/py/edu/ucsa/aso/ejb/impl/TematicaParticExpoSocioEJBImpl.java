package py.edu.ucsa.aso.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import py.edu.ucsa.aso.ejb.TematicaParticExpoSocioEJB;
import py.edu.ucsa.aso.ejb.entities.TematicaParticExpoSocio;


@Stateless
public class TematicaParticExpoSocioEJBImpl implements TematicaParticExpoSocioEJB {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<TematicaParticExpoSocio> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TematicaParticExpoSocio getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(TematicaParticExpoSocio objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(TematicaParticExpoSocio objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TematicaParticExpoSocio> listarTematicaParticExpoSocioByParticExpoSocio(int idParticExpoSocio) {
		
		//List<TematicaParticExpoSocio> tematicas= em.createQuery("SELECT t.id,t.canceloParticTematica,t.fechaCancelacion,t.fechaCreacion,t.tematicaEspecifica,t.tematicaGeneral,t.particExpoSocio FROM TematicaParticExpoSocio t WHERE t.particExpoSocio.id = :idParticExpoSocio")
		List<TematicaParticExpoSocio> tematicas= em.createQuery("SELECT t FROM TematicaParticExpoSocio t WHERE t.particExpoSocio.id = :idParticExpoSocio")
		.setParameter("idParticExpoSocio", idParticExpoSocio)
		   .getResultList();
		return tematicas;
		
	}

	@Override
	public void cancelarParticipacionTematica(List<TematicaParticExpoSocio> tematicasExpoSocio) {
		
		for (TematicaParticExpoSocio tematicaParticExpoSocio : tematicasExpoSocio) {
			
			int id = tematicaParticExpoSocio.getId();
			
			Query query = em.createQuery("UPDATE TematicaParticExpoSocio t SET t.canceloParticTematica = TRUE and t.fechaCancelacion = currentTimeStamp() WHERE t.id = :id");
			query.executeUpdate();
		}
		
	}
	
	
}
