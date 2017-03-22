package it.recensigames.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Entity
@Table(name="categorie")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="NOME_CATEGORIA")
	private String nomeCategoria;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA")
	private Categoria categoria;

	//bi-directional many-to-one association to Categoria
	@OneToMany(mappedBy="categoria")
	private List<Categoria> listaCategorie;

	//bi-directional many-to-many association to Gioco
	@ManyToMany(mappedBy="listaCategorie")
	private List<Gioco> listaGiochi;

	public Categoria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return this.nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaCategorie() {
		return this.listaCategorie;
	}

	public void setListaCategorie(List<Categoria> listaCategorie) {
		this.listaCategorie = listaCategorie;
	}

	public Categoria addCategory(Categoria categoria) {
		getListaCategorie().add(categoria);
		categoria.setCategoria(this);

		return categoria;
	}

	public Categoria removeCategory(Categoria categoria) {
		getListaCategorie().remove(categoria);
		categoria.setCategoria(null);

		return categoria;
	}

	public List<Gioco> getListaGiochi() {
		return this.listaGiochi;
	}

	public void setListaGiochi(List<Gioco> listaGiochi) {
		this.listaGiochi = listaGiochi;
	}
}