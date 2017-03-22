package it.recensigames.dto;

public class PartialReviewDTO implements DTO{
	private String titoloRecensione;
	private String nomeGioco;
	private String nomeConsole;
	private String img;
	private String tipologia;
	
	public String getTitoloRecensione() {
		return titoloRecensione;
	}
	public void setTitoloRecensione(String titoloRecensione) {
		this.titoloRecensione = titoloRecensione;
	}
	public String getNomeGioco() {
		return nomeGioco;
	}
	public void setNomeGioco(String nomeGioco) {
		this.nomeGioco = nomeGioco;
	}
	public String getNomeConsole() {
		return nomeConsole;
	}
	public void setNomeConsole(String nomeConsole) {
		this.nomeConsole = nomeConsole;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
}