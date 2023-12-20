package com.clinicappbdas2.model.views;

import lombok.Data;

import java.util.Date;

@Data
public class NavstevaPacienta {
    private Long idNavsteva;
    private Date datum;
    private Long idPacient;
    private Long idZamestnanec;
    private String problem;
    private String rekomendace;
    private Long idStatus;
    private String pacientJmeno;
    private String pacientPrijmeni;
    private Long pacientCisloTelefonu;
    private String zamestnanecJmeno;
    private String zamestnanecPrijmeni;
    private Long zamestnanecCisloTelefonu;
    private Long idOddeleni;

    private String status;

}
