package com.clinicappbdas2.model.mapper;

import com.clinicappbdas2.model.Luzko;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LuzkoMapper implements RowMapper<Luzko> {

    @Override
    public Luzko mapRow(ResultSet rs, int rowNum) throws SQLException {
        Luzko luzko = new Luzko();
        luzko.setIdLuzko(rs.getInt("ID_LUZKO"));
        luzko.setIdPokoj(rs.getInt("ID_POKOJ"));
        luzko.setIdPacient(rs.getInt("ID_PACIENT"));
        luzko.setDatumRezervace(rs.getDate("DATUM_REZERVACE"));
        luzko.setDatumPropusteni(rs.getDate("DATUM_PROPUSTENI"));
        luzko.setStatus(rs.getBoolean("STATUS"));
        luzko.setCislo(rs.getInt("CISLO"));
        return luzko;
    }
}
