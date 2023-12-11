package com.clinicappbdas2.model.views;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Data

public class PacientAnalyza {
    private Integer idPacient;
    private String jmeno;
    private String prijmeni;
    private String pohlavi;
    private Long cisloTelefonu;
    private Integer idKarta;
    private Integer idAnalyza;
    private Integer RBC;
    private Integer WBC;
    private Integer HGB;
    private Integer PLT;
    private Date datum;


}
