package com.mottuvision.crud.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.mottuvision.crud.model.Zona;
import com.mottuvision.crud.repository.ZonaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/zonas")
@Tag(name = "Zonas", description = "Endpoints para gerenciamento de zonas.")
public class ZonaController {

    @Autowired
    private ZonaRepository zonaRepository;

    @GetMapping
    @Operation(summary = "Lista todas as zonas", description = "Retorna uma lista de todas as zonas cadastradas.")
    public List<Zona> getAllZonas() {
        return zonaRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma zona por ID", description = "Retorna uma única zona com base no ID fornecido.")
    public ResponseEntity<Zona> getZonaById(@PathVariable Long id) {
        return zonaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zona não encontrada com o ID: " + id));
    }

    @PostMapping
    @Operation(summary = "Cria uma nova zona", description = "Cria e salva uma nova zona no banco de dados.")
    public ResponseEntity<Zona> createZona(@Valid @RequestBody Zona zona) {
        Zona savedZona = zonaRepository.save(zona);
        return new ResponseEntity<>(savedZona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma zona existente", description = "Atualiza os dados de uma zona com base no ID e no corpo da requisição.")
    public ResponseEntity<Zona> updateZona(@PathVariable Long id, @Valid @RequestBody Zona zonaDetails) {
        Zona zona = zonaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zona não encontrada com o ID: " + id));
        zona.setNome(zonaDetails.getNome());
        zona.setLetra(zonaDetails.getLetra());
        Zona updatedZona = zonaRepository.save(zona);
        return ResponseEntity.ok(updatedZona);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma zona", description = "Remove uma zona do banco de dados com base no ID fornecido.")
    public ResponseEntity<Void> deleteZona(@PathVariable Long id) {
        if (!zonaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Zona não encontrada com o ID: " + id);
        }
        zonaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
