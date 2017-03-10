package it.recensigames.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produttori_consoles database table.
 * 
 */
@Entity
@Table(name="produttori_consoles")
@NamedQuery(name="ProduttoreConsoles.findAll", query="SELECT p FROM ProduttoreConsoles p")
public class ProduttoreConsoles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="NOME_PRODUTTORE_CONSOLES")
	private String nomeProduttoreConsoles;

	//bi-directional many-to-one association to Console
	@OneToMany(mappedBy="produttoreConsoles")
	private List<Console> listaConsoles;

	public ProduttoreConsoles() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeProduttoreConsoles() {
		return this.nomeProduttoreConsoles;
	}

	public void setNomeProduttoreConsoles(String nomeProduttoreConsoles) {
		this.nomeProduttoreConsoles = nomeProduttoreConsoles;
	}

	public List<Console> getListaConsoles() {
		return this.listaConsoles;
	}

	public void setListaConsoles(List<Console> listaConsoles) {
		this.listaConsoles = listaConsoles;
	}

	public Console addConsole(Console console) {
		getListaConsoles().add(console);
		console.setProduttoreConsoles(this);

		return console;
	}

	public Console removeConsole(Console console) {
		getListaConsoles().remove(console);
		console.setProduttoreConsoles(null);

		return console;
	}

}