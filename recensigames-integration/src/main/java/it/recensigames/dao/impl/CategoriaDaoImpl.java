package it.recensigames.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.recensigames.dao.CategoriaDao;
import it.recensigames.model.Categoria;
@Component
public class CategoriaDaoImpl implements CategoriaDao {
	@PersistenceContext(unitName="recensigamesDS")
	EntityManager entityManager;
	
	@Override
	public List<Categoria> getAllCategories() {
		return entityManager.createNamedQuery("getAllCategories").getResultList();
	}
}