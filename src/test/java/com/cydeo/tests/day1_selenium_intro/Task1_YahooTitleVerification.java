package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {

    public static void main(String[] args) {

        //TC #1: Yahoo Title Verification
        //1. Open Chrome browser

        //  set up the browser driver
        WebDriverManager.chromedriver().setup();

        //  create instance of the Selenium  Webdriver
        WebDriver driver = new ChromeDriver(); // opens empty browser

        driver.manage().window().maximize(); // to make the page fullscreen

        //2. Go to https://www.yahoo.com
        driver.get("https://www.yahoo.com");

        //3. Verify title:

        String expectedTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title is as expected. Verification PASSED!");
        }else{
            System.out.println("Title is NOT as expected. Verification FAILED!");
        }

        //Expected: Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos

    }

}
