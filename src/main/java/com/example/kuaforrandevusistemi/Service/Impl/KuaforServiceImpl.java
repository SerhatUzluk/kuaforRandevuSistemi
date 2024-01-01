package com.example.kuaforrandevusistemi.Service.Impl;

import com.example.kuaforrandevusistemi.Dto.KuaforDto;
import com.example.kuaforrandevusistemi.Entity.Kuafor;
import com.example.kuaforrandevusistemi.Mapper.KuaforMapper;
import com.example.kuaforrandevusistemi.Repository.KuaforRepository;
import com.example.kuaforrandevusistemi.Service.KuaforService;
import org.springframework.stereotype.Service;

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
}
