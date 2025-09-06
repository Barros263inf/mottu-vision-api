package com.mottuvision.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mottuvision.crud.model.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
}
