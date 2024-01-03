package com.example.kuaforrandevusistemi.Service.Impl;

import com.example.kuaforrandevusistemi.Dto.MusteriDto;
import com.example.kuaforrandevusistemi.Entity.Kuafor;
import com.example.kuaforrandevusistemi.Entity.Musteri;
import com.example.kuaforrandevusistemi.Exception.KaynakBulunamadiException;
import com.example.kuaforrandevusistemi.Mapper.KuaforMapper;
import com.example.kuaforrandevusistemi.Mapper.MusteriMapper;
import com.example.kuaforrandevusistemi.Repository.MusteriRepository;
import com.example.kuaforrandevusistemi.Service.MusteriService;
import org.springframework.stereotype.Service;

@Service
public class MusteriServiceImpl implements MusteriService {
    public MusteriRepository musteriRepository;

    public MusteriServiceImpl(MusteriRepository musteriRepository){
        this.musteriRepository = musteriRepository;
    }

    @Override
    public MusteriDto musteriYarat(MusteriDto musteriDto) {
        Musteri musteri = MusteriMapper.mapToMusteri(musteriDto);
        Musteri kaydedilmisMusteri = musteriRepository.save(musteri);
        return MusteriMapper.mapToMusteriDto(kaydedilmisMusteri);
    }

    @Override
    public MusteriDto idIleGetir(Long musteriId) {
        Musteri musteri = musteriRepository.findById(musteriId).orElseThrow(()->new KaynakBulunamadiException("Bu id'ye sahip bir musteri bulunmuyor. Id: " + musteriId));
        return MusteriMapper.mapToMusteriDto(musteri);
    }
}
