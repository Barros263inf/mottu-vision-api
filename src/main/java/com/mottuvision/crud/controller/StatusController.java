package com.mottuvision.crud.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.mottuvision.crud.model.Status;
import com.mottuvision.crud.repository.StatusRepository;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@Tag(name = "Status", description = "Endpoints para gerenciamento de status.")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping
    @Operation(summary = "Lista todos os status", description = "Retorna uma lista de todos os status cadastrados.")
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um status por ID", description = "Retorna um único status com base no ID fornecido.")
    public ResponseEntity<Status> getStatusById(@PathVariable Long id) {
        return statusRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status não encontrado com o ID: " + id));
    }

    @PostMapping
    @Operation(summary = "Cria um novo status", description = "Cria e salva um novo status no banco de dados.")
    public ResponseEntity<Status> createStatus(@Valid @RequestBody Status status) {
        Status savedStatus = statusRepository.save(status);
        return new ResponseEntity<>(savedStatus, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um status existente", description = "Atualiza os dados de um status com base no ID e no corpo da requisição.")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @Valid @RequestBody Status statusDetails) {
        Status status = statusRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status não encontrado com o ID: " + id));
        status.setNome(statusDetails.getNome());
        status.setStatusGrupo(statusDetails.getStatusGrupo());
        Status updatedStatus = statusRepository.save(status);
        return ResponseEntity.ok(updatedStatus);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um status", description = "Remove um status do banco de dados com base no ID fornecido.")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        if (!statusRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Status não encontrado com o ID: " + id);
        }
        statusRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}