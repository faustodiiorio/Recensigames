package it.recensigames.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Entity
@Table(name = "domande")
@NamedQuery(name = "Domanda.findAll", query = "SELECT d FROM Domanda d")
public class Domanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Lob
	private String testo;

	private String titolo;

	// bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name = "ID_UTENTE")
	private Utente utente;

	// bi-directional many-to-one association to Risposte
	@OneToMany(mappedBy = "domanda")
	private List<Risposta> listaRisposte;

	// bi-directional many-to-one association to Gioco
	@ManyToOne
	@JoinColumn(name="ID_GIOCO")
	private Gioco gioco;
	
	@ManyToOne
	@JoinColumn(name="ID_CONSOLE")
	private Console console;
	
	public Domanda() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTesto() {
		return this.testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Risposta> getListaRisposte() {
		return this.listaRisposte;
	}

	public void setListaRisposte(List<Risposta> listaRisposte) {
		this.listaRisposte = listaRisposte;
	}

	public Risposta addRisposta(Risposta risposta) {
		getListaRisposte().add(risposta);
		risposta.setDomanda(this);

		return risposta;
	}

	public Risposta removeRisposta(Risposta risposta) {
		getListaRisposte().remove(risposta);
		risposta.setDomanda(null);

		return risposta;
	}

	public Gioco getGioco() {
		return gioco;
	}

	public void setGioco(Gioco gioco) {
		this.gioco = gioco;
	}

	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}
}