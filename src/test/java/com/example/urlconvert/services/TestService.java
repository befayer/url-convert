package com.example.urlconvert.services;

import com.example.urlconvert.dao.UrlRepository;
import com.example.urlconvert.entity.Url;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class TestService {

    @Autowired
    private ConvertUrlService convertUrlService;

    @MockBean
    private UrlRepository urlRepository;


    /**
     * Testing the presence of a long link with creation of a new object
     */
    @Test
    void convertUrl() {
        String longUrl = "netology.ru";
        String convertUrl = "-1454289302";
        Url urlObj = new Url();
        urlObj.setConvertUrl(convertUrl);
        urlObj.setLongUrl(longUrl);
        Mockito.when(urlRepository.findByLongUrl(longUrl)).thenReturn(Optional.of(urlObj));
        String result = convertUrlService.getConvertUrl(longUrl);
        Assertions.assertEquals(convertUrl, result);
    }

    /**
     * Testing the presence of a long link
     */
    @Test
    void longUrl() {
        String longUrl = "netology.ru";
        String convertUrl = "-1454289302";
        Url urlObj = new Url();
        urlObj.setConvertUrl(convertUrl);
        urlObj.setLongUrl(longUrl);
        Mockito.when(urlRepository.findByConvertUrl(convertUrl)).thenReturn(Optional.of(urlObj));
        Assertions.assertEquals(longUrl, convertUrlService.getLongUrl(convertUrl));
    }

    /**
     * Testing the conversion service
     */
    @Test
    void mainLogic() {
        Assertions.assertEquals("-1454289302", convertUrlService.convertUrl("netology.ru"));
    }
}


