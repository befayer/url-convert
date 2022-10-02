package com.example.urlconvert.controllers;

import com.example.urlconvert.services.ConvertUrlService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlController {
    public final ConvertUrlService convertUrlService;

    public UrlController(ConvertUrlService convertUrlService){
        this.convertUrlService = convertUrlService;
    }

    @GetMapping("/get-long-url/{url}")
    public String getLongUrl(@PathVariable @NonNull String url){
        return convertUrlService.getLongUrl(url);
    }

    @PostMapping("/get-convert-url/{url}")
    public String getConvertUrl(@PathVariable @NonNull String url){
        return convertUrlService.getConvertUrl(url);
    }
}
