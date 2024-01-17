package com.example.kuaforrandevusistemi.Dto;

import com.example.kuaforrandevusistemi.Entity.Randevu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MusteriDto {
    private Long id;
    private String ad;
    private String soyad;
    private String mailAdres;
    private String telefonNo;
    private String sifre;

    @JsonManagedReference
    @OneToMany(mappedBy = "musteri")
    @JsonIgnore
    private List<Randevu> randevular;
}
