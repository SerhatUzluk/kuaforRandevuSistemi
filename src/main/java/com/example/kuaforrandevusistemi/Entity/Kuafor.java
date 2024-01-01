package com.example.kuaforrandevusistemi.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Kuafor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String mailAdres;
    @Column(nullable = false)
    private String sifre;
    @Column(nullable = false, unique = true)
    private String ad;
    @Column(nullable = false, unique = true)
    private String soyad;

    @OneToMany(mappedBy = "kuafor")
    private List<Randevu> randevular;

    @OneToMany(mappedBy = "kuafor")
    private List<ShiftTablosu> ShiftTablolari;
}

