package com.example.kuaforrandevusistemi.Dto;

import com.example.kuaforrandevusistemi.Entity.Kuafor;
import com.example.kuaforrandevusistemi.Entity.Musteri;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RandevuDto {
    private Long id;
    private String islemTuru;
    private String tanim;
    private LocalDateTime randevuTarihi;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kuaforId", referencedColumnName = "id")
    private Kuafor kuafor;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "musteriId", referencedColumnName = "id")
    private Musteri musteri;

}
