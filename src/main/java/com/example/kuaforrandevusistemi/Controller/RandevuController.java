package com.example.kuaforrandevusistemi.Controller;

import com.example.kuaforrandevusistemi.Dto.RandevuDto;
import com.example.kuaforrandevusistemi.Service.RandevuService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/randevular")
public class RandevuController {
    @Resource
    private RandevuService randevuService;

    @PostMapping
    public ResponseEntity<RandevuDto> randevuYarat(@RequestBody RandevuDto randevuDto){
        RandevuDto kayitEdilmisRandevu= randevuService.randevuYarat(randevuDto);
        return new ResponseEntity<>(kayitEdilmisRandevu, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<RandevuDto> idIleGetir(@PathVariable("id") Long randevuId){
        RandevuDto randevuDto = randevuService.idIleGetir(randevuId);
        return ResponseEntity.ok(randevuDto);
    }

    //Tum personelleri getirme islemi
    @GetMapping
    public ResponseEntity<List<RandevuDto>> tumRandevulariGetir(){
        List<RandevuDto> randevuDtoList = randevuService.tumRandevulariGetir();
        return ResponseEntity.ok(randevuDtoList);
    }

    //personel guncelleme
    @PutMapping("{id}")
    public ResponseEntity<RandevuDto> randevuGuncelle(@PathVariable("id") Long randevuId,
                                                        @RequestBody RandevuDto guncelRandevuDto){
        RandevuDto randevuDto = randevuService.randevuGuncelle(randevuId,guncelRandevuDto);
        return ResponseEntity.ok(randevuDto);
    }

    //Personel Silme
    @DeleteMapping("{id}")
    public ResponseEntity<String> randevuSil(@PathVariable("id") Long randevuId){
        randevuService.randevuSil(randevuId);
        return ResponseEntity.ok("Randevu basariyla silindi.");
    }
}