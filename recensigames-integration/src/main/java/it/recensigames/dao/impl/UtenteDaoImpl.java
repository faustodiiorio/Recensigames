package it.recensigames.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import it.recensigames.dao.UtenteDao;
import it.recensigames.model.Utente;

@Component
public class UtenteDaoImpl implements UtenteDao {
	@PersistenceContext(unitName="recensigamesDS")
	EntityManager entityManager;
	@Override
	public List<Utente> getAllUsers() {
		return entityManager.createNamedQuery("getAllUsers").getResultList();
	}
	@Override
	public Utente getUserByUsernameAndPassword(String username, String password) {
		Query query = entityManager.createNamedQuery("getUserByUsernameAndPassword");
		query.setParameter("username", username);
		query.setParameter("password", password);
		return (Utente)query.getSingleResult();
	}
}