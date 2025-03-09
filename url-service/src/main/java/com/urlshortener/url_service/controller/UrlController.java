package com.urlshortener.url_service.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    private Map<String, String> urlStore = new HashMap<>();

    @PostMapping("/shorten")
    public Map<String, String> shortenUrl(@RequestParam String longUrl) {
        String shortUrl = UUID.randomUUID().toString().substring(0, 8);
        urlStore.put(shortUrl, longUrl);
        return Map.of("shortUrl", shortUrl);
    }

    @GetMapping("/{shortUrl}")
    public Map<String, String> getLongUrl(@PathVariable String shortUrl) {
        return urlStore.containsKey(shortUrl)
                ? Map.of("longUrl", urlStore.get(shortUrl))
                : Map.of("error", "URL not found");
    }
}
