package com.example.kuaforrandevusistemi.Mapper;


import com.example.kuaforrandevusistemi.Dto.MusteriDto;
import com.example.kuaforrandevusistemi.Entity.Musteri;

public class MusteriMapper {
    public static MusteriDto mapToMusteriDto(Musteri musteri){
        return new MusteriDto(
                musteri.getId(),
                musteri.getAd(),
                musteri.getSoyad(),
                musteri.getMailAdres(),
                musteri.getTelefonNo(),
                musteri.getRandevular()
        );
    }

    public static Musteri mapToMusteri(MusteriDto musteriDto){
        return new Musteri(
                musteriDto.getId(),
                musteriDto.getAd(),
                musteriDto.getSoyad(),
                musteriDto.getMailAdres(),
                musteriDto.getTelefonNo(),
                musteriDto.getRandevular()
        );
    }
}
