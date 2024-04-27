package com.zero.urlshortenerms.repository;

import com.zero.urlshortenerms.enitity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, String> {

    public Url findByShortUrl(String shortUrl);
}
