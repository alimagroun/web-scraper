## Web Scraper Project

This is a web scraping project that extracts data from a tayara.tn based on a provided keyword.
It uses Selenium WebDriver for one method and Jsoup for another method to collect data from different articles on the website.

# Introduction

Web scraping is the process of extracting data from websites programmatically.
This project demonstrates two methods to scrape data from a specific website based on a keyword.
One method uses Selenium WebDriver to scroll through the page and collect data from all articles,
while the other method uses Jsoup to extract data without scrolling.

# Technologies Used

Java
Spring Boot
Selenium WebDriver
Jsoup

# Installation
Before running the project, make sure you have the following installed on your machine:

Java Development Kit (JDK): Make sure you have JDK 8 or higher installed.

Maven: Make sure you have Maven installed. If you don't have it, you can download it from here.

ChromeDriver: The Selenium WebDriver requires ChromeDriver to interact with the Chrome browser.
You can download the compatible version of ChromeDriver for your Chrome browser from the official website.
Ensure that the version of ChromeDriver you download matches the version of Chrome installed on your machine.

After installing ChromeDriver, update the path to the chromedriver executable in the application.properties file as follows:

# application.properties

webdriver.chrome.driver=/path/to/your/chromedriver.exe

Replace /path/to/your/chromedriver.exe with the actual path to the downloaded chromedriver executable.

# Methods

The project contains two methods for web scraping:

getScrapedProductsByKeywordWithSelenium(keyword): Uses Selenium WebDriver to scroll through the page and collect data from all articles based on the provided keyword.

getProductByKeywordWithJsoup(keyword): Uses Jsoup to extract data from the website without scrolling.
This method provides an alternative to the first method for web scraping.

