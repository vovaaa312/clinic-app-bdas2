package com.clinicappbdas2.model.views;

import lombok.Data;

import java.util.Date;

@Data

public class PacientAnalyza {
    private Integer idPacient;
    private String jmeno;
    private String prijmeni;
    private Long cisloTelefonu;
    private String pohlavi;
    private Integer idKarta;
    private Integer idAnalyza;
    private Integer rbc;
    private Integer wbc;
    private Integer hgb;
    private Integer plt;
    private Date datum;


}
