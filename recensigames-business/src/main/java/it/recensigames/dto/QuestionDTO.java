package it.recensigames.dto;

import java.util.Date;

public class QuestionDTO implements DTO{
	private String titolo;
	private String descrizione;
	private Date data;
	private GameSearchDTO gameDTO;
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public GameSearchDTO getGameDTO() {
		return gameDTO;
	}
	public void setGameDTO(GameSearchDTO gameDTO) {
		this.gameDTO = gameDTO;
	}
}