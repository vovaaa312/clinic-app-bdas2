package com.clinicappbdas2.service;

import com.clinicappbdas2.model.views.PacientKarta;
import com.clinicappbdas2.service.repository.PacientKartaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacientKartaService {
    private final PacientKartaRepository repository;

    public List<PacientKarta> getAll() {
        return repository.getAll();
    }

    public void create(PacientKarta pacient) {
        repository.create(pacient);
    }

    public void update(PacientKarta pacientKarta) {
        repository.update(pacientKarta);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
