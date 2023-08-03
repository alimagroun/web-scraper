package com.magroun.scarper.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.magroun.scarper.dto.ResponseDTO;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

@Service
public class ScraperServiceImpl implements ScraperService {
	
    @Value("${chromedriver.path}")
    private String chromedriverPath;
	
	public List<ResponseDTO> getProductByKeyword(String url) {
		List<ResponseDTO> extractedData = new ArrayList<>();

	    try {

	        System.setProperty("webdriver.chrome.driver", chromedriverPath);

	        WebDriver driver = new ChromeDriver();

	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

	        driver.get(url);

	        Thread.sleep(5000);

	        for (int i = 0; i < 5; i++) {
	
	            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	            Thread.sleep(2000);
	        }

	        List<WebElement> articleElements = driver.findElements(By.tagName("article"));

	        for (WebElement articleElement : articleElements) {
	            WebElement priceElement = null;
	            try {
	                priceElement = articleElement.findElement(By.cssSelector("data"));
	            } catch (NoSuchElementException ex) {

	                priceElement = null; 
	            }

	            String price = "N/A";
	            if (priceElement != null) {
	                price = priceElement.getText();
	            }
	            String name = articleElement.findElement(By.className("card-title")).getText();
	            String category = articleElement.findElement(By.cssSelector("span.text-3xs")).getText();
	            String cityWithTime = articleElement.findElement(By.cssSelector("span.line-clamp-1")).getText();
	            String city = cityWithTime.split(",")[0].trim();

	            ResponseDTO responseDTO = new ResponseDTO(price, name, category, city);
	            extractedData.add(responseDTO);
	        }

	        driver.quit();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return extractedData;
	}
	
    public List<ResponseDTO> getProductByKeywordWithJsoup(String url) {
        List<ResponseDTO> extractedData = new ArrayList<>();

        try {
        	
            Document document = Jsoup.connect(url).get();

            Elements articleElements = document.select("article");

            for (Element articleElement : articleElements) {
                String price = articleElement.select("data").text();
                String name = articleElement.select("h2.card-title").text();
                String categoryWithTime = articleElement.select("span.text-3xs").text();
                String category = categoryWithTime.split(",")[0].trim();
                String cityWithTime = articleElement.select("span.line-clamp-1").text();
                String city = cityWithTime.split(",")[0].trim();

                ResponseDTO responseDTO = new ResponseDTO(price, name, category, city);
                extractedData.add(responseDTO);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return extractedData;
    }
}
