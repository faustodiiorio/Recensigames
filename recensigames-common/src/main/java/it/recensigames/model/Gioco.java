package it.recensigames.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the giochi database table.
 * 
 */
@Entity
@Table(name="giochi")
@NamedQuery(name="Gioco.findAll", query="SELECT g FROM Gioco g")
public class Gioco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String copertina;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_PUBBLICAZIONE")
	private Date dataPubblicazione;

	@Column(name="TITOLO_GIOCO")
	private String titoloGioco;

	private String trailer;

	private String trama;

	private float voto;

	//bi-directional many-to-one association to ProduttoreGiochi
	@ManyToOne
	@JoinColumn(name="ID_PRODUTTORE_GIOCHI")
	private ProduttoreGiochi produttoreGiochi;

	//bi-directional many-to-one association to Recensione
	@OneToMany(mappedBy="gioco")
	private List<Recensione> listaRecensioni;

	//bi-directional many-to-many association to Categoria
//	@ManyToMany
//	@JoinColumn(name="ID")
	@ManyToMany
	@JoinTable(
		name="giochi_categorie"
		, joinColumns={
			@JoinColumn(name="ID_GIOCO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_CATEGORIA")
			}
		)
	private List<Categoria> listaCategorie;

	//bi-directional many-to-many association to Console
	@ManyToMany(mappedBy="listaGiochi")
//	@JoinColumn(name="ID")
	private List<Console> listaConsoles;

	public Gioco() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCopertina() {
		return this.copertina;
	}

	public void setCopertina(String copertina) {
		this.copertina = copertina;
	}

	public Date getDataPubblicazione() {
		return this.dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public String getTitoloGioco() {
		return this.titoloGioco;
	}

	public void setTitoloGioco(String titoloGioco) {
		this.titoloGioco = titoloGioco;
	}

	public String getTrailer() {
		return this.trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getTrama() {
		return this.trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	public float getVoto() {
		return this.voto;
	}

	public void setVoto(float voto) {
		this.voto = voto;
	}

	public ProduttoreGiochi getProduttoreGiochi() {
		return this.produttoreGiochi;
	}

	public void setProduttoreGiochi(ProduttoreGiochi produttoreGiochi) {
		this.produttoreGiochi = produttoreGiochi;
	}

	public List<Recensione> getListaRecensioni() {
		return this.listaRecensioni;
	}

	public void setListaRecensioni(List<Recensione> listaRecensioni) {
		this.listaRecensioni = listaRecensioni;
	}

	public Recensione addRecensione(Recensione recensione) {
		getListaRecensioni().add(recensione);
		recensione.setGioco(this);

		return recensione;
	}

	public Recensione removeRecensioni(Recensione recensione) {
		getListaRecensioni().remove(recensione);
		recensione.setGioco(null);

		return recensione;
	}

	public List<Categoria> getListaCategorie() {
		return this.listaCategorie;
	}

	public void setListaCategorie(List<Categoria> listaCategorie) {
		this.listaCategorie = listaCategorie;
	}

	public List<Console> getListaConsoles() {
		return this.listaConsoles;
	}

	public void setListaConsoles(List<Console> listaConsoles) {
		this.listaConsoles = listaConsoles;
	}
}