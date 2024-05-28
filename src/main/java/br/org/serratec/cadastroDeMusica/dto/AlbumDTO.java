package br.org.serratec.cadastroDeMusica.dto;

import java.time.LocalDate;

import br.org.serratec.cadastroDeMusica.model.Album;
import br.org.serratec.cadastroDeMusica.model.Artista;

public record AlbumDTO(
    Long id,
    String nome_album,
    LocalDate data_lancamento,
    Artista artista
) {
    
    public Album toEntity() {
        return new Album(this.id, this.nome_album, this.data_lancamento, this.artista);
    }
    
    public static AlbumDTO toDTO(Long id, String nome_album, LocalDate data_lancamento, Artista artista) {
        return new AlbumDTO(id, nome_album, data_lancamento, artista);
    }

}

