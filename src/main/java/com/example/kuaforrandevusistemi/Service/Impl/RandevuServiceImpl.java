package com.example.kuaforrandevusistemi.Service.Impl;

import com.example.kuaforrandevusistemi.Dto.RandevuDto;
import com.example.kuaforrandevusistemi.Entity.Kuafor;
import com.example.kuaforrandevusistemi.Entity.Randevu;
import com.example.kuaforrandevusistemi.Exception.KaynakBulunamadiException;
import com.example.kuaforrandevusistemi.Mapper.KuaforMapper;
import com.example.kuaforrandevusistemi.Mapper.RandevuMapper;
import com.example.kuaforrandevusistemi.Repository.RandevuRepository;
import com.example.kuaforrandevusistemi.Service.RandevuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public RandevuDto idIleGetir(Long randevuId) {
        Randevu randevu = randevuRepository.findById(randevuId).orElseThrow(()->new KaynakBulunamadiException("Bu id'ye sahip bir randevu bulunmuyor. Id: " + randevuId));
        return RandevuMapper.mapToRandevuDto(randevu);
    }

    @Override
    public List<RandevuDto> tumRandevulariGetir() {
        List<Randevu> randevular = randevuRepository.findAll();
        return randevular.stream().map((randevu) -> RandevuMapper.mapToRandevuDto(randevu))
                .collect(Collectors.toList());
    }

    @Override
    public RandevuDto randevuGuncelle(Long randevuId, RandevuDto guncellenenRandevu) {
        Randevu randevu = randevuRepository.findById(randevuId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id'ye sahip bir randevu bulunmuyor. Id: " + randevuId));
        randevu.setIslemTuru(guncellenenRandevu.getIslemTuru());
        randevu.setTanim(guncellenenRandevu.getTanim());
        randevu.setRandevuTarihi(guncellenenRandevu.getRandevuTarihi());
        randevu.setKuafor(guncellenenRandevu.getKuafor());
        randevu.setMusteri(guncellenenRandevu.getMusteri());
        Randevu veritabanindaGuncellenmmisRandevu = randevuRepository.save(randevu);
        return RandevuMapper.mapToRandevuDto(veritabanindaGuncellenmmisRandevu);
    }

    @Override
    public void randevuSil(Long randevuId) {
        Randevu randevu = randevuRepository.findById(randevuId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id'ye sahip bir randevu bulunmuyor. Id: " + randevuId));

        randevuRepository.deleteById(randevuId);

    }
}
