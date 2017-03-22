package it.recensigames.dao;

import java.util.List;

import it.recensigames.model.Domanda;

public interface DomandaDao {
	List<Domanda> getAllQuestions();
	List<Domanda> getQuestionsByGame(String titoloGioco, String nomeConsole);
	List<Domanda> getQuestionsByUser(String username);
}