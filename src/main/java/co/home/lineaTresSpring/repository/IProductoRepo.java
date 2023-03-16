package co.home.lineaTresSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.home.lineaTresSpring.entity.Producto;
@Repository
public interface IProductoRepo extends JpaRepository<Producto,Integer>{
	
	@Query( value = "Select p from Producto p where p.activo = true")
	List<Producto> productoActivo();
	
	@Query(value = "Select p from Producto p where p.activo = false ")
	List<Producto> productoInactivo();

}
