package it.recensigames.dao;

import java.util.List;
import it.recensigames.model.Gioco;

public interface GiocoDao {
	List<Gioco> getAllGames();
	List<Gioco> getGamesByTitle(String titoloGioco);
	List<Gioco> getGamesByConsole(String nomeConsole);
	Gioco getGameByTitleAndConsole(String titoloGioco, String nomeConsole);
}