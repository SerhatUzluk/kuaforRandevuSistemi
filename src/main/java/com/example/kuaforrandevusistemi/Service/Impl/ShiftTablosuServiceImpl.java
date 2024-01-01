package com.example.kuaforrandevusistemi.Service.Impl;

import com.example.kuaforrandevusistemi.Entity.ShiftTablosu;
import com.example.kuaforrandevusistemi.Dto.ShiftTablosuDto;
import com.example.kuaforrandevusistemi.Mapper.ShiftTablosuMapper;
import com.example.kuaforrandevusistemi.Repository.ShiftTablosuRepository;
import com.example.kuaforrandevusistemi.Service.ShiftTablosuService;
import org.springframework.stereotype.Service;

@Service
public class ShiftTablosuServiceImpl implements ShiftTablosuService {
    private ShiftTablosuRepository shiftTablosuRepository;

    public ShiftTablosuServiceImpl(ShiftTablosuRepository shiftTablosuRepository){
        this.shiftTablosuRepository = shiftTablosuRepository;
    }

    @Override
    public ShiftTablosuDto shiftTablosuYarat(ShiftTablosuDto shiftTablosuDto) {
        ShiftTablosu shiftTablosu = ShiftTablosuMapper.mapToShiftTablosu(shiftTablosuDto);
        ShiftTablosu kaydedilmisShiftTablosu = shiftTablosuRepository.save(shiftTablosu);
        return ShiftTablosuMapper.mapToShiftTablosuDto(kaydedilmisShiftTablosu);
    }
}

