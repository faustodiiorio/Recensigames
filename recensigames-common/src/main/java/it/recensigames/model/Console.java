package it.recensigames.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the consoles database table.
 * 
 */
@Entity
@Table(name="consoles")
@NamedQuery(name="Console.findAll", query="SELECT c FROM Console c")
public class Console implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="NOME_CONSOLE")
	private String nomeConsole;

	//bi-directional many-to-one association to ProduttoreConsoles
	@ManyToOne
	@JoinColumn(name="ID_PRODUTTORE_CONSOLE")
	private ProduttoreConsoles produttoreConsoles;

	//bi-directional many-to-many association to Gioco
//	@ManyToMany(mappedBy="listaConsoles")
	@ManyToMany
	@JoinTable(
		name="giochi_consoles"
		, joinColumns={
			@JoinColumn(name="ID_CONSOLE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_GIOCO")
			}
		)
	private List<Gioco> listaGiochi;

	public Console() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeConsole() {
		return this.nomeConsole;
	}

	public void setNomeConsole(String nomeConsole) {
		this.nomeConsole = nomeConsole;
	}

	public ProduttoreConsoles getProduttoreConsoles() {
		return this.produttoreConsoles;
	}

	public void setProduttoreConsoles(ProduttoreConsoles produttoreConsoles) {
		this.produttoreConsoles = produttoreConsoles;
	}

	public List<Gioco> getListaGiochi() {
		return this.listaGiochi;
	}

	public void setListaGiochi(List<Gioco> listaGiochi) {
		this.listaGiochi = listaGiochi;
	}
}