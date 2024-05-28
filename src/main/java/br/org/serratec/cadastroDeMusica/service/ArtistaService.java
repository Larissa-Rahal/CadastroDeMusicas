package br.org.serratec.cadastroDeMusica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.cadastroDeMusica.dto.ArtistaDTO;
import br.org.serratec.cadastroDeMusica.model.Artista;
import br.org.serratec.cadastroDeMusica.repository.ArtistaRepository;

@Service
public class ArtistaService {
    
    @Autowired
    private ArtistaRepository repositorio;
    
    public List<ArtistaDTO> listarTodos() {
        return repositorio.findAll().stream()
                .map(Artista::toDTO)
                .toList();
    }
    
    public Optional<ArtistaDTO> listarPorId(Long id) {
        Optional<Artista> artista = repositorio.findById(id);
        return artista.map(Artista::toDTO);
    }
    
    public ArtistaDTO salvarArtista(ArtistaDTO artistaDTO) {
        Artista artistaEntity = artistaDTO.toEntity();
        Artista artistaSalvo = repositorio.save(artistaEntity);
        return artistaSalvo.toDTO();
    }
    
    public Optional<ArtistaDTO> atualizarArtista(Long id, ArtistaDTO artistaDTO) {
        if (repositorio.existsById(id)) {
            Artista entArtista = artistaDTO.toEntity();
            entArtista.setId(id);
            Artista artistaAtualizado = repositorio.save(entArtista);
            return Optional.of(artistaAtualizado.toDTO());
        } else {
            return Optional.empty();
        }
    }
    
    public boolean excluirArtista(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
