package com.clinicappbdas2.model.views;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Data
@NoArgsConstructor
public class PacientKarta {
    private Integer idPacient;
    private String jmeno;
    private String prijmeni;
    private Date datumHospitalizace;
    private Date datumNarozeni;
    private Long cisloTelefonu;
    private String pohlavi;
    private Integer idKarta;
    private Integer idOddeleni;
    private String nazevOddeleni;

    public static PacientKarta mapRow(ResultSet rs, int rowNum) throws SQLException {
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

