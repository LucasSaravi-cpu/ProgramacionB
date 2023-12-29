package com.restapi.demo.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restapi.demo.objects.entities.Marca;
import com.restapi.demo.objects.entities.Producto;

@Repository
@Transactional
public class ProductoDAO {
	protected static final Logger logger = LoggerFactory.getLogger(ProductoDAO.class);
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public Producto getProducto(Integer productoID) {
		return entityManager.find(Producto.class, productoID);
	}
	
	@Transactional(readOnly = true)
	public Collection<Producto> getProductos(String filterName) {
		return entityManager.createQuery(
				"select p from Producto p where lower(p.descripcion) like :filterName order by p.descripcion", Producto.class)
				.setParameter("filterName", '%' + filterName.toLowerCase() + '%').getResultList();
	}
	
	@Transactional()
	public void save(Producto producto) {
		if (producto.getProducto()  == null) 
			entityManager.persist(producto);
		else 
			entityManager.merge(producto);
	}
	
	@Transactional()
	public void delete(Producto producto) {		
		entityManager.remove(entityManager.contains(producto) ? producto : entityManager.merge(producto));
	}
	
	@Transactional(readOnly = true)
	public Collection<Marca> getMarcas(String filterName) {
		return entityManager.createQuery("select m from Marca m where lower(m.nombre) like :filterName order by m.nombre", Marca.class).setParameter("filterName", '%' + filterName.toLowerCase() + '%').getResultList();
	}
	
	@Transactional()
	public void save(Marca marca) {
		if (marca.getMarca()  == null) {
			entityManager.persist(marca);
		}
		else { 
			entityManager.merge(marca);
		}
	}
	
	@Transactional()
	public void delete(Marca marca) {		
		entityManager.remove(entityManager.contains(marca) ? marca : entityManager.merge(marca));
	}
}
