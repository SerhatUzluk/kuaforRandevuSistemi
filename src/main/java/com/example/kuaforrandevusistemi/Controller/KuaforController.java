package com.example.kuaforrandevusistemi.Controller;

import com.example.kuaforrandevusistemi.Dto.KuaforDto;
import com.example.kuaforrandevusistemi.Service.KuaforService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
