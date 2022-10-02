package com.example.urlconvert.dao;

import com.example.urlconvert.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByConvertUrl(String convertUrl);
    Optional<Url> findByLongUrl(String longUrl);

}
