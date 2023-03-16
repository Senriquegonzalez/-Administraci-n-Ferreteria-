package co.home.lineaTresSpring.services;



import java.util.List;
import java.util.Optional;

import co.home.lineaTresSpring.entity.Producto;
import co.home.lineaTresSpring.exception.GuardarException;
import co.home.lineaTresSpring.exception.NoencontradoException;

public interface IProductoService {
	public void guardar(Producto producto) throws GuardarException ;
	public Producto retornarPorId(int id)throws NoencontradoException;
	public List<Producto> retornarTodo();
	public List<Producto> retornarActivo();
	public List<Producto> retornarInactivo();
	public Producto modificar(Producto producto);
	public void eliminar(int id)throws NoencontradoException;
	public void cambiarEstado(int id)throws NoencontradoException;
	
	

}
