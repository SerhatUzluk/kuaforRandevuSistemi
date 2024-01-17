package com.example.kuaforrandevusistemi.Repository;

import com.example.kuaforrandevusistemi.Dto.MusteriDto;
import com.example.kuaforrandevusistemi.Entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusteriRepository extends JpaRepository<Musteri, Long> {
    Optional<Musteri> findByMailAdresAndSifre(String mailAdres, String sifre);
}
