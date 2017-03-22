package it.recensigames.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import it.recensigames.dao.GiocoDao;
import it.recensigames.model.Gioco;
@Component
public class GiocoDaoImpl implements GiocoDao {
	@PersistenceContext(unitName="recensigamesDS")
	private EntityManager entityManager;
	@Override
	public List<Gioco> getAllGames() {
		return entityManager.createNamedQuery("getAllGames").getResultList();
	}
	@Override
	public List<Gioco> getGamesByTitle(String titoloGioco){
		return entityManager.createNamedQuery("getGamesByTitle").setParameter("titoloGioco", titoloGioco).getResultList();
	}
	@Override
	public List<Gioco> getGamesByConsole(String nomeConsole){
		return entityManager.createNamedQuery("getGamesByConsole").setParameter("nomeConsole", nomeConsole).getResultList();
	}
	@Override
	public Gioco getGameByTitleAndConsole(String titoloGioco, String nomeConsole){
		Query query = entityManager.createNamedQuery("getGameByTitleAndConsole");
		query.setParameter("titoloGioco", titoloGioco);
		query.setParameter("nomeConsole", nomeConsole);
		return (Gioco)query.getSingleResult();
	}
}