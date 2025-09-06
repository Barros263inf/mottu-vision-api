package com.mottuvision.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mottuvision.crud.model.Identificador;
import com.mottuvision.crud.model.TipoIdentificador;

public interface IdentificadorRepository extends JpaRepository<Identificador, Long> {
    Optional<Identificador> findByTipoAndValor(TipoIdentificador tipo, String valor);

}
