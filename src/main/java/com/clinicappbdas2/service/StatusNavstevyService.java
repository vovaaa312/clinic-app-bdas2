package com.clinicappbdas2.service;

import com.clinicappbdas2.model.StatusNavstevy;
import com.clinicappbdas2.service.repository.StatusNavstevyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusNavstevyService {

    private final StatusNavstevyRepository navstevyRepository;

    public List<StatusNavstevy> getAll() {
        return navstevyRepository.getAll();
    }

    public StatusNavstevy getById(Long id) {
        return navstevyRepository.getById(id);
    }

}
