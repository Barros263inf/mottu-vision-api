package com.mottuvision.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mottuvision.crud.model.Moto;
import com.mottuvision.crud.repository.MotoRepository;

@Service
@Transactional
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> findAll() {
        return motoRepository.findAll();
    }

    public Optional<Moto> findById(Long id) {
        return motoRepository.findById(id);
    }

    public Moto save(Moto moto) {
        // O lado dono do relacionamento 1-1 é Moto (JoinColumn em Moto),
        // portanto não é necessário setar back-reference no Identificador.
        return motoRepository.save(moto);
    }

    public void deleteById(Long id) {
        motoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return motoRepository.existsById(id);
    }
}