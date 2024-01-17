package com.example.kuaforrandevusistemi.Controller;

import com.example.kuaforrandevusistemi.Dto.KuaforDto;
import com.example.kuaforrandevusistemi.Dto.MusteriDto;
import com.example.kuaforrandevusistemi.Service.KuaforService;
import com.example.kuaforrandevusistemi.Service.MusteriService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/musteriler", consumes ="application/json")
public class MusteriController {
    @Autowired
    private MusteriService musteriService;

    @PostMapping("/kayit")
    public ResponseEntity<MusteriDto> musteriYarat(@RequestBody MusteriDto musteriDto){
        MusteriDto kayitEdilmisMusteri = musteriService.musteriYarat(musteriDto);
        return new ResponseEntity<>(kayitEdilmisMusteri, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<MusteriDto> idIleGetir(@PathVariable("id") Long musterId){
        MusteriDto musteriDto= musteriService.idIleGetir(musterId);
        return ResponseEntity.ok(musteriDto);
    }
    @PostMapping("/giris")
    public ResponseEntity<?> musteriGiris(@RequestBody MusteriDto musteriDto) {
        String email = musteriDto.getMailAdres();
        String sifre = musteriDto.getSifre();

        if (musteriService.musteriVarmi(email, sifre)) {

            return ResponseEntity.ok("Giriş başarılı");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Kullanıcı adı veya şifre hatalı");
        }
    }

}
