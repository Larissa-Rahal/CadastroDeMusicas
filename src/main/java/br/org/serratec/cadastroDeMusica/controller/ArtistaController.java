package br.org.serratec.cadastroDeMusica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.cadastroDeMusica.dto.ArtistaDTO;
import br.org.serratec.cadastroDeMusica.service.ArtistaService;
import jakarta.validation.Valid;

@Controller
@RestController
@RequestMapping("/artistas")
public class ArtistaController {

        @Autowired
        private ArtistaService servico;

        @GetMapping
        public ResponseEntity<List<ArtistaDTO>> listarArtista(){
            return ResponseEntity.ok(servico.listarTodos());

        }

        @GetMapping("/{id}")
        public ResponseEntity<ArtistaDTO> buscarArtista(@PathVariable Long id) {
            Optional<ArtistaDTO> musica = servico.listarPorId(id);
            if (musica.isPresent()) {
                return ResponseEntity.ok(musica.get());
            }
            return ResponseEntity.notFound().build();
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public ArtistaDTO inserirArtista(@Valid @RequestBody ArtistaDTO artista) {
            return servico.salvarArtista(artista);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ArtistaDTO> atualizar(@PathVariable Long id, @RequestBody ArtistaDTO artistaAlterada) {
            Optional<ArtistaDTO> artista = servico.atualizarArtista(id, artistaAlterada);

            if (artista.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(artista.get());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> removerArtista(@PathVariable Long id) {
            if(!servico.excluirArtista(id)){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        }

    }

