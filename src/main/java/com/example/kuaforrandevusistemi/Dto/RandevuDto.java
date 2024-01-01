package com.example.kuaforrandevusistemi.Dto;

import com.example.kuaforrandevusistemi.Entity.Kuafor;
import com.example.kuaforrandevusistemi.Entity.Musteri;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    @ManyToOne
    @JoinColumn(name = "id")
    private Kuafor kuafor;

    @ManyToOne
    @JoinColumn(name = "id")
    private Musteri musteri;

}
