package com.mottuvision.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mottuvision.crud.model.Modelo;
import com.mottuvision.crud.repository.ModeloRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/modelos")
@Tag(name = "Modelos", description = "Endpoints para gerenciamento de modelos de motocicletas.")
public class ModeloController {

    @Autowired
    private ModeloRepository modeloRepository;

    @GetMapping
    @Operation(summary = "Lista todos os modelos", description = "Retorna uma lista de todos os modelos cadastrados.")
    public List<Modelo> getAll() {
        return modeloRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um modelo por ID", description = "Retorna um modelo pelo seu ID.")
    public ResponseEntity<Modelo> getById(@PathVariable Long id) {
        return modeloRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado com o ID: " + id));
    }

    @PostMapping
    @Operation(summary = "Cria um novo modelo", description = "Cria e salva um novo modelo no banco de dados.")
    public ResponseEntity<Modelo> create(@Valid @RequestBody Modelo modelo) {
        try {
            Modelo saved = modeloRepository.save(modelo);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um modelo com esse nome");
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um modelo", description = "Atualiza os dados de um modelo existente.")
    public ResponseEntity<Modelo> update(@PathVariable Long id, @Valid @RequestBody Modelo detalhes) {
        Modelo existente = modeloRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado com o ID: " + id));
        existente.setNome(detalhes.getNome());
        existente.setImagemUrl(detalhes.getImagemUrl());
        try {
            Modelo atualizado = modeloRepository.save(existente);
            return ResponseEntity.ok(atualizado);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um modelo com esse nome");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um modelo", description = "Remove um modelo pelo ID.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!modeloRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado com o ID: " + id);
        }
        modeloRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
