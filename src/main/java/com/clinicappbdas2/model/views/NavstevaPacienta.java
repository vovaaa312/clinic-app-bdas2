package com.clinicappbdas2.model.views;

import lombok.Data;

import java.util.Date;

@Data
public class NavstevaPacienta {
    private Integer idNavsteva;
    private Date datum;
    private Integer idPacient;
    private Integer idZamestnanec;
    private String problem;
    private String rekomendace;
    private Integer idStatus;
    private String pacientJmeno;
    private String pacientPrijmeni;
    private Integer cisloTelefonu;
    private String zamestnanecJmeno;
    private String zamestnanecPrijmeni;
    private String status;
}
