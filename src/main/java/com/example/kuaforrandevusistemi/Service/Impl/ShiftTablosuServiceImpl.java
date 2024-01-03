package com.example.kuaforrandevusistemi.Service.Impl;

import com.example.kuaforrandevusistemi.Entity.Kuafor;
import com.example.kuaforrandevusistemi.Entity.Randevu;
import com.example.kuaforrandevusistemi.Entity.ShiftTablosu;
import com.example.kuaforrandevusistemi.Dto.ShiftTablosuDto;
import com.example.kuaforrandevusistemi.Exception.KaynakBulunamadiException;
import com.example.kuaforrandevusistemi.Mapper.KuaforMapper;
import com.example.kuaforrandevusistemi.Mapper.ShiftTablosuMapper;
import com.example.kuaforrandevusistemi.Repository.ShiftTablosuRepository;
import com.example.kuaforrandevusistemi.Service.ShiftTablosuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ShiftTablosuDto idIleGetir(Long shiftTablosuId) {
        ShiftTablosu shiftTablosu = shiftTablosuRepository.findById(shiftTablosuId).orElseThrow(()->new KaynakBulunamadiException("Bu id'ye sahip bir shift tablosu bulunmuyor. Id: " + shiftTablosuId));
        return ShiftTablosuMapper.mapToShiftTablosuDto(shiftTablosu);
    }

    @Override
    public List<ShiftTablosuDto> tumShiftTablolariniGetir() {
        List<ShiftTablosu> shiftTablolari = shiftTablosuRepository.findAll();
        return shiftTablolari.stream().map((shiftTablosu) -> ShiftTablosuMapper.mapToShiftTablosuDto(shiftTablosu))
                .collect(Collectors.toList());
    }

    @Override
    public ShiftTablosuDto shiftTablosuGuncelle(Long shiftTablosuId, ShiftTablosuDto guncellenenShiftTablosu) {
        ShiftTablosu shiftTablosu = shiftTablosuRepository.findById(shiftTablosuId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id'ye sahip bir shift tablosu bulunmuyor. Id: " + shiftTablosuId));
        shiftTablosu.setPztBaslangic(guncellenenShiftTablosu.getPztBaslangic());
        shiftTablosu.setPztBitis(guncellenenShiftTablosu.getPztBitis());
        shiftTablosu.setSaliBaslangic(guncellenenShiftTablosu.getSaliBaslangic());
        shiftTablosu.setSaliBitis(guncellenenShiftTablosu.getSaliBitis());
        shiftTablosu.setCrsBaslangic(guncellenenShiftTablosu.getCrsBaslangic());
        shiftTablosu.setCrsBitis(guncellenenShiftTablosu.getCrsBitis());
        shiftTablosu.setPrsBaslangic(guncellenenShiftTablosu.getPrsBaslangic());
        shiftTablosu.setPrsBitis(guncellenenShiftTablosu.getPrsBitis());
        shiftTablosu.setCumBaslangic(guncellenenShiftTablosu.getCumBaslangic());
        shiftTablosu.setCumBitis(guncellenenShiftTablosu.getCumBitis());
        shiftTablosu.setCmtBaslangic(guncellenenShiftTablosu.getCmtBaslangic());
        shiftTablosu.setCmtBitis(guncellenenShiftTablosu.getCmtBitis());
        shiftTablosu.setPzrBaslangic(guncellenenShiftTablosu.getPzrBaslangic());
        shiftTablosu.setPzrBitis(guncellenenShiftTablosu.getPzrBitis());
        shiftTablosu.setKuafor(guncellenenShiftTablosu.getKuafor());

        ShiftTablosu veritabanindaGuncellenmmisShiftTablosu = shiftTablosuRepository.save(shiftTablosu);
        return ShiftTablosuMapper.mapToShiftTablosuDto(veritabanindaGuncellenmmisShiftTablosu);
    }

    @Override
    public void shiftTablosuSil(Long shiftTablosuId) {
        ShiftTablosu shiftTablosu = shiftTablosuRepository.findById(shiftTablosuId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id'ye sahip bir shift tablosu bulunmuyor. Id: " + shiftTablosuId));

        shiftTablosuRepository.deleteById(shiftTablosuId);
    }
}

