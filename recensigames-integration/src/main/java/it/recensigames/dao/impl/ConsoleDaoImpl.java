package it.recensigames.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.recensigames.dao.ConsoleDao;
import it.recensigames.model.Console;
@Component
public class ConsoleDaoImpl implements ConsoleDao {
	@PersistenceContext(unitName="recensigamesDS")
	EntityManager entityManager;
	@Override
	public List<Console> getAllConsoles() {
		return entityManager.createNamedQuery("getAllConsoles").getResultList();
	}
	@Override
	public List<Console> getConsolesByProductor(String nomeProduttoreConsoles) {
		return entityManager.createNamedQuery("getConsolesByProductor").setParameter("nomeProduttoreConsoles", nomeProduttoreConsoles).getResultList();
	}
}