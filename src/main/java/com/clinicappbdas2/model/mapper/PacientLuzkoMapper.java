package com.clinicappbdas2.model.mapper;

import com.clinicappbdas2.model.views.PacientLuzko;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacientLuzkoMapper implements RowMapper<PacientLuzko> {
    @Override
    public PacientLuzko mapRow(ResultSet rs, int rowNum) throws SQLException {
        PacientLuzko luzko = new PacientLuzko();
        luzko.setIdLuzko(rs.getLong("ID_LUZKO"));
        luzko.setIdPokoj(rs.getLong("ID_POKOJ"));
        luzko.setIdPacient(rs.getLong("ID_PACIENT"));
        luzko.setJmeno(rs.getString("JMENO"));
        luzko.setPrijmeni(rs.getString("PRIJMENI"));
        luzko.setDatumRezervace(rs.getDate("DATUM_REZERVACE"));
        luzko.setDatumPropusteni(rs.getDate("DATUM_PROPUSTENI"));
        luzko.setStatus(rs.getBoolean("STATUS"));
        luzko.setCislo(rs.getInt("CISLO"));
        luzko.setPatro(rs.getInt("PATRO"));
        luzko.setNazevOddeleni(rs.getString("NAZEV_ODDELENI"));

        return luzko;
    }
}
