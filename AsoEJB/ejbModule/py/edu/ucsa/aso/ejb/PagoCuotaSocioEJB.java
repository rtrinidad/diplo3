package py.edu.ucsa.aso.ejb;

import java.util.List;

import javax.ejb.Remote;

import py.edu.ucsa.aso.ejb.entities.PagoCuotaSocio;




@Remote
public interface PagoCuotaSocioEJB {

	public List<PagoCuotaSocio> listarCuotasPagadasPorSocio(int idSocio);
	
}
