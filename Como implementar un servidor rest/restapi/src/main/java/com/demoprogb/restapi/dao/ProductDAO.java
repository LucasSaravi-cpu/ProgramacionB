package com.demoprogb.restapi.dao;

import java.util.Collection;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demoprogb.objects.entities.Marca;
import com.demoprogb.objects.entities.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



@Repository
@Transactional
public class ProductDAO {
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public Producto getProducto(Integer productoID) {
		return entityManager.find(Producto.class, productoID);
	}
	
	@Transactional(readOnly = true)
	public Collection<Producto> getProductos(String filterName) {
		return entityManager.createQuery("select p from Producto p where lower(p.descripcion) like :filterName order by p.descripcion", Producto.class).setParameter("filterName", '%' + filterName.toLowerCase() + '%').getResultList();
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
entityManager.remove(entityManager.contains(producto) ? producto : 
entityManager.merge(producto));
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
entityManager.remove(entityManager.contains(marca) ? marca : 
entityManager.merge(marca));
	}
}
