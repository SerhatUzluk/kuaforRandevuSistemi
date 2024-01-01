package com.example.kuaforrandevusistemi.Mapper;

import com.example.kuaforrandevusistemi.Dto.KuaforDto;
import com.example.kuaforrandevusistemi.Entity.Kuafor;
import com.example.kuaforrandevusistemi.Entity.Randevu;
import com.example.kuaforrandevusistemi.Entity.ShiftTablosu;

import java.util.List;

public class KuaforMapper {
    public static KuaforDto mapToKuaforDto(Kuafor kuafor){
        return new KuaforDto(
                kuafor.getId(),
                kuafor.getMailAdres(),
                kuafor.getSifre(),
                kuafor.getAd(),
                kuafor.getSoyad(),
                (List<Randevu>) kuafor.getRandevular(),
                (List<ShiftTablosu>) kuafor.getShiftTablolari()
        );
    }

    public static Kuafor mapToKuafor(KuaforDto kuaforDto){
        return new Kuafor(
                kuaforDto.getId(),
                kuaforDto.getMailAdres(),
                kuaforDto.getSifre(),
                kuaforDto.getAd(),
                kuaforDto.getSoyad(),
                kuaforDto.getRandevular(),
                kuaforDto.getShiftTablolari()
        );
    }
}



