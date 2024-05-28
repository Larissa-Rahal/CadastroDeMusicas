package br.org.serratec.cadastroDeMusica.dto;

import java.time.LocalDate;

import br.org.serratec.cadastroDeMusica.model.Album;
import br.org.serratec.cadastroDeMusica.model.Artista;

public record ArtistaDTO(	
	Long id,
	String nome,
	int idade,
	LocalDate data_nascimento,
	Album album
	) {
	
	public Artista toEntity() {
        return new Artista (this.id, this.nome, this.idade, this.data_nascimento, this.album);
    }
	
    public static ArtistaDTO toDTO(Long id, String nome, int idade, LocalDate data_nascimento, Album album) {
        return new ArtistaDTO(id, nome, idade, data_nascimento, album);
    }

}
