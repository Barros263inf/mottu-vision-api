package com.mottuvision.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_seq_gen")
	@SequenceGenerator(name = "status_seq_gen", sequenceName = "status_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	@NotBlank(message = "O nome do status não pode ser vazio")
	@Size(min = 1, max = 50, message = "O nome do status deve ter no máximo 50 caracteres")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "status_grupo_id", nullable = false)
	private StatusGrupo statusGrupo;

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

	public StatusGrupo getStatusGrupo() {
		return statusGrupo;
	}

	public void setStatusGrupo(StatusGrupo statusGrupo) {
		this.statusGrupo = statusGrupo;
	}
	
	
}
