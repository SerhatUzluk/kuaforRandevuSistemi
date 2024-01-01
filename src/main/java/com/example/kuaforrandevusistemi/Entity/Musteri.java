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
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String ad;
    @Column(nullable = false, unique = true)
    private String soyad;
    @Column(nullable = false, unique = true)
    private String mailAdres;
    @Column(nullable = false, unique = true)
    private String telefonNo;

    @OneToMany(mappedBy = "musteri")
    private List<Randevu> randevular;
}
