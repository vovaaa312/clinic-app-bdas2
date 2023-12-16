package com.clinicappbdas2.service;

import com.clinicappbdas2.model.request.RezervaceLuzkaRequest;
import com.clinicappbdas2.model.views.PacientLuzko;
import com.clinicappbdas2.service.repository.PacientLuzkoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacientLuzkoService {
    private final PacientLuzkoRepository luzkoRepository;

    public List<PacientLuzko> getAll() {
        return luzkoRepository.getAll();
    }

    public List<PacientLuzko> getLuzkaByPokojId(Integer id) {
        return luzkoRepository.getLuzkaByPokojId(id);
    }

    public PacientLuzko getByLuzkoId(Integer id) {
        return luzkoRepository.getByLuzkoId(id);
    }

    public void save(PacientLuzko luzko) {
        luzkoRepository.save(luzko);
    }

    public void releaseLuzko(Integer id) {
        luzkoRepository.releaseLuzko(id);
    }

    public void rezervaceLuzka(RezervaceLuzkaRequest request) {
        luzkoRepository.rezervaceLuzka(request.getLuzkoId(),request.getPacientId(), request.getDatumRezervace(), request.getDatumPropusteni());
    }

    public void update(PacientLuzko luzko) {
        luzkoRepository.update(luzko);
    }

    public void delete(Integer id){
        luzkoRepository.delete(id);
    }
}
