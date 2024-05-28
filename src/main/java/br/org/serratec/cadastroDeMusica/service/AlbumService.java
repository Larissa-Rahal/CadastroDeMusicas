package br.org.serratec.cadastroDeMusica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.cadastroDeMusica.dto.AlbumDTO;
import br.org.serratec.cadastroDeMusica.model.Album;
import br.org.serratec.cadastroDeMusica.repository.AlbumRepository;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository repositorio;
    
    public List<AlbumDTO> listarTodos() {
        return repositorio.findAll().stream()
                .map(c -> new AlbumDTO(c.getId(), c.getNome_album(), c.getData_lancamento(), c.getArtista()))
                .toList();
        
    }
    
    public Optional<AlbumDTO> listarPorId(Long id) {
        Optional<Album> album = repositorio.findById(id);
        if (album.isPresent()) {
            return Optional.of(album.get().toDTO());
        } 
        return Optional.empty();
    }
    
    public AlbumDTO salvarAlbum(AlbumDTO albumDTO) {
        Album albumEntity = repositorio.save(albumDTO.toEntity());
        return albumEntity.toDTO();
    }
    
    public Optional<AlbumDTO> atualizarAlbum(Long id, AlbumDTO albumDTO) {
        Album entAlbum = albumDTO.toEntity();
        if (repositorio.existsById(id)) {
            entAlbum.setId(id);
            repositorio.save(entAlbum);
            return Optional.of(entAlbum.toDTO());
        } 
        return Optional.empty();
    }
    
    public boolean excluirAlbum(Long id) {
        if (!repositorio.existsById(id)) {
            return false;
        }
        
        repositorio.deleteById(id);
        return true;
    }
}
