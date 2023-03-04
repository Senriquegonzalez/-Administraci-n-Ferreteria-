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
@Table(name="factura_proveedor")
public class FacturaProveedor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn (name="id_proveedor")
	private Proveedor idproveedor;
	@NotNull
	@Column(name="fecha")	
	private LocalDateTime fecha;
	@NotNull
	@Column(name="total",columnDefinition = "double precision")
	private float Total;
	@OneToMany( mappedBy="idFacturaProveedor",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	private List<DetallesFacturaProveedor> detallesFacturaProveedor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Proveedor getIdproveedor() {
		return idproveedor;
	}
	public void setIdproveedor(Proveedor idproveedor) {
		this.idproveedor = idproveedor;
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
	public List<DetallesFacturaProveedor> getDetallesFacturaProveedor() {
		return detallesFacturaProveedor;
	}
	public void setDetallesFacturaProveedor(List<DetallesFacturaProveedor> detallesFacturaProveedor) {
		this.detallesFacturaProveedor = detallesFacturaProveedor;
	}
	
}
