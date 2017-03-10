package it.recensigames.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.recensigames.dao.ProduttoreGiochiDao;
import it.recensigames.model.ProduttoreGiochi;

public class ProduttoreGiochiDaoImpl implements ProduttoreGiochiDao {
	@PersistenceContext(unitName="recensigamesDS")
	EntityManager entityManager;
	
	@Override
	public List<ProduttoreGiochi> getAllGameProductors() {
		return entityManager.createNamedQuery("getAllGameProductors").getResultList();
	}
}