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

    public void updateAnalyza(PacientAnalyza analyza){
        repository.updateAnalyza(analyza);
    }

    public List<PacientAnalyza> getByPacientId(Long id) {
        return repository.getByPacientId(id);
    }

    public List<PacientAnalyza>getByOddeleniId(Long id){
        return repository.getByOddeleniId(id);
    }

    public PacientAnalyza getByAnalysisId(Long id) {
        return repository.getByAnalysisId(id);

    }

    public void deleteAnalysis(Long id){
       repository.deleteAnalysis(id);
    }
}
