package br.org.serratec.cadastroDeMusica.dto;

import br.org.serratec.cadastroDeMusica.model.Genero;
import br.org.serratec.cadastroDeMusica.model.Musica;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record MusicasDto(
		 Long id,
		 @NotBlank(message = "O título deverá ser preenchido!")
		 String titulo,
		 @NotBlank(message = "O artista deverá ser informado!")
		 String artista,
		 Genero genero,
		 @Pattern(regexp ="[0-9]{4}", message = "Ano de lançamento deve ter 4 digitos!")
		 @NotBlank(message = "Informe o ano de lançamento!")
		 String anoLancamento) {
	
	public Musica toEntity() {
		return new Musica (this.id, this.titulo, this.artista,this.genero ,  this.anoLancamento);
				
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
	

}
