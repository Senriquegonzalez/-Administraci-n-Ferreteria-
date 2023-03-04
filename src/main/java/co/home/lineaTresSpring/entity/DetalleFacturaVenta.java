package co.home.lineaTresSpring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@Table (name="detalle_factura_venta")
public class DetalleFacturaVenta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn (name="id_factura_venta")
	private FacturaVenta idFacturaVenta;
	@ManyToOne
	@JoinColumn (name="id_producto")	
	private Producto idproducto;
	@NotNull
	@Column(name="cantidad",columnDefinition = "integer")
	private int cantidad;
	@NotNull
	@Column(name="precio",columnDefinition = "double precision")
	private Double precio;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public FacturaVenta getIdFacturaVenta() {
		return idFacturaVenta;
	}
	public void setIdFacturaVenta(FacturaVenta idFacturaVenta) {
		this.idFacturaVenta = idFacturaVenta;
	}
	public Producto getIdProducto() {
		return idproducto;
	}
	public void setIdProducto(Producto idProducto) {
		idproducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
