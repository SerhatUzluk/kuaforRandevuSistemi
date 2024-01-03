package com.example.kuaforrandevusistemi.Service;

import com.example.kuaforrandevusistemi.Dto.KuaforDto;
import com.example.kuaforrandevusistemi.Dto.RandevuDto;

import java.util.List;

public interface RandevuService {
    RandevuDto randevuYarat(RandevuDto randevuDto);
    RandevuDto idIleGetir(Long randevuId);

    List<RandevuDto> tumRandevulariGetir();

    RandevuDto randevuGuncelle(Long randevuId, RandevuDto guncellenenRandevu);

    void randevuSil(Long randevuId);
}
