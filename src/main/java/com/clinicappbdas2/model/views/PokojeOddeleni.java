package com.clinicappbdas2.model.views;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PokojeOddeleni {
    private Long idPokoj;
    private Integer patro;
    private Integer cislo;
    private Long idOddeleni;
    private String  nazevOddeleni;
    private Integer pocetLuzek;

}
