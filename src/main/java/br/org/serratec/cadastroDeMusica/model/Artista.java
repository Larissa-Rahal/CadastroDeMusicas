package br.org.serratec.cadastroDeMusica.model;

import java.time.LocalDate;

import br.org.serratec.cadastroDeMusica.dto.ArtistaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int idade;
	private LocalDate data_nascimento;
	private Album album;
	
	public Artista() {}
	
	public Artista(Long id, String nome, int idade, LocalDate data_nascimento, Album album) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.data_nascimento = data_nascimento;
		this.album = album;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public LocalDate getData_nascimento() {
		return data_nascimento;
	}
	
	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	public Album getAlbum() {
		return album;
	}
	
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	 public ArtistaDTO toDTO() {
	        return new ArtistaDTO(id, nome, idade, data_nascimento, album);
	    }

	

}
