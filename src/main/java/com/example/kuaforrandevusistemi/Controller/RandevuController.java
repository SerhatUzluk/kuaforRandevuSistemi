package com.example.kuaforrandevusistemi.Controller;

import com.example.kuaforrandevusistemi.Dto.RandevuDto;
import com.example.kuaforrandevusistemi.Service.RandevuService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}