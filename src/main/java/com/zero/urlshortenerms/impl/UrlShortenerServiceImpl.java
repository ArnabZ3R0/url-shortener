package com.zero.urlshortenerms.impl;

import cn.hutool.core.lang.Snowflake;
import com.zero.urlshortenerms.enitity.Url;
import com.zero.urlshortenerms.enitity.UrlDto;
import com.zero.urlshortenerms.repository.UrlRepository;
import com.zero.urlshortenerms.service.UrlShortenerService;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.unbrokendome.base62.Base62;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    UrlRepository urlRepository;

    public UrlShortenerServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Url generateUrl(UrlDto urlDto) {
        if(StringUtils.isNotEmpty(urlDto.getLongUrl())){
            Url url = new Url();
            Long id = generateId();
            String shortUrl = encodeUrl(id);
            url.setId(id);
            url.setLongUrl(urlDto.getLongUrl());
            url.setShortUrl(shortUrl);

            urlRepository.save(url);

        }

        return null;
    }

    @Override
    public long generateId() {
        Snowflake snowflake = new Snowflake();
        return snowflake.nextId();
    }

    @Override
    public String encodeUrl(Long id) {
        return Base62.encode(id);
    }

    @Override
    public Url redirectToOriginalUrl(String shortUrl) {

        if(StringUtils.isNotEmpty(shortUrl)){
            return urlRepository.findByShortUrl(shortUrl);
        }
        return null;
    }
}
