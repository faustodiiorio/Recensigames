package it.recensigames.dao;

import java.util.List;
import it.recensigames.model.Utente;

public interface UtenteDao {
	List<Utente> getAllUsers();
	Utente getUserByUsernameAndPassword(String username, String password);
}