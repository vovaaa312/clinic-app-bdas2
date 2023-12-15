package com.clinicappbdas2.service;

import com.clinicappbdas2.model.views.PokojeOddeleni;
import com.clinicappbdas2.service.repository.PokojeOddeleniRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PokojeOddeleniService {

    private final PokojeOddeleniRepository pokojeOddeleniRepository;

    public List<PokojeOddeleni> getAll() {
        return pokojeOddeleniRepository.getAll();
    }

    public void createPokoj(PokojeOddeleni pokoj) {
        pokojeOddeleniRepository.addPokoj(pokoj);
    }

    public void deletePokoj(Integer id) {
        pokojeOddeleniRepository.deletePokoj(id);
    }

    public void updatePokoj(PokojeOddeleni pokoj) {
        pokojeOddeleniRepository.updatePokoj(pokoj);
    }

    public PokojeOddeleni getByPokojId(Integer id) {
        return pokojeOddeleniRepository.getByPokojId(id);
    }
}
