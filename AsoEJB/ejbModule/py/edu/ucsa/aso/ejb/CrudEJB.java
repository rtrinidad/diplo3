package py.edu.ucsa.aso.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CrudEJB<T> {
	
	
	List<T> listar();
	T getById(Long id);
	
	//Metodos para modificar datos de objeto(s)
	void insertar(T objeto);
	void actualizar(T objeto);
	void eliminar(Long id);
	

}
