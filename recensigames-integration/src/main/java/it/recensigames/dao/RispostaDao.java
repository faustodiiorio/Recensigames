package it.recensigames.dao;

import java.util.List;

import it.recensigames.model.Risposta;

public interface RispostaDao {
	List<Risposta> getAllAnswers();
	List<Risposta> getAnswersByQuestion(String username, String titoloDomanda);
	List<Risposta> getAnswersByUser(String username);
}