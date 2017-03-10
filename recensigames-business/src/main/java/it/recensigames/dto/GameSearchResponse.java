package it.recensigames.dto;

public class GameSearchResponse {
	private String titolo;
	private String console;
	
	public GameSearchResponse() {
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}
}