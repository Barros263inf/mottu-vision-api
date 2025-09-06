package com.mottuvision.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mottuvision.crud.model.Patio;

@Repository
public interface PatioRepository extends JpaRepository<Patio, Long> {
}