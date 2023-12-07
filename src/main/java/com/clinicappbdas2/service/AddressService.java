package com.clinicappbdas2.service;

import com.clinicappbdas2.model.Adresa;
import com.clinicappbdas2.service.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public List<Adresa> findAll(){
        return addressRepository.findAll();
    }

    public  Adresa getById(int id){
        return addressRepository.getById(id);
    }

}
