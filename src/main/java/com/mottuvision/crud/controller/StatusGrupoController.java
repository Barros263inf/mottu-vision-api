package com.mottuvision.crud.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.mottuvision.crud.model.StatusGrupo;
import com.mottuvision.crud.repository.StatusGrupoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/status-grupos")
@Tag(name = "Grupos de Status", description = "Endpoints para gerenciamento de grupos de status.")
public class StatusGrupoController {

    @Autowired
    private StatusGrupoRepository statusGrupoRepository;

    @GetMapping
    @Operation(summary = "Lista todos os grupos de status", description = "Retorna uma lista de todos os grupos de status cadastrados.")
    public List<StatusGrupo> getAllStatusGrupos() {
        return statusGrupoRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um grupo de status por ID", description = "Retorna um único grupo de status com base no ID fornecido.")
    public ResponseEntity<StatusGrupo> getStatusGrupoById(@PathVariable Long id) {
        return statusGrupoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo de Status não encontrado com o ID: " + id));
    }

    @PostMapping
    @Operation(summary = "Cria um novo grupo de status", description = "Cria e salva um novo grupo de status no banco de dados.")
    public ResponseEntity<StatusGrupo> createStatusGrupo(@Valid @RequestBody StatusGrupo statusGrupo) {
        StatusGrupo savedStatusGrupo = statusGrupoRepository.save(statusGrupo);
        return new ResponseEntity<>(savedStatusGrupo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um grupo de status existente", description = "Atualiza os dados de um grupo de status com base no ID e no corpo da requisição.")
    public ResponseEntity<StatusGrupo> updateStatusGrupo(@PathVariable Long id, @Valid @RequestBody StatusGrupo statusGrupoDetails) {
        StatusGrupo statusGrupo = statusGrupoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo de Status não encontrado com o ID: " + id));
        statusGrupo.setNome(statusGrupoDetails.getNome());
        StatusGrupo updatedStatusGrupo = statusGrupoRepository.save(statusGrupo);
        return ResponseEntity.ok(updatedStatusGrupo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um grupo de status", description = "Remove um grupo de status do banco de dados com base no ID fornecido.")
    public ResponseEntity<Void> deleteStatusGrupo(@PathVariable Long id) {
        if (!statusGrupoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo de Status não encontrado com o ID: " + id);
        }
        statusGrupoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}