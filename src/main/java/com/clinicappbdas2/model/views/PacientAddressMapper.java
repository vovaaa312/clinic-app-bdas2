package com.clinicappbdas2.model.views;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacientAddressMapper implements RowMapper<PacientAdresa> {

    @Override
    public PacientAdresa mapRow(ResultSet rs, int rowNum) throws SQLException {
        PacientAdresa pacient = new PacientAdresa();
        pacient.setIdPacient(rs.getInt("ID_PACIENT"));
        pacient.setJmeno(rs.getString("JMENO"));
        pacient.setPrijmeni(rs.getString("PRIJMENI"));
        pacient.setDatumNarozeni(rs.getDate("DATUM_NAROZENI"));
        pacient.setDatumHospitalizace(rs.getDate("DATUM_HOSPITALIZACE"));
        pacient.setCisloTelefonu(rs.getInt("CISLO_TELEFONU"));
        pacient.setPohlavi(rs.getString("POHLAVI"));
        pacient.setIdAdresa(rs.getInt("ID_ADRESA"));
        pacient.setZeme(rs.getString("ZEME"));
        pacient.setMesto(rs.getString("MESTO"));
        pacient.setAdresa(rs.getString("ADRESA"));
        pacient.setPsc(rs.getInt("PSC"));
        return pacient;
    }
}
