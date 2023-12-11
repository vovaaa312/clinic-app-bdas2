package com.clinicappbdas2.service;

import com.clinicappbdas2.model.views.PacientAnalyza;
import com.clinicappbdas2.service.repository.PacientAnalyzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacientAnalyzaService {
    private final PacientAnalyzaRepository repository;

    public List<PacientAnalyza> getAll() {
        return repository.getAllAnalysis();
    }

    public void save(PacientAnalyza pacient) {
        repository.save(pacient);
    }


    public List<PacientAnalyza> getByPacientId(Integer id) {
        return repository.getByPacientId(id);
    }

    public PacientAnalyza getByAnalysisId(Integer id) {
        return repository.getByAnalysisId(id);

    }

    public void deleteAnalysis(Integer id){
       repository.deleteAnalysis(id);
    }
}
