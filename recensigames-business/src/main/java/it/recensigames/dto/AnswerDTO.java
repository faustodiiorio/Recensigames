package it.recensigames.dto;

import java.util.Date;

public class AnswerDTO implements DTO{
	private String testoRisposta;
	private String titoloDomanda;
	private Date data;
	private GameSearchDTO gameDTO;
	
	public String getTestoRisposta() {
		return testoRisposta;
	}
	public void setTestoRisposta(String testoRisposta) {
		this.testoRisposta = testoRisposta;
	}
	public String getTitoloDomanda() {
		return titoloDomanda;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public void setTitoloDomanda(String titoloDomanda) {
		this.titoloDomanda = titoloDomanda;
	}
	public GameSearchDTO getGameDTO() {
		return gameDTO;
	}
	public void setGameDTO(GameSearchDTO gameDTO) {
		this.gameDTO = gameDTO;
	}
}