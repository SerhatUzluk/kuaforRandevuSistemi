package com.example.kuaforrandevusistemi.Mapper;

import com.example.kuaforrandevusistemi.Dto.ShiftTablosuDto;
import com.example.kuaforrandevusistemi.Entity.ShiftTablosu;

public class ShiftTablosuMapper {
    public static ShiftTablosuDto mapToShiftTablosuDto(ShiftTablosu shiftTablosu){
        return new ShiftTablosuDto(
                shiftTablosu.getId(),
                shiftTablosu.getPztBaslangic(),
                shiftTablosu.getPztBitis(),
                shiftTablosu.getSaliBaslangic(),
                shiftTablosu.getSaliBitis(),
                shiftTablosu.getCrsBaslangic(),
                shiftTablosu.getCrsBitis(),
                shiftTablosu.getPrsBaslangic(),
                shiftTablosu.getPrsBitis(),
                shiftTablosu.getCumBaslangic(),
                shiftTablosu.getCumBitis(),
                shiftTablosu.getCmtBaslangic(),
                shiftTablosu.getCmtBitis(),
                shiftTablosu.getPzrBaslangic(),
                shiftTablosu.getPzrBitis(),
                shiftTablosu.getKuafor()
        );
    }

    public static ShiftTablosu mapToShiftTablosu(ShiftTablosuDto shiftTablosuDto){
        return new ShiftTablosu(
                shiftTablosuDto.getId(),
                shiftTablosuDto.getPztBaslangic(),
                shiftTablosuDto.getPztBitis(),
                shiftTablosuDto.getSaliBaslangic(),
                shiftTablosuDto.getSaliBitis(),
                shiftTablosuDto.getCrsBaslangic(),
                shiftTablosuDto.getCrsBitis(),
                shiftTablosuDto.getPrsBaslangic(),
                shiftTablosuDto.getPrsBitis(),
                shiftTablosuDto.getCumBaslangic(),
                shiftTablosuDto.getCumBitis(),
                shiftTablosuDto.getCmtBaslangic(),
                shiftTablosuDto.getCmtBitis(),
                shiftTablosuDto.getPzrBaslangic(),
                shiftTablosuDto.getPzrBitis(),
                shiftTablosuDto.getKuafor()
        );
    }
}
