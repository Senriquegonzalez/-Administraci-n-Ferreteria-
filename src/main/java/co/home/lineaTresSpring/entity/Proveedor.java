package co.home.lineaTresSpring.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProveedor;
	@NotNull
	@Column(name="nombre", length=30, nullable=false)
	private String nombre;
	@NotNull
	@Column(name="direccion", length=30,nullable=false)
	private String direccion;
	@NotNull
	@Column(name="telefono")
	private String telefono;
	@OneToMany( mappedBy="idproveedor",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	private List<ProductoProveedor> productoProveedor;
	@OneToMany( mappedBy="idproveedor",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	private List<FacturaProveedor> facturaProveedor;
	
	
	public List<FacturaProveedor> getFacturaProveedor() {
		return facturaProveedor;
	}
	public void setFacturaProveedor(List<FacturaProveedor> facturaProveedor) {
		this.facturaProveedor = facturaProveedor;
	}
	public List<ProductoProveedor> getProductoProveedor() {
		return productoProveedor;
	}
	public void setProductoProveedor(List<ProductoProveedor> productoProveedor) {
		this.productoProveedor = productoProveedor;
	}
	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	} 
	

}
