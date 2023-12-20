package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.Zamestnanec;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class ZamestnanecRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(Zamestnanec zamestnanec) {
        String sql = "INSERT INTO ST64550.ZAMESTNANCI " +
                "( ID_ADRESA, JMENO, PRIJMENI,  DATUM_NAROZENI, CISLO_TELEFONU, PRACOVNI_ZKUSENOSTI,ID_ODDELENI) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zamestnanec.getJmeno(), zamestnanec.getPrijmeni(),
                zamestnanec.getDatumNarozeni(),       zamestnanec.getCisloTelefonu(), zamestnanec.getPracovniZkusenosti(),zamestnanec.getIdOddeleni());
    }

    public void update(Zamestnanec zamestnanec) {
        jdbcTemplate.update("UPDATE ZAMESTNANCI SET ID_ADRESA=?, JMENO=?, PRIJMENI=?, DATUM_NAROZENI=?, PRACOVNI_ZKUSENOSTI=?, ID_ODDELENI=? WHERE ID_ZAMESTNANEC=?",
                zamestnanec.getIdAdresa(), zamestnanec.getJmeno(), zamestnanec.getPrijmeni(),  zamestnanec.getDatumNarozeni(), zamestnanec.getCisloTelefonu(), zamestnanec.getPracovniZkusenosti(),zamestnanec.getIdOddeleni(), zamestnanec.getIdZamestnanec());
    }

    public List<Zamestnanec> getAll() {
        return jdbcTemplate.query("SELECT * from ZAMESTNANCI",
                BeanPropertyRowMapper.newInstance(Zamestnanec.class));
    }
    public Zamestnanec getById(Long id) {
        String sql = "SELECT * FROM ZAMESTNANCI WHERE ID_ZAMESTNANEC = ?";

        // Используем BeanPropertyRowMapper для маппинга результата на объект Pacient
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Zamestnanec.class));
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM ZAMESTNANCI WHERE ID_ZAMESTNANEC=?";
        jdbcTemplate.update(sql, id);
    }


}
