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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@Table (name="tipo_producto")
public class TipoProducto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer idTipoProducto;
	@NotNull	
	@Column(name="nombre", length=30, nullable=false)
	private String nombre;
	@NotNull
	@Column(name="descripcion",length=250)
	private String descripcion;
    @OneToMany( mappedBy="tipoProducto",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	private List<Producto> producto;
    
    
	public Integer getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(Integer idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
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
	@JsonIgnore
	public List<Producto> getProducto() {
		return producto;
	}
	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

}
