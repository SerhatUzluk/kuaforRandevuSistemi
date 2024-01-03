package com.example.kuaforrandevusistemi.Service.Impl;

import com.example.kuaforrandevusistemi.Dto.KuaforDto;
import com.example.kuaforrandevusistemi.Entity.Kuafor;
import com.example.kuaforrandevusistemi.Exception.KaynakBulunamadiException;
import com.example.kuaforrandevusistemi.Mapper.KuaforMapper;
import com.example.kuaforrandevusistemi.Repository.KuaforRepository;
import com.example.kuaforrandevusistemi.Service.KuaforService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KuaforServiceImpl implements KuaforService {
    private KuaforRepository kuaforRepository;

    public KuaforServiceImpl(KuaforRepository kuaforRepository) {
        this.kuaforRepository = kuaforRepository;
    }
    @Override
    public KuaforDto kuaforYarat(KuaforDto kuaforDto) {
        Kuafor kuafor = KuaforMapper.mapToKuafor(kuaforDto);
        Kuafor kaydedilmisKuafor = kuaforRepository.save(kuafor);
        return KuaforMapper.mapToKuaforDto(kaydedilmisKuafor);
    }

    @Override
    public KuaforDto idIleGetir(Long kuaforId) {
        Kuafor kuafor = kuaforRepository.findById(kuaforId).orElseThrow(()->new KaynakBulunamadiException("Bu id'ye sahip bir kuafor bulunmuyor. Id: " + kuaforId));
        return KuaforMapper.mapToKuaforDto(kuafor);
    }

    @Override
    public List<KuaforDto> tumKuaforleriGetir() {
        List<Kuafor> kuaforler = kuaforRepository.findAll();
        return kuaforler.stream().map((kuafor) -> KuaforMapper.mapToKuaforDto(kuafor))
                .collect(Collectors.toList());
    }

    @Override
    public KuaforDto kuaforGuncelle(Long kuaforId, KuaforDto guncellenenKuafor) {
         Kuafor kuafor = kuaforRepository.findById(kuaforId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id'ye sahip bir kuafor bulunmuyor. Id: " + kuaforId));
        kuafor.setAd(guncellenenKuafor.getAd());
        kuafor.setSoyad(guncellenenKuafor.getSoyad());
        kuafor.setMailAdres(guncellenenKuafor.getMailAdres());

        Kuafor veritabanindaGuncellenmmisKuafor = kuaforRepository.save(kuafor);
        return KuaforMapper.mapToKuaforDto(veritabanindaGuncellenmmisKuafor);
    }

    @Override
    public void kuaforSil(Long kuaforId) {
        Kuafor kuafor = kuaforRepository.findById(kuaforId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id'ye sahip bir kuafor bulunmuyor. Id: " + kuaforId));

        kuaforRepository.deleteById(kuaforId);

    }
}
