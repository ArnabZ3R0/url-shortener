package com.zero.urlshortenerms.enitity;

public class UrlDto {
    private String longUrl;

//    public UrlDto(String longUrl) {
//        this.longUrl = longUrl;
//    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    @Override
    public String toString() {
        return "UrlDto{" +
                "longUrl='" + longUrl + '\'' +
                '}';
    }
}
