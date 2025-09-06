package com.mottuvision.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mottuvision.crud.model.StatusGrupo;

@Repository
public interface StatusGrupoRepository extends JpaRepository<StatusGrupo, Long> {
}

