package com.clinicappbdas2.service;

import com.clinicappbdas2.model.views.PokojeOddeleni;
import com.clinicappbdas2.service.repository.PokojeOddeleniRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PokojeOddeleniService {

    private final PokojeOddeleniRepository pokojeRepository;

    public List<PokojeOddeleni> getAll() {
        return pokojeRepository.getAll();
    }

    public List<PokojeOddeleni> getByOddeleniId(Long id) {
        return pokojeRepository.getByOddeleniId(id);
    }


    public void createPokoj(PokojeOddeleni pokoj) {
        pokojeRepository.addPokoj(pokoj);
    }

    public void deletePokoj(Long id) {
        pokojeRepository.deletePokoj(id);
    }

    public void updatePokoj(PokojeOddeleni pokoj) {
        pokojeRepository.updatePokoj(pokoj);
    }

    public PokojeOddeleni getByPokojId(Long id) {
        return pokojeRepository.getByPokojId(id);
    }
}
