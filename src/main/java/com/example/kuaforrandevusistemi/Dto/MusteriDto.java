package com.example.kuaforrandevusistemi.Dto;

import com.example.kuaforrandevusistemi.Entity.Randevu;
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


    @OneToMany(mappedBy = "musteri")
    private List<Randevu> randevular;
}
