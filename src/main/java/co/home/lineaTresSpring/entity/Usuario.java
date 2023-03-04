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
@Table (name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	@NotNull	
	@Column(name="nombre", length=30, nullable=false)
	private String nombre;
	@NotNull	
	@Column(name="apellido", length=30, nullable=false)
	private String apellido;
	@Column(name="cedula",columnDefinition = "double precision")
	private String cedula;
	@NotNull	
	@Column(name="direccion", length=30, nullable=false)
	private String direccion;
	@Column(name="telefono",columnDefinition = "double precision")
	private String telefono;
	@OneToMany( mappedBy="idUsuario",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	private List<FacturaVenta> facturaVenta;
	public Integer getIdUsuario() {
		return id;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.id= idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public List<FacturaVenta> getFacturaVenta() {
		return facturaVenta;
	}
	public void setFacturaVenta(List<FacturaVenta> facturaVenta) {
		this.facturaVenta = facturaVenta;
	}

}
