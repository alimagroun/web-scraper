package com.magroun.scarper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.magroun.scarper.dto.ResponseDTO;
import com.magroun.scarper.service.ScraperService;

import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping(path = "/")
public class ScraperController {
    @Value("${base.url}")
    private String baseUrl;

    @Autowired
    ScraperService scraperService;

    /**
     * Retrieves a list of products by performing data scraping based on the provided keyword.
     * This method uses Selenium WebDriver to scroll the page and collect data from all articles.
     * If you prefer not to use scrolling, consider using the alternative method without scrolling, which utilizes Jsoup.
     *
     * @param keyword The keyword used to search for products.
     */
    @GetMapping("/scraped-products-selenium")
    public List<ResponseDTO> getProductByKeyword(@RequestParam String keyword) {
        String fullUrl = baseUrl + keyword;
        return scraperService.getProductByKeyword(fullUrl);
    }
        
    /**
     * Retrieves a list of products by performing data scraping based on the provided keyword.
     * This method uses Jsoup library to scrape data from the specified URL. It does not involve scrolling.
     *
     * @param keyword The keyword used to search for products.
     */
    @GetMapping("/scraped-products")
    public List<ResponseDTO> getScrapedProductsByKeyword(@RequestParam String keyword) {
        String fullUrl = baseUrl + keyword;
        return scraperService.getProductByKeywordWithJsoup(fullUrl);
    }
    
}
