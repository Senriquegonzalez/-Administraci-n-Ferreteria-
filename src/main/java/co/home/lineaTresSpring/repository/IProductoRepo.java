package co.home.lineaTresSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.home.lineaTresSpring.entity.Producto;
@Repository
public interface IProductoRepo extends JpaRepository<Producto,Integer>{

}
