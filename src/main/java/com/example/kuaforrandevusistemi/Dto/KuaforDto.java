package com.example.kuaforrandevusistemi.Dto;

import com.example.kuaforrandevusistemi.Entity.Randevu;
import com.example.kuaforrandevusistemi.Entity.ShiftTablosu;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KuaforDto {

    private long id;
    private String mailAdres;
    private String sifre;
    private String ad;
    private String soyad;
    @OneToMany(mappedBy = "randevular")
    private List<Randevu> randevular;

    @OneToMany(mappedBy = "kuafor")
    private List<ShiftTablosu> ShiftTablolari;
}