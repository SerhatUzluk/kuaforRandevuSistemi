package com.example.kuaforrandevusistemi.Service;

import com.example.kuaforrandevusistemi.Dto.KuaforDto;

import java.util.List;

public interface KuaforService {
    KuaforDto kuaforYarat(KuaforDto kuaforDto);

    KuaforDto idIleGetir(Long kuaforId);

    List<KuaforDto> tumKuaforleriGetir();

    KuaforDto kuaforGuncelle(Long kuaforId, KuaforDto guncellenenKuafor);

    void kuaforSil(Long kuaforId);
}

