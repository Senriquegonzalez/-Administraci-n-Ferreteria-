package co.home.lineaTresSpring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.home.lineaTresSpring.entity.Producto;
import co.home.lineaTresSpring.exception.GuardarException;
import co.home.lineaTresSpring.exception.NoencontradoException;
import co.home.lineaTresSpring.services.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private  IProductoService ProductoService;
	
	@GetMapping("/obtener")
	public ResponseEntity<?> retornarproducto(){
		List<Producto> productos=ProductoService.retornarTodo();
		return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);		
	}
	
	@GetMapping("/activo")
	public ResponseEntity<?> retornarActivo(){
		List<Producto> productosActivos=ProductoService.retornarActivo();
		return new ResponseEntity<List<Producto>>(productosActivos,HttpStatus.OK);		
	}
	@GetMapping("/inactivo")
	public ResponseEntity<?> retornarInactivo(){
		List<Producto> productosInactivos=ProductoService.retornarInactivo();
		return new ResponseEntity<List<Producto>>(productosInactivos,HttpStatus.OK);		
	}
	
	@GetMapping("/obtener/{id}")
	public ResponseEntity<?> obtenerid(@PathVariable int id )throws NoencontradoException{
		Producto producto=ProductoService.retornarPorId(id);
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);		
	}
	
	@PostMapping("/Guardar")
	public ResponseEntity<?> guardarproducto(@RequestBody Producto producto) throws GuardarException {
		ProductoService.guardar(producto);
		return new ResponseEntity<Object>("",HttpStatus.CREATED);	
	}
	
	@PutMapping("/estado/{id}")
	public void ocultarproducto(@PathVariable int id) throws NoencontradoException {
		ProductoService.cambiarEstado(id);
		
		
	}
	
	

	

}
