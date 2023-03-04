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
@Table(name="producto_proveedor")
public class ProductoProveedor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn (name="id_producto")
	private Producto idproducto;
	@ManyToOne
	@JoinColumn (name="id_proveedor")
	private Proveedor idproveedor;
	@NotNull
	@Column(name="precio",columnDefinition = "double precision")
	private Double precio;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Producto getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(Producto idproducto) {
		this.idproducto = idproducto;
	}
	public Proveedor getIdproveedor() {
		return idproveedor;
	}
	public void setIdproveedor(Proveedor idproveedor) {
		this.idproveedor = idproveedor;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
