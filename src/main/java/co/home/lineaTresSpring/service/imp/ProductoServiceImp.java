package co.home.lineaTresSpring.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.home.lineaTresSpring.entity.Producto;
import co.home.lineaTresSpring.exception.GuardarException;
import co.home.lineaTresSpring.exception.NoencontradoException;
import co.home.lineaTresSpring.repository.IProductoRepo;
import co.home.lineaTresSpring.services.IProductoService;


@Service
public class ProductoServiceImp implements IProductoService{
	
	    
	@Autowired
	private IProductoRepo productorepo;

	@Override
	public void guardar(Producto producto) throws GuardarException {
		if(producto.getIdProducto()!= null) {
			 Boolean existe=productorepo.existsById(producto.getIdProducto());
			 if(existe==true) {
				 throw new GuardarException("ya existe un producto con este id");
			 }
			 else {
				 this.productorepo.save(producto);				 
			 }
			
		}
		else {
			this.productorepo.save(producto);
		}	
		
	}
	
	
	@Override
	public Producto retornarPorId(int id) throws NoencontradoException {	
		if(productorepo.existsById(id)==true) {
			return productorepo.findById(id).get();
		}
		else {
			 throw new NoencontradoException("No se encuentra ningun producto con el id "+ id);
		}
		
	}

	@Override
	public List<Producto> retornarTodo() {
		// TODO Auto-generated method stub
		return productorepo.findAll();
	}

	@Override
	public Producto modificar(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) throws NoencontradoException {
		if(productorepo.existsById(id)==true) {			
			 productorepo.deleteById(id);
		}
		else {
			 throw new NoencontradoException("No se encuentra ningun producto con el id "+ id);
		}
		
	}

	@Override
	public void cambiarEstado(int id)throws NoencontradoException {
		if(productorepo.existsById(id)==true) {
			Producto producto=productorepo.findById(id).get();			
			if(producto.getActivo()==true) {
				producto.setActivo(false);
			this.productorepo.save(producto);
			}
			else {
				producto.setActivo(true);
				this.productorepo.save(producto);
			}			
			 
		}
		else {
			 throw new NoencontradoException("No se encuentra ningun producto con el id "+ id);
		}
		
	}


	@Override
	public List<Producto> retornarActivo() {
		List<Producto> productoActivo = (List<Producto>) productorepo.productoActivo();
				return productoActivo;
	}


	@Override
	public List<Producto> retornarInactivo() {		
		List<Producto> productoActivo = (List<Producto>) productorepo.productoInactivo();
		return productoActivo;
	}
	
	


}
