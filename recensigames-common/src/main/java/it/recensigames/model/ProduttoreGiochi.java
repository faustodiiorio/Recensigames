package it.recensigames.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produttori_giochi database table.
 * 
 */
@Entity
@Table(name="produttori_giochi")
@NamedQuery(name="ProduttoreGiochi.findAll", query="SELECT p FROM ProduttoreGiochi p")
public class ProduttoreGiochi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="NOME_PRODUTTORE_GIOCHI")
	private String nomeProduttoreGiochi;

	//bi-directional many-to-one association to Gioco
	@OneToMany(mappedBy="produttoreGiochi")
	private List<Gioco> listaGiochi;

	public ProduttoreGiochi() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeProduttoreGiochi() {
		return this.nomeProduttoreGiochi;
	}

	public void setNomeProduttoreGiochi(String nomeProduttoreGiochi) {
		this.nomeProduttoreGiochi = nomeProduttoreGiochi;
	}

	public List<Gioco> getListaGiochi() {
		return this.listaGiochi;
	}

	public void setListGiochi(List<Gioco> listaGiochi) {
		this.listaGiochi = listaGiochi;
	}

	public Gioco addGioco(Gioco gioco) {
		getListaGiochi().add(gioco);
		gioco.setProduttoreGiochi(this);

		return gioco;
	}

	public Gioco removeGioco(Gioco gioco) {
		getListaGiochi().remove(gioco);
		gioco.setProduttoreGiochi(null);

		return gioco;
	}

}