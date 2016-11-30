package py.edu.ucsa.aso.ejb;

import java.util.List;

import javax.ejb.Remote;

import py.edu.ucsa.aso.ejb.entities.ParticExpoSocio;







@Remote
public interface ParticExpoSocioEJB extends CrudEJB<ParticExpoSocio> {

	public List<ParticExpoSocio> listarParticExpoSocioBySocio(int idSocio);
	
	
	
}
