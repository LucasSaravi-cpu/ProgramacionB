package com.restapi.demo.objects.rest;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demo.dao.ProductoDAO;
import com.restapi.demo.objects.entities.Marca;
import com.restapi.demo.objects.entities.Producto;

@RestController
@RequestMapping("/products")
public class RestControllerProductos {	
	@Autowired
	private ProductoDAO productoDAO;
	
	@GetMapping(value = "bienvenida")
	public ResponseEntity<String> hi() {
		return new ResponseEntity<String>("Bienvenidos!", HttpStatus.OK);
	}
	
	@GetMapping(value = "hola")
	@RequestMapping(value="hola", params = "nombre", method=RequestMethod.GET)
	public ResponseEntity<String> hello(@RequestParam("nombre") String nombre) {
		return new ResponseEntity<String>("Hola " + nombre + "!", HttpStatus.OK);
	}

    @GetMapping(value = "getProducto")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	public ResponseEntity<Producto> getProducto(@RequestParam String productoId) {
		Producto producto = productoDAO.getProducto(Integer.parseInt(productoId));
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
    @GetMapping(value = "getProductos")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	public ResponseEntity<Collection<Producto>> getProductos(@RequestParam String filterName) {
		Collection<Producto> productos = productoDAO.getProductos(filterName);
		return new ResponseEntity<Collection<Producto>>(productos, HttpStatus.OK);
	}
    
    @PostMapping(value = "/saveProducto")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveMarca(@RequestBody Producto producto){
        productoDAO.save(producto);
    }
    
    @PostMapping(value = "/deleteProducto")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteMarca(@RequestBody Producto producto){
        productoDAO.delete(producto);
    }    
	
    @GetMapping(value = "getMarcas")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	public ResponseEntity<Collection<Marca>> getMarcas(@RequestParam String filterName) {
		Collection<Marca> marcas = productoDAO.getMarcas(filterName);
		return new ResponseEntity<Collection<Marca>>(marcas, HttpStatus.OK);
	}
    
    @PostMapping(value = "/saveMarca")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveMarca(@RequestBody Marca marca){
        productoDAO.save(marca);
    }
    
    @PostMapping(value = "/deleteMarca")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteMarca(@RequestBody Marca marca){
        productoDAO.delete(marca);
    }
}
