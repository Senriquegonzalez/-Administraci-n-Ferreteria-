package co.home.lineaTresSpring.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table (name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProducto;
	@ManyToOne
	@JoinColumn (name="id_tipo_producto")
	private TipoProducto tipoProducto;
	@NotNull
	@Column(name="nombre", length=30, nullable=false)
	private String nombre;
	@NotNull
	@Column(name="descripcion", length=200)
	private String descripcion;
	@NotNull
	@Column(name="cantidad",columnDefinition = "integer")
	private int cantidad;
	@NotNull
	@Column(name="precio",columnDefinition = "double precision")
	private Double precio;
	@NotNull
	@Column(name="activo")
	private boolean activo=true;
	
	
	@OneToMany( mappedBy="idproducto",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	private List<ProductoProveedor> productoProveedor;
	
	@OneToMany( mappedBy="idproducto",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	private List< DetallesFacturaProveedor>  detallesFacturaProveedor;
	
	@OneToMany( mappedBy="idproducto",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	private List< DetalleFacturaVenta>  detalleFacturaVenta;
	
	
	@JsonIgnore
	public List<DetalleFacturaVenta> getDetalleFacturaVenta() {
		return detalleFacturaVenta;
	}
	public void setDetalleFacturaVenta(List<DetalleFacturaVenta> detalleFacturaVenta) {
		this.detalleFacturaVenta = detalleFacturaVenta;
	}
	@JsonIgnore
	public List<DetallesFacturaProveedor> getDetallesFacturaProveedor() {
		return detallesFacturaProveedor;
	}
	public void setDetallesFacturaProveedor(List<DetallesFacturaProveedor> detallesFacturaProveedor) {
		this.detallesFacturaProveedor = detallesFacturaProveedor;
	}
	@JsonIgnore
	public List<ProductoProveedor> getProductoProveedor() {
		return productoProveedor;
	}
	public void setProductoProveedor(List<ProductoProveedor> productoProveedor) {
		this.productoProveedor = productoProveedor;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	}
