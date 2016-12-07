package py.edu.ucsa.aso.ejb;

import java.util.List;

import javax.ejb.Remote;


import py.edu.ucsa.aso.ejb.entities.Socio;
import py.edu.ucsa.aso.ejb.entities.TematicaParticExpoSocio;




@Remote
public interface TematicaParticExpoSocioEJB extends CrudEJB<TematicaParticExpoSocio> {

	public List<TematicaParticExpoSocio> listarTematicaParticExpoSocioByParticExpoSocio(int idParticExpoSocio);
	
	//public void cancelarParticipacionTematica(Socio s, List<TematicaParticExpoSocio> tematicasExpoSocio);
	
	public void cancelarParticipacionTematica(List<TematicaParticExpoSocio> tematicasExpoSocio);
	
	
}
