package it.recensigames.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.recensigames.dao.RecensioneDao;
import it.recensigames.model.Recensione;
@Component
public class RecensioneDaoImpl implements RecensioneDao {
	@PersistenceContext(unitName="recensigamesDS")
	private EntityManager entityManager;
	@Override
	public List<Recensione> getAllSolutions() {
		return entityManager.createNamedQuery("getAllSolutions").getResultList();
	}
	@Override
	public List<Recensione> getReviewsByUser(String username) {
		return entityManager.createNamedQuery("getReviewsByUser").setParameter("username", username).getResultList();
	}
}