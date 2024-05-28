package br.org.serratec.cadastroDeMusica.model;

import java.time.LocalDate;

import br.org.serratec.cadastroDeMusica.dto.AlbumDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String nome_album;
	private LocalDate data_lancamento;	
	private Artista artista;
	
	public Album() {}
	
	public Album(Long id, String nome_album, LocalDate data_lancamento, Artista artista) {
		super();
		this.id = id;
		this.nome_album = nome_album;
		this.data_lancamento = data_lancamento;
		this.artista = artista;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_album() {
		return nome_album;
	}
	public void setNome_album(String nome_album) {
		this.nome_album = nome_album;
	}
	public LocalDate getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(LocalDate data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	 public AlbumDTO toDTO() {
	        return new AlbumDTO(id, nome_album, data_lancamento, artista);
	    }
	
}
