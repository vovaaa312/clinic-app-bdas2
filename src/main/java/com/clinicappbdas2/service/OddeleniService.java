package com.clinicappbdas2.service;

import com.clinicappbdas2.model.Oddeleni;
import com.clinicappbdas2.service.repository.OddeleniRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OddeleniService {

    private final OddeleniRepository oddeleniRepository;

    public List<Oddeleni> findAll(){
        return oddeleniRepository.getAll();
    }

    public Long getAvailableBeds(Long id){
        return oddeleniRepository.getAvailableBeds(id);
    }

}
