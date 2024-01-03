package com.example.kuaforrandevusistemi.Service;

import com.example.kuaforrandevusistemi.Dto.KuaforDto;
import com.example.kuaforrandevusistemi.Dto.RandevuDto;
import com.example.kuaforrandevusistemi.Dto.ShiftTablosuDto;

import java.util.List;

public interface ShiftTablosuService {
    ShiftTablosuDto shiftTablosuYarat(ShiftTablosuDto shiftTablosuDto);

    ShiftTablosuDto idIleGetir(Long shiftTablosuId);

    List<ShiftTablosuDto> tumShiftTablolariniGetir();

    ShiftTablosuDto shiftTablosuGuncelle(Long shiftTablosuId, ShiftTablosuDto guncellenenShiftTablosu);

    void shiftTablosuSil(Long shiftTablosuId);
}
