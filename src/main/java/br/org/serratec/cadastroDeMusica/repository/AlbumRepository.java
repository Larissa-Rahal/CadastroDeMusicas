package br.org.serratec.cadastroDeMusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.cadastroDeMusica.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
