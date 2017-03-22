package it.recensigames.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import it.recensigames.dao.DomandaDao;
import it.recensigames.model.Domanda;

@Component
public class DomandaDaoImpl implements DomandaDao {
	@PersistenceContext(unitName="recensigamesDS")
	private EntityManager entityManager;
	
	@Override
	public List<Domanda> getAllQuestions() {
		return entityManager.createNamedQuery("getAllQuestions").getResultList();
	}

	@Override
	public List<Domanda> getQuestionsByGame(String titoloGioco, String nomeConsole) {
		Query query = entityManager.createNamedQuery("getQuestionsByGame");
		query.setParameter("titoloGioco", titoloGioco);
		query.setParameter("nomeConsole", nomeConsole);
		return query.getResultList();
	}

	@Override
	public List<Domanda> getQuestionsByUser(String username) {
		return entityManager.createNamedQuery("getQuestionsByUser").setParameter("username", username).getResultList();
	}
}