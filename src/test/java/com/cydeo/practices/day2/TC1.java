package com.cydeo.practices.day2;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC1 {

    //TC #1: Etsy Title Verification
    //1. Open Chrome browser
    //2. Go to https://www.etsy.com
    //3. Search for “wooden spoon”
    //4. Verify title:
    //Expected: “Wooden spoon | Etsy”

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");

        WebElement searchBar = driver.findElement(By.cssSelector("input[id='global-enhancements-search-query']"));
        searchBar.sendKeys("wooden spoon" + Keys.ENTER);

        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAIlED!!");
        }

        // failed because actual title is "Wooden spoon - Etsy"


    }



}
