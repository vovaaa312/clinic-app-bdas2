package com.clinicappbdas2.model.mapper;

import com.clinicappbdas2.model.views.PacientKarta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacientKartaMapper implements RowMapper<PacientKarta> {
    @Override
    public PacientKarta mapRow(ResultSet rs, int rowNum) throws SQLException {
        PacientKarta pacient = new PacientKarta();
        pacient.setIdPacient(rs.getInt("ID_PACIENT"));
        pacient.setJmeno(rs.getString("JMENO"));
        pacient.setPrijmeni(rs.getString("PRIJMENI"));
        pacient.setDatumNarozeni(rs.getDate("DATUM_NAROZENI"));
        pacient.setDatumHospitalizace(rs.getDate("DATUM_HOSPITALIZACE"));
        pacient.setCisloTelefonu(rs.getLong("CISLO_TELEFONU"));
        pacient.setPohlavi(rs.getString("POHLAVI"));
        pacient.setIdKarta(rs.getInt("ID_KARTA"));
        pacient.setIdOddeleni(rs.getInt("ID_ODDELENI"));
        pacient.setNazevOddeleni(rs.getString("NAZEV_ODDELENI"));

        return pacient;
    }
}
