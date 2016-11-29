package py.edu.ucsa.aso.ejb;

import java.util.List;

import javax.ejb.Remote;

import py.edu.ucsa.aso.ejb.entities.Exposicion;



@Remote
public interface ExposicionEJB extends CrudEJB<Exposicion> {
	
	
public List<Exposicion> listarExposiciones();
		

}
