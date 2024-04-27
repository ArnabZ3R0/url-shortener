package com.zero.urlshortenerms.service;

import com.zero.urlshortenerms.enitity.Url;
import com.zero.urlshortenerms.enitity.UrlDto;

public interface UrlShortenerService {

    public Url generateUrl(UrlDto urlDto);

    public long generateId();

    public String encodeUrl(Long id);

    public Url redirectToOriginalUrl(String url);
}
