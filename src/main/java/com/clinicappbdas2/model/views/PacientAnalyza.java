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
    private String rbc;
    private String wbc;
    private String hgb;
    private String plt;
    private Date datum;


}
