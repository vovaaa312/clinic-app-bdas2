package com.clinicappbdas2.service;

import com.clinicappbdas2.model.request.RezervaceLuzkaRequest;
import com.clinicappbdas2.model.views.PacientLuzko;
import com.clinicappbdas2.service.repository.PacientLuzkoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacientLuzkoService {
    private final PacientLuzkoRepository luzkoRepository;
    private final JdbcTemplate jdbcTemplate;

    public List<PacientLuzko> getAll() {
        return luzkoRepository.getAll();
    }

    public List<PacientLuzko> getLuzkaByPokojId(Long id) {
        return luzkoRepository.getLuzkaByPokojId(id);
    }

    public PacientLuzko getByLuzkoId(Long id) {
        return luzkoRepository.getByLuzkoId(id);
    }

    public void save(PacientLuzko luzko) {
        luzkoRepository.save(luzko);
    }

    public void releaseLuzko(Long id) {
        luzkoRepository.releaseLuzko(id);
    }

    public void rezervaceLuzka(RezervaceLuzkaRequest request) {
        luzkoRepository.rezervaceLuzka(request.getLuzkoId(), request.getPacientId(), request.getDatumRezervace(), request.getDatumPropusteni());
    }

    public PacientLuzko getByPacentId(Long id) {
        return luzkoRepository.getLuzkoByPacId(id);
    }

    public void update(PacientLuzko luzko) {
        luzkoRepository.update(luzko);
    }

    public void delete(Long id) {
        luzkoRepository.delete(id);
    }

    public int getAvailableBeds(Long oddelId) {
        return luzkoRepository.getAvailableBeds(oddelId);

//        return jdbcTemplate.queryForObject(
//                "SELECT get_volna_luzka_pocet(?) FROM dual",
//                new Object[]{oddelId},
//                Integer.class
//        );
    }
}
