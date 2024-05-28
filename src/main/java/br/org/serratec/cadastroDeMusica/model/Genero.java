package br.org.serratec.cadastroDeMusica.model;


import jakarta.validation.constraints.NotBlank;

@NotBlank(message= "não pode ser valor em branco")
public enum Genero {
	ROCK,
	PAGODE,
	SAMBA,
	FUNK,
	MPB,
	SERTANEJO,
	FORRO,
	K_POP,
	RAP,
	REGGAE,
	TRAP,
	HIP_HOP,
	POP;
	

	
}
