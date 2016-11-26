package py.edu.ucsa.aso.ejb.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the pagos_cuotas_socios database table.
 * 
 */
@Entity
@Table(name="pagos_cuotas_socios")
@NamedQueries({
	@NamedQuery(name="PagoCuotaSocio.findAll", query="SELECT p FROM PagoCuotaSocio p"),
    @NamedQuery(name="PagoCuotaSocio.findByIdSocio",
                query="SELECT p FROM PagoCuotaSocio p WHERE p.socio.id = :idSocio")
}) 
public class PagoCuotaSocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="anho_cuota")
	private BigDecimal anhoCuota;

	private Boolean exonerado;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_pago")
	private Timestamp fechaPago;

	@Column(name="mes_cuota")
	private BigDecimal mesCuota;

	@Column(name="monto_cuota")
	private BigDecimal montoCuota;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_medio_pago")
	private Opcion medioPago;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Opcion estado;

	//uni-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_motivo_exoneracion")
	private Opcion motivoExoneracion;

	//uni-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio")
	private Socio socio;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioCreacion;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_aprobacion")
	private Usuario usuarioAprobacion;

	public PagoCuotaSocio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAnhoCuota() {
		return this.anhoCuota;
	}

	public void setAnhoCuota(BigDecimal anhoCuota) {
		this.anhoCuota = anhoCuota;
	}

	public Boolean getExonerado() {
		return this.exonerado;
	}

	public void setExonerado(Boolean exonerado) {
		this.exonerado = exonerado;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Timestamp fechaPago) {
		this.fechaPago = fechaPago;
	}

	public BigDecimal getMesCuota() {
		return this.mesCuota;
	}

	public void setMesCuota(BigDecimal mesCuota) {
		this.mesCuota = mesCuota;
	}

	public BigDecimal getMontoCuota() {
		return this.montoCuota;
	}

	public void setMontoCuota(BigDecimal montoCuota) {
		this.montoCuota = montoCuota;
	}

	public Opcion getMedioPago() {
		return this.medioPago;
	}

	public void setMedioPago(Opcion medioPago) {
		this.medioPago = medioPago;
	}

	public Opcion getEstado() {
		return this.estado;
	}

	public void setEstado(Opcion estado) {
		this.estado = estado;
	}

	public Opcion getMotivoExoneracion() {
		return this.motivoExoneracion;
	}

	public void setMotivoExoneracion(Opcion motivoExoneracion) {
		this.motivoExoneracion = motivoExoneracion;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Usuario getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Usuario getUsuarioAprobacion() {
		return this.usuarioAprobacion;
	}

	public void setUsuarioAprobacion(Usuario usuarioAprobacion) {
		this.usuarioAprobacion = usuarioAprobacion;
	}

}