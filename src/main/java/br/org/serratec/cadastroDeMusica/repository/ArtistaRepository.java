package br.org.serratec.cadastroDeMusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.cadastroDeMusica.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}
	