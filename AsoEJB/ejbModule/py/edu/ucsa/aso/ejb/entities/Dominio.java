package py.edu.ucsa.aso.ejb.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dominios database table.
 * 
 */
@Entity
@Table(name="dominios")
@NamedQuery(name="Dominio.findAll", query="SELECT d FROM Dominio d")
public class Dominio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private String descripcion;

	//uni-directional many-to-one association to Dominio
	@ManyToOne
	@JoinColumn(name="id_dominio_padre")
	private Dominio dominioPadre;

	public Dominio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Dominio getDominioPadre() {
		return this.dominioPadre;
	}

	public void setDominioPadre(Dominio dominioPadre) {
		this.dominioPadre = dominioPadre;
	}

}