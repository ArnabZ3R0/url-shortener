package com.zero.urlshortenerms.controller;

import cn.hutool.core.lang.Snowflake;
import com.zero.urlshortenerms.enitity.Url;
import com.zero.urlshortenerms.enitity.UrlDto;
import com.zero.urlshortenerms.service.UrlShortenerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class Urlshortenercontroller {

    UrlShortenerService urlShortenerService;

    public Urlshortenercontroller(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping()
    public ResponseEntity<String> generateUrl(@RequestBody UrlDto urlDto){
        Url url = urlShortenerService.generateUrl(urlDto);
        return new ResponseEntity<>("Short URL successfully generated, short url : " + url.getShortUrl() , HttpStatus.CREATED);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        Url url = urlShortenerService.redirectToOriginalUrl(shortUrl);
        if(url != null){
            response.sendRedirect(url.getLongUrl());
        }

        return new ResponseEntity<>("Short Url not found in database! Please generate a short URL to long URL mapping",HttpStatus.NOT_FOUND);
    }

}
