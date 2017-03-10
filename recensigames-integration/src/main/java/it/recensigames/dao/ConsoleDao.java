package it.recensigames.dao;

import java.util.List;
import it.recensigames.model.Console;

public interface ConsoleDao {
	List<Console> getAllConsoles();
	List<Console> getConsolesByProductor(String nomeProduttore);
}