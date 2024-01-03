package com.example.kuaforrandevusistemi.Controller;

import com.example.kuaforrandevusistemi.Dto.RandevuDto;
import com.example.kuaforrandevusistemi.Dto.ShiftTablosuDto;
import com.example.kuaforrandevusistemi.Service.RandevuService;
import com.example.kuaforrandevusistemi.Service.ShiftTablosuService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/shiftTablolari")
public class ShiftTablosuController {
    @Resource
    private ShiftTablosuService shiftTablosuService;

    @PostMapping
    public ResponseEntity<ShiftTablosuDto> shiftTablosuYarat(@RequestBody ShiftTablosuDto shiftTablosuDto){
        ShiftTablosuDto kayitEdilmisShiftTablosu = shiftTablosuService.shiftTablosuYarat(shiftTablosuDto);
        return new ResponseEntity<>(kayitEdilmisShiftTablosu, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<ShiftTablosuDto> idIleGetir(@PathVariable("id") Long shiftTablosuId){
        ShiftTablosuDto shiftTablosuDto = shiftTablosuService.idIleGetir(shiftTablosuId);
        return ResponseEntity.ok(shiftTablosuDto);
    }

    //Tum personelleri getirme islemi
    @GetMapping
    public ResponseEntity<List<ShiftTablosuDto>> tumShiftTablolariniGetir(){
        List<ShiftTablosuDto> shiftTablosuDtoList = shiftTablosuService.tumShiftTablolariniGetir();
        return ResponseEntity.ok(shiftTablosuDtoList);
    }

    //personel guncelleme
    @PutMapping("{id}")
    public ResponseEntity<ShiftTablosuDto> shiftTablosuGuncelle(@PathVariable("id") Long shiftTablosuId,
                                                        @RequestBody ShiftTablosuDto guncelShiftTablosuDto){
        ShiftTablosuDto shiftTablosuDto = shiftTablosuService.shiftTablosuGuncelle(shiftTablosuId,guncelShiftTablosuDto);
        return ResponseEntity.ok(shiftTablosuDto);
    }

    //Personel Silme
    @DeleteMapping("{id}")
    public ResponseEntity<String> shiftTablosuSil(@PathVariable("id") Long shiftTablosuId){
        shiftTablosuService.shiftTablosuSil(shiftTablosuId);
        return ResponseEntity.ok("Shift tablosu basariyla silindi.");
    }
}
