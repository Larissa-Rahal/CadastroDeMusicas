package br.org.serratec.cadastroDeMusica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.cadastroDeMusica.dto.MusicasDto;
import br.org.serratec.cadastroDeMusica.model.Genero;
import br.org.serratec.cadastroDeMusica.model.Musica;
import br.org.serratec.cadastroDeMusica.repository.MusicaRepository;

@Service
public class MusicaService {
	@Autowired
	private MusicaRepository repositorio;
	
	public List<MusicasDto> listarTodos() {
		return repositorio.findAll().stream()
				.map(c -> new MusicasDto(c.getId(), c.getTitulo(), c.getArtista(), c.getGenero(), c.getAnoLancamento()))
				.toList();
		
	}
	
	public Optional<MusicasDto> listarPorId(Long id) {
		Optional<Musica> musica = repositorio.findById(id);
		if (musica.isPresent()) {
			return Optional.of(musica.get().toDto());
		} 
		return Optional.empty();
	}
	
	public MusicasDto salvarMusica(MusicasDto musica) {
        Musica musicaEntity = repositorio.save(musica.toEntity());
        return musicaEntity.toDto();
    }
	
	public Optional<MusicasDto> atualizarMusica(Long id, MusicasDto musica) {
		Musica entMusica = musica.toEntity();
		if (repositorio.existsById(id)) {
			entMusica.setId(id);
			repositorio.save(entMusica);
			return Optional.of(entMusica.toDto());
		} 
		return Optional.empty();
	}
	
	public boolean excluirMusica(Long id) {
        if(!repositorio.existsById(id)){
            return false;
        }

        repositorio.deleteById(id);
        return true;
    }

	public List<MusicasDto> obterPorArtista(String artista) {
		return repositorio.findByArtistaLike(artista).stream()
				.map(c -> new MusicasDto(c.getId(), c.getTitulo(), c.getArtista(), c.getGenero(), c.getAnoLancamento()))
				.toList();
		
	}
	
	public List<MusicasDto> obterArtistasMenos(String nome) {
        return repositorio.findByArtistaNotLike(nome).stream()
                .map(c -> new MusicasDto(c.getId(), c.getTitulo(), c.getArtista(), c.getGenero(), c.getAnoLancamento()))
                .toList();

    }
	
	public List<MusicasDto> findByGenero(String nome) {
        Genero genero = Genero.valueOf(nome.toUpperCase());
        return repositorio.findByGenero(genero).stream()
            .map(c -> new MusicasDto(c.getId(), c.getTitulo(), c.getArtista(), c.getGenero(), c.getAnoLancamento()))
            .toList();
    }
	
	public List<MusicasDto> obterMusicaEntre(int data, int data2) {
        String dataLancamento1 = String.valueOf(data);
        String dataLancamento2 = String.valueOf(data2);
        return repositorio.findByAnoLancamentoBetween(dataLancamento1, dataLancamento2).stream()
                .map(c -> new MusicasDto(c.getId(), c.getTitulo(), c.getArtista(), c.getGenero(), c.getAnoLancamento()))
                .toList();
        
    }
	
	public List<MusicasDto> findByTituloContainingIgnoreCase(String titulo) {
        return repositorio.findByTituloContainingIgnoreCase(titulo).stream()
            .map(m -> new MusicasDto(m.getId(), m.getTitulo(), m.getArtista(), m.getGenero(), m.getAnoLancamento()))
            .toList();
    }
		
	}

