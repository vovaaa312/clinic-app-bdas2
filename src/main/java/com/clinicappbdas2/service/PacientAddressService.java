package com.clinicappbdas2.service;

import com.clinicappbdas2.model.Pacient;
import com.clinicappbdas2.model.views.PacientAdresa;
import com.clinicappbdas2.service.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientAddressService {

    PacientRepository pacientRepository;

    @Autowired
    public PacientAddressService(PacientRepository pacientAdressRepository) {
        this.pacientRepository = pacientAdressRepository;
    }

    public List<Pacient> findAll(){
        return pacientRepository.getAll();
    }

    public Pacient getById(int id){
        return pacientRepository.getById(id);
    }

    public void save(PacientAdresa pacientAdresa){
        pacientRepository.savePacientProcedure(
                pacientAdresa.getJmeno(),
                pacientAdresa.getPrijmeni(),
                pacientAdresa.getDatumHospitalizace(),
                pacientAdresa.getDatumNarozeni(),
                pacientAdresa.getCisloTelefonu(),
                pacientAdresa.getPohlavi(),
                pacientAdresa.getZeme(),
                pacientAdresa.getMesto(),
                pacientAdresa.getAdresa(),
                pacientAdresa.getPsc()
        );    }
}
