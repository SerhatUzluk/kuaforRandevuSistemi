package com.example.kuaforrandevusistemi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String islemTuru;
    private String tanim;
    private LocalDateTime randevuTarihi;

    @ManyToOne
    private Kuafor kuafor;

    @ManyToOne
    private  Musteri musteri;

}
