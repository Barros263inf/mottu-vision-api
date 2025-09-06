package com.mottuvision.crud.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.mottuvision.crud.model.Patio;
import com.mottuvision.crud.repository.PatioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/patios")
@Tag(name = "Pátios", description = "Endpoints para gerenciamento de pátios.")
public class PatioController {

    @Autowired
    private PatioRepository patioRepository;

    @GetMapping
    @Operation(summary = "Lista todos os pátios", description = "Retorna uma lista de todos os pátios cadastrados.")
    public List<Patio> getAllPatios() {
        return patioRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um pátio por ID", description = "Retorna um único pátio com base no ID fornecido.")
    public ResponseEntity<Patio> getPatioById(@PathVariable Long id) {
        return patioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pátio não encontrado com o ID: " + id));
    }

    @PostMapping
    @Operation(summary = "Cria um novo pátio", description = "Cria e salva um novo pátio no banco de dados.")
    public ResponseEntity<Patio> createPatio(@Valid @RequestBody Patio patio) {
        Patio savedPatio = patioRepository.save(patio);
        return new ResponseEntity<>(savedPatio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um pátio existente", description = "Atualiza os dados de um pátio com base no ID e no corpo da requisição.")
    public ResponseEntity<Patio> updatePatio(@PathVariable Long id, @Valid @RequestBody Patio patioDetails) {
        Patio patio = patioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pátio não encontrado com o ID: " + id));
        patio.setNome(patioDetails.getNome());
        Patio updatedPatio = patioRepository.save(patio);
        return ResponseEntity.ok(updatedPatio);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um pátio", description = "Remove um pátio do banco de dados com base no ID fornecido.")
    public ResponseEntity<Void> deletePatio(@PathVariable Long id) {
        if (!patioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pátio não encontrado com o ID: " + id);
        }
        patioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

