package py.edu.ucsa.aso.ejb;


import javax.ejb.Remote;

import py.edu.ucsa.aso.ejb.entities.Usuario;





@Remote
public interface UsuarioEJB extends CrudEJB<Usuario> {
	
	
public Usuario autenticar(String usuario, String clave);

	

}
