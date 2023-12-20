package com.clinicappbdas2.service;

import com.clinicappbdas2.model.Zamestnanec;
import com.clinicappbdas2.service.repository.ZamestnanecRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZamestnanecService {

    private final ZamestnanecRepository zamestnanecRepository;

    public List<Zamestnanec> getAll() {
        return zamestnanecRepository.getAll();
    }

    public Zamestnanec getById(Long id) {
        return zamestnanecRepository.getById(id);
    }

    public void save(Zamestnanec zamestnanec) {
        zamestnanecRepository.save(zamestnanec);
    }

    public void update(Zamestnanec zamestnanec) {
        zamestnanecRepository.update(zamestnanec);
    }
    public void delete(Long id){
        zamestnanecRepository.deleteById(id);
    }

}
