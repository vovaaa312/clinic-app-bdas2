package com.clinicappbdas2.service;

import com.clinicappbdas2.model.views.PacientKarta;
import com.clinicappbdas2.service.repository.OddeleniRepository;
import com.clinicappbdas2.service.repository.PacientKartaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacientKartaService {
    private final PacientKartaRepository repository;

    private final OddeleniRepository oddeleniRepository;

    public List<PacientKarta> getAll() {
        return repository.getAll();
    }

    public void save(PacientKarta pacient) {
        repository.save(pacient);
    }

    public void update(PacientKarta pacientKarta) {
        pacientKarta.setIdOddeleni(oddeleniRepository.getIdByNazev(pacientKarta.getNazevOddeleni()));
        repository.update(pacientKarta);
    }


    public void deleteByKartaId(Integer id) {
        repository.deleteByKartaId(id);
    }

    public List <PacientKarta> getByPacientId(Integer id){
        return repository.getByPacientId(id);
    }

    public PacientKarta getByKartaId(Integer id){
        return repository.getByKartaId(id);
    }

    public List<PacientKarta> getAllByOddeleniId(Long id) {
        return repository.getAllByOddeleniId(id);
    }
}
