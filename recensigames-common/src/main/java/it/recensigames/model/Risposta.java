package it.recensigames.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the risposte database table.
 * 
 */
@Entity
@Table(name="risposte")
@NamedQuery(name="Risposta.findAll", query="SELECT r FROM Risposta r")
public class Risposta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Lob
	private String testo;

	//bi-directional many-to-one association to Domanda
	@ManyToOne
	@JoinColumn(name="ID_DOMANDA")
	private Domanda domanda;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="ID_UTENTE")
	private Utente utente;

	public Risposta() {
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

	public Domanda getDomanda() {
		return this.domanda;
	}

	public void setDomanda(Domanda domanda) {
		this.domanda = domanda;
	}

	public Utente getUtenti() {
		return this.utente;
	}

	public void setUtenti(Utente utente) {
		this.utente = utente;
	}

}