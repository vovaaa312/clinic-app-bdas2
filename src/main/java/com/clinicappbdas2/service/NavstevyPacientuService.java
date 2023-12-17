package com.clinicappbdas2.service;

import com.clinicappbdas2.model.views.NavstevaPacienta;
import com.clinicappbdas2.service.repository.NavstevyPacientuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NavstevyPacientuService {
    private final NavstevyPacientuRepository navstevyRepository;

    public List<NavstevaPacienta> getAll() {
        return navstevyRepository.getAll();
    }

    public NavstevaPacienta getByNavstevaId(Long id){
        return navstevyRepository.getByNavstevaId(id);
    }

    public void createNavsteva(NavstevaPacienta navsteva) {
        navstevyRepository.createNavsteva(navsteva);
    }

    public void updateNavsteva(NavstevaPacienta navsteva) {
        navstevyRepository.updateNavsteva(navsteva);
    }

    public List<NavstevaPacienta> getAllByPacientId(Long id) {
        return navstevyRepository.getAllByPacientId(id);
    }

    public List<NavstevaPacienta> getAllByZamestnanecId(Long id) {
        return navstevyRepository.getAllByZamestnanecId(id);
    }
}
