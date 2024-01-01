package com.example.kuaforrandevusistemi.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class ShiftTablosu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime pztBaslangic;
    private LocalDateTime pztBitis;
    private LocalDateTime saliBaslangic;
    private LocalDateTime saliBitis;
    private LocalDateTime crsBaslangic;
    private LocalDateTime crsBitis;
    private LocalDateTime prsBaslangic;
    private LocalDateTime prsBitis;
    private LocalDateTime cumBaslangic;
    private LocalDateTime cumBitis;
    private LocalDateTime cmtBaslangic;
    private LocalDateTime cmtBitis;
    private LocalDateTime pzrBaslangic;
    private LocalDateTime pzrBitis;

    @ManyToOne
    @JoinColumn(name = "kuaforId")
    private Kuafor kuafor;


}
