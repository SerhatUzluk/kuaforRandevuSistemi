package com.example.kuaforrandevusistemi.Mapper;

import com.example.kuaforrandevusistemi.Dto.RandevuDto;
import com.example.kuaforrandevusistemi.Entity.Randevu;

public class RandevuMapper {
    public static RandevuDto mapToRandevuDto(Randevu randevu){
        return new RandevuDto(
                randevu.getId(),
                randevu.getIslemTuru(),
                randevu.getTanim(),
                randevu.getRandevuTarihi(),
                randevu.getKuafor(),
                randevu.getMusteri()
        );
    }

    public static Randevu mapToRandevu(RandevuDto randevuDto){
        return new Randevu(
                randevuDto.getId(),
                randevuDto.getIslemTuru(),
                randevuDto.getTanim(),
                randevuDto.getRandevuTarihi(),
                randevuDto.getKuafor(),
                randevuDto.getMusteri()
        );
    }
}
