package com.clinicappbdas2.model.views;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Data
public class PacientAdresa {
    private Integer idPacient;
    private Integer idAdresa;
    private String jmeno;
    private String prijmeni;
    private Date datumHospitalizace;
    private Date datumNarozeni;
    private Long cisloTelefonu;
    private String pohlavi;


    private String zeme;
    private String mesto;
    private String adresa;
    private Integer psc;


}
