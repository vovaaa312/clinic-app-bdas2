package com.clinicappbdas2.service;

import com.clinicappbdas2.model.views.ZamestnanecData;
import com.clinicappbdas2.service.repository.OddeleniRepository;
import com.clinicappbdas2.service.repository.ZamestnanecDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZamestnanecDataService {

    private final ZamestnanecDataRepository zamestnanecDataRepository;

    private final OddeleniRepository oddeleniRepository;



    public List<ZamestnanecData> findAll() {
        return zamestnanecDataRepository.getAllZamestnanci();
    }

    public ZamestnanecData getById(int id) {
        return zamestnanecDataRepository.getZamestnanecById(id);
    }

    public void save(ZamestnanecData zamestnanecData) {
        zamestnanecDataRepository.createZamestnanec(zamestnanecData);
    }

    public void delete(int id){
        zamestnanecDataRepository.deleteZamestnanec(id);
    }

    public void update(ZamestnanecData zamestnanecData){
        zamestnanecData.setIdOddeleni(oddeleniRepository.getIdByNazev(zamestnanecData.getNazevOddeleni()));
        zamestnanecDataRepository.updateZamestnanec(zamestnanecData);
    }
}

