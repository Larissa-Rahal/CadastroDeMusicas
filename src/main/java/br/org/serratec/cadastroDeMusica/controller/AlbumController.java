package br.org.serratec.cadastroDeMusica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.cadastroDeMusica.dto.AlbumDTO;
import br.org.serratec.cadastroDeMusica.service.AlbumService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService servico;

    @GetMapping
    public ResponseEntity<List<AlbumDTO>> listarAlbums(){
        return ResponseEntity.ok(servico.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDTO> buscarAlbumPorId(@PathVariable Long id) {
        Optional<AlbumDTO> album = servico.listarPorId(id);
        if (album.isPresent()) {
            return ResponseEntity.ok(album.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumDTO inserirAlbum(@Valid @RequestBody AlbumDTO albumDTO) {
        return servico.salvarAlbum(albumDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumDTO> atualizarAlbum(@PathVariable Long id, @RequestBody AlbumDTO albumAlterado) {
        Optional<AlbumDTO> album = servico.atualizarAlbum(id, albumAlterado);

        if (album.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(album.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAlbum(@PathVariable Long id) {
        if(!servico.excluirAlbum(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

