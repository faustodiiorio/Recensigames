package it.recensigames.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.recensigames.dao.ProduttoreConsolesDao;
import it.recensigames.model.ProduttoreConsoles;
@Component
public class ProduttoreConsolesDaoImpl implements ProduttoreConsolesDao {
	@PersistenceContext(unitName="recensigamesDS")
	private EntityManager entityManager;
	@Override
	public List<ProduttoreConsoles> getAllConsoleProductors() {
		return entityManager.createNamedQuery("getAllConsoleProductors").getResultList();
	}
}