package py.edu.ucsa.aso.ejb.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String clave;

	@Column(name="cuenta_bloqueada")
	private Boolean cuentaBloqueada;

	@Column(name="cuenta_expirada")
	private Boolean cuentaExpirada;

	private String email;

	@Column(name="fecha_creacion_usuario")
	private Timestamp fechaCreacionUsuario;

	private Boolean habilitado;

	private String usuario;

	//bi-directional many-to-many association to Rol
	@ManyToMany(mappedBy="usuario")
	private List<Rol> rol;

	//uni-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio")
	private Socio socio;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Boolean getCuentaBloqueada() {
		return this.cuentaBloqueada;
	}

	public void setCuentaBloqueada(Boolean cuentaBloqueada) {
		this.cuentaBloqueada = cuentaBloqueada;
	}

	public Boolean getCuentaExpirada() {
		return this.cuentaExpirada;
	}

	public void setCuentaExpirada(Boolean cuentaExpirada) {
		this.cuentaExpirada = cuentaExpirada;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getFechaCreacionUsuario() {
		return this.fechaCreacionUsuario;
	}

	public void setFechaCreacionUsuario(Timestamp fechaCreacionUsuario) {
		this.fechaCreacionUsuario = fechaCreacionUsuario;
	}

	public Boolean getHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Rol> getRol() {
		return this.rol;
	}

	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}