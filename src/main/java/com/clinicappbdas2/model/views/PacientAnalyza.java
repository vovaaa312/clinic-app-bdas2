package com.clinicappbdas2.model.views;

import lombok.Data;

import java.util.Date;

@Data

public class PacientAnalyza {
    private Long idPacient;
    private String jmeno;
    private String prijmeni;
    private Long cisloTelefonu;
    private String pohlavi;
    private Long idKarta;
    private Long idOddeleni;
    private Long idAnalyza;
    private Integer rbc;
    private Integer wbc;
    private Integer hgb;
    private Integer plt;
    private Date datum;


}
