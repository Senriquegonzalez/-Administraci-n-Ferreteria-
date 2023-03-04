package co.home.lineaTresSpring.entity;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@Table (name="factura_venta")
public class FacturaVenta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn (name="id_usuario")
	private Usuario idUsuario;
	@NotNull
	@Column(name="fecha")	
	private LocalDateTime fecha;
	@NotNull
	@Column(name="total",columnDefinition = "double precision")
	private float Total;
	@NotNull
	@Column(name="estado")	
	private Boolean estado;
	@OneToMany( mappedBy="idFacturaVenta",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	private List<DetalleFacturaVenta> detalleFacturaVenta;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public float getTotal() {
		return Total;
	}
	public void setTotal(float total) {
		Total = total;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public List<DetalleFacturaVenta> getDetalleFacturaVenta() {
		return detalleFacturaVenta;
	}
	public void setDetalleFacturaVenta(List<DetalleFacturaVenta> detalleFacturaVenta) {
		this.detalleFacturaVenta = detalleFacturaVenta;
	}

}
