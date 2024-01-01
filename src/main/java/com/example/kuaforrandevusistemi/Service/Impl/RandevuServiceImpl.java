package com.example.kuaforrandevusistemi.Service.Impl;

import com.example.kuaforrandevusistemi.Dto.RandevuDto;
import com.example.kuaforrandevusistemi.Entity.Randevu;
import com.example.kuaforrandevusistemi.Mapper.RandevuMapper;
import com.example.kuaforrandevusistemi.Repository.RandevuRepository;
import com.example.kuaforrandevusistemi.Service.RandevuService;
import org.springframework.stereotype.Service;

@Service
public class RandevuServiceImpl implements RandevuService {
    private RandevuRepository randevuRepository;

    public RandevuServiceImpl(RandevuRepository randevuRepository){
        this.randevuRepository = randevuRepository;
    }
    @Override
    public RandevuDto randevuYarat(RandevuDto randevuDto) {
        Randevu randevu = RandevuMapper.mapToRandevu(randevuDto);
        Randevu kaydedilmisRandevu = randevuRepository.save(randevu);
        return RandevuMapper.mapToRandevuDto(kaydedilmisRandevu);
    }
}
