package co.home.lineaTresSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.home.lineaTresSpring.entity.DetalleFacturaVenta;

@Repository
public interface IDetalleFacturaVenta extends JpaRepository<DetalleFacturaVenta,Integer>{

}
