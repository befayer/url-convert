package com.example.urlconvert.services;

import com.example.urlconvert.dao.UrlRepository;
import com.example.urlconvert.entity.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConvertUrlService {

    private final Logger logger = LoggerFactory.getLogger(ConvertUrlService.class);
    private final UrlRepository urlRepository;

    public ConvertUrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String getLongUrl(String convertedUrl) {
        Optional<Url> urlOptional = urlRepository.findByConvertUrl(convertedUrl);

        if (urlOptional.isEmpty()) {
            throw new RuntimeException("Url: " + convertedUrl + " not found");
        }
        logger.info("A short url was received : " + convertedUrl + " and its long one was sent");
        return urlOptional.get().getLongUrl();
    }

    public String getConvertUrl(String longUrl) {
        Optional<Url> urlOptional = urlRepository.findByLongUrl(longUrl);

        if (urlOptional.isPresent()) {
            return urlOptional.get().getConvertUrl();
        }

        Url url = new Url();
        url.setConvertUrl(convertUrl(longUrl));
        url.setLongUrl(longUrl);
        logger.info("A url was received : " + longUrl + " and its short " + convertUrl(longUrl) + " one was sent");
        return urlRepository.save(url).getConvertUrl();
    }

    public String convertUrl(String longUrl) {
        return String.valueOf(longUrl.hashCode());
    }
}
