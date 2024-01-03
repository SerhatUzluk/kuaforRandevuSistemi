package com.example.kuaforrandevusistemi.Controller;

import com.example.kuaforrandevusistemi.Dto.KuaforDto;
import com.example.kuaforrandevusistemi.Dto.MusteriDto;
import com.example.kuaforrandevusistemi.Service.KuaforService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/kuaforler")
public class KuaforController {
    @Autowired // veya @Resource
    private KuaforService kuaforService;

    @PostMapping
    public ResponseEntity<KuaforDto> kuaforYarat(@RequestBody KuaforDto kuaforDto){
        KuaforDto kayitEdilmisKuafor = kuaforService.kuaforYarat(kuaforDto);
        return new ResponseEntity<>(kayitEdilmisKuafor, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<KuaforDto> idIleGetir(@PathVariable("id") Long kuaforId){
        KuaforDto personelDto= kuaforService.idIleGetir(kuaforId);
        return ResponseEntity.ok(new KuaforDto());
    }
    @GetMapping
    public ResponseEntity<List<KuaforDto>> tumKuaforleriGetir(){
        List<KuaforDto> kuaforDtoList = kuaforService.tumKuaforleriGetir();
        return ResponseEntity.ok(kuaforDtoList);
    }

    @PutMapping("{id}")
    public ResponseEntity<KuaforDto> kuaforGuncelle(@PathVariable("id") Long kuaforId,
                                                        @RequestBody KuaforDto guncelKuaforDto){
        KuaforDto kuaforDto = kuaforService.kuaforGuncelle(kuaforId,guncelKuaforDto);
        return ResponseEntity.ok(kuaforDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> kuaforSil(@PathVariable("id") Long kuaforId){
        kuaforService.kuaforSil(kuaforId);
        return ResponseEntity.ok("Kuafor basariyla silindi.");
    }

}
