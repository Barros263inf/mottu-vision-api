package com.mottuvision.crud.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "moto")
public class Moto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moto_seq_gen")
	@SequenceGenerator(name = "moto_seq_gen", sequenceName = "moto_seq", allocationSize = 1)
	private Long id;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "identificador_id", nullable = false)
	@NotNull(message = "O identificador é obrigatório")
	private Identificador identificador;
    
	@Column(name = "data_entrada", nullable = false)
	@NotNull(message = "A data de entrada não pode ser nula")
	private LocalDateTime dataEntrada;
    
	@Column(name = "previsao_entrega")
	private LocalDateTime previsaoEntrega;
    
	@ElementCollection
    @CollectionTable(name = "moto_foto", joinColumns = @JoinColumn(name = "moto_id"))
    @Column(name = "url", nullable = false)
    private List<String> fotos = new ArrayList<>();
    
	@ManyToOne
	@JoinColumn(name = "modelo_id", nullable = false)
	@NotNull(message = "O modelo não pode ser nulo")
	private Modelo modelo;
    
	@ManyToOne
	@JoinColumn(name = "zona_id", nullable = false)
	@NotNull(message = "A zona não pode ser nulo")
	private Zona zona;
    
	@ManyToOne
	@JoinColumn(name = "patio_id", nullable = false)
	@NotNull(message = "O pátio não pode ser nulo")
	private Patio patio;
    
	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	@NotNull(message = "O status não pode ser nulo")
	private Status status;
    
	@ElementCollection
    @CollectionTable(name = "moto_observacao", joinColumns = @JoinColumn(name = "moto_id"))
    @Column(name = "texto", columnDefinition = "CLOB", nullable = false)
    private List<String> observacoes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getPrevisaoEntrega() {
		return previsaoEntrega;
	}

	public void setPrevisaoEntrega(LocalDateTime previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Patio getPatio() {
		return patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<String> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<String> observacoes) {
        this.observacoes = observacoes;
    }
    
	public Identificador getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Identificador identificador) {
		this.identificador = identificador;
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
}
