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
@Table(name = "status_grupo")
public class StatusGrupo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_grupo_seq_gen")
	@SequenceGenerator(name = "status_grupo_seq_gen", sequenceName = "status_grupo_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	@NotBlank(message = "O nome do grupo de status não pode ser vazio")
	@Size(min = 1, max = 50, message = "O nome do grupo de status deve ter no máximo 50 caracteres")
	private String nome;

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
	
	
}
