package com.example.kuaforrandevusistemi.Controller;

import com.example.kuaforrandevusistemi.Dto.RandevuDto;
import com.example.kuaforrandevusistemi.Dto.ShiftTablosuDto;
import com.example.kuaforrandevusistemi.Service.RandevuService;
import com.example.kuaforrandevusistemi.Service.ShiftTablosuService;
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
@RequestMapping("/api/shiftTablolari")
public class ShiftTablosuController {
    @Resource
    private ShiftTablosuService shiftTablosuService;

    @PostMapping
    public ResponseEntity<ShiftTablosuDto> shiftTablosuYarat(@RequestBody ShiftTablosuDto shiftTablosuDto){
        ShiftTablosuDto kayitEdilmisShiftTablosu = shiftTablosuService.shiftTablosuYarat(shiftTablosuDto);
        return new ResponseEntity<>(kayitEdilmisShiftTablosu, HttpStatus.CREATED);
    }
}
