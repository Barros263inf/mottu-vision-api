package com.mottuvision.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
    name = "identificador",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_identificador_tipo_valor", columnNames = {"tipo", "valor"})
    }
)
public class Identificador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identificador_seq_gen")
    @SequenceGenerator(name = "identificador_seq_gen", sequenceName = "identificador_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 20)
    @NotNull(message = "O tipo do identificador é obrigatório")
    private TipoIdentificador tipo;

    @Column(name = "valor", nullable = false, length = 100)
    @NotBlank(message = "O valor do identificador é obrigatório")
    @Size(min = 3, max = 100, message = "O valor do identificador deve ter entre {min} e {max} caracteres")
    private String valor;

    // ➡️ Add this method to resolve the error

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoIdentificador getTipo() {
		return tipo;
	}

	public void setTipo(TipoIdentificador tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
    
}