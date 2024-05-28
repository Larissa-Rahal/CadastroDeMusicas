package br.org.serratec.cadastroDeMusica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.cadastroDeMusica.model.Genero;
import br.org.serratec.cadastroDeMusica.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long>{
	
	
	
	List<Musica>findByArtistaLike(String artista);
	
	List<Musica> findByArtistaNotLike(String nome);
	
	List<Musica> findByGenero(Genero genero);
	
	List<Musica> findByAnoLancamentoBetween(String anoLancamento, String anoLancamento2);
	
	List<Musica> findByTituloContainingIgnoreCase(String titulo);
	
	
	

}
