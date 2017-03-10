package it.recensigames.model;

import java.io.Serializable;
import javax.persistence.*;

import it.recensigames.model.Domanda;
import it.recensigames.model.Risposta;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the utenti database table.
 * 
 */
@Entity
@Table(name = "utenti")
@NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String bannato;

	private String cognome;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_NASCITA")
	private Date dataNascita;

	private String email;

	private String nome;

	private String password;

	private String tipologia;

	private String username;

	// bi-directional many-to-one association to Recensione
	@OneToMany(mappedBy = "utente")
	private List<Recensione> listaRecensioni;

	// bi-directional many-to-one association to Domanda
	@OneToMany(mappedBy = "utente")
	private List<Domanda> listaDomande;

	// bi-directional many-to-one association to Risposte
	@OneToMany(mappedBy = "utente")
	private List<Risposta> listaRisposte;

	public Utente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBannato() {
		return this.bannato;
	}

	public void setBannato(String bannato) {
		this.bannato = bannato;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Recensione> getListaRecensioni() {
		return this.listaRecensioni;
	}

	public void setListaRecensioni(List<Recensione> listaRecensioni) {
		this.listaRecensioni = listaRecensioni;
	}

	public Recensione addRecensione(Recensione recensione) {
		getListaRecensioni().add(recensione);
		recensione.setUtenti(this);

		return recensione;
	}

	public Recensione removeRecensione(Recensione recensione) {
		getListaRecensioni().remove(recensione);
		recensione.setUtenti(null);

		return recensione;
	}

	public List<Domanda> getListaDomande() {
		return listaDomande;
	}

	public void setListaDomande(List<Domanda> listaDomande) {
		this.listaDomande = listaDomande;
	}

	public List<Risposta> getListaRisposte() {
		return listaRisposte;
	}

	public void setListaRisposte(List<Risposta> listaRisposte) {
		this.listaRisposte = listaRisposte;
	}
}