package com.clinicappbdas2.model.views;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PokojeOddeleni {
    private Integer idPokoj;
    private Integer patro;
    private Integer cislo;
    private Integer idOddeleni;
    private String  nazevOddeleni;
    private Integer pocetLuzek;

}
