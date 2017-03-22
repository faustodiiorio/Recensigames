package it.recensigames.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import it.recensigames.dao.RispostaDao;
import it.recensigames.model.Risposta;

@Component
public class RispostaDaoImpl implements RispostaDao {
	@PersistenceContext(unitName="recensigamesDS")
	private EntityManager entityManager;
	
	@Override
	public List<Risposta> getAllAnswers() {
		return entityManager.createNamedQuery("getAllAnswers").getResultList();
	}

	@Override
	public List<Risposta> getAnswersByQuestion(String username, String titoloDomanda) {
		Query query = entityManager.createNamedQuery("getAnswersByQuestion");
		query.setParameter("username", username);
		query.setParameter("titoloDomanda", titoloDomanda);
		return query.getResultList();
	}

	@Override
	public List<Risposta> getAnswersByUser(String username) {
		return entityManager.createNamedQuery("getAnswersByUser").setParameter("username", username).getResultList();
	}
}