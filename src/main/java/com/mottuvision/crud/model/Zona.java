package com.mottuvision.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zona")
public class Zona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zona_seq_gen")
	@SequenceGenerator(name = "zona_seq_gen", sequenceName = "zona_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	@NotBlank(message = "O nome da zona não pode ser vazio")
	@Size(min = 1, max = 50, message = "O nome da zona deve ter no máximo 50 caracteres")
	private String nome;
	
	@Column(name = "letra", nullable = false)
	@NotBlank(message = "O nome da zona não pode ser vazio")
	@Size(min = 1, max = 2, message = "A letra da zona deve ter exatamente 1 caractere")
	private String letra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}
	
}	
