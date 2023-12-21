package com.clinicappbdas2.model.views;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PacientLuzko {
    private Long idLuzko;
    private Long idPokoj;
    private Long idPacient;
    private String jmeno;
    private String prijmeni;
    private Date datumRezervace;
    private Date datumPropusteni;
    private boolean status;
    private int cislo;
    private int patro;

    private String nazevOddeleni;

}
