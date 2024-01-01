package com.example.kuaforrandevusistemi.Dto;

import com.example.kuaforrandevusistemi.Entity.Kuafor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShiftTablosuDto {
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


    @OneToOne
    @JoinColumn(name = "kuaforId", referencedColumnName = "id")
    private Kuafor kuafor;

}
