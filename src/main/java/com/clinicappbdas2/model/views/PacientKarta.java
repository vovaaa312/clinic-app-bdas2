package com.clinicappbdas2.model.views;

import lombok.Data;
import lombok.NoArgsConstructor;

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

}

