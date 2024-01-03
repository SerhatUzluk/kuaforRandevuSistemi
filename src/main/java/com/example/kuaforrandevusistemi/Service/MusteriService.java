package com.example.kuaforrandevusistemi.Service;

import com.example.kuaforrandevusistemi.Dto.KuaforDto;
import com.example.kuaforrandevusistemi.Dto.MusteriDto;

import java.util.List;

public interface MusteriService {
    MusteriDto musteriYarat(MusteriDto musteriDto);
    MusteriDto idIleGetir(Long musteriId);

}
