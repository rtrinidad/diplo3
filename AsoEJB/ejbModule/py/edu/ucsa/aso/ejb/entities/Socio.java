package py.edu.ucsa.aso.ejb.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the socios database table.
 * 
 */
@Entity
@Table(name="socios")
@NamedQuery(name="Socio.findAll", query="SELECT s FROM Socio s")
public class Socio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String apellidos;

	private String email;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_estado_actual")
	private Timestamp fechaEstadoActual;

	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;

	private Boolean fundador;

	private String nombres;

	@Column(name="nro_cedula")
	private BigDecimal nroCedula;

	@Column(name="nro_socio")
	private BigDecimal nroSocio;

	//bi-directional many-to-one association to ParticExpoSocio
	//@OneToMany(mappedBy="socio")
	//private List<ParticExpoSocio> particExpoSocios;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_estado_actual")
	private Opcion estadoActual;

	//uni-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio_proponente")
	private Socio socioProponente;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioCreacion;

	public Socio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaEstadoActual() {
		return this.fechaEstadoActual;
	}

	public void setFechaEstadoActual(Timestamp fechaEstadoActual) {
		this.fechaEstadoActual = fechaEstadoActual;
	}

	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Boolean getFundador() {
		return this.fundador;
	}

	public void setFundador(Boolean fundador) {
		this.fundador = fundador;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public BigDecimal getNroCedula() {
		return this.nroCedula;
	}

	public void setNroCedula(BigDecimal nroCedula) {
		this.nroCedula = nroCedula;
	}

	public BigDecimal getNroSocio() {
		return this.nroSocio;
	}

	public void setNroSocio(BigDecimal nroSocio) {
		this.nroSocio = nroSocio;
	}

//	public List<ParticExpoSocio> getParticExpoSocios() {
//		return this.particExpoSocios;
//	}
//
//	public void setParticExpoSocios(List<ParticExpoSocio> particExpoSocios) {
//		this.particExpoSocios = particExpoSocios;
//	}

//	public ParticExpoSocio addParticExpoSocio(ParticExpoSocio particExpoSocio) {
//		getParticExpoSocios().add(particExpoSocio);
//		particExpoSocio.setSocio(this);
//
//		return particExpoSocio;
//	}
//
//	public ParticExpoSocio removeParticExpoSocio(ParticExpoSocio particExpoSocio) {
//		getParticExpoSocios().remove(particExpoSocio);
//		particExpoSocio.setSocio(null);
//
//		return particExpoSocio;
//	}

	public Opcion getEstadoActual() {
		return this.estadoActual;
	}

	public void setEstadoActual(Opcion estadoActual) {
		this.estadoActual = estadoActual;
	}

	public Socio getSocioProponente() {
		return this.socioProponente;
	}

	public void setSocioProponente(Socio socioProponente) {
		this.socioProponente = socioProponente;
	}

	public Usuario getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

}