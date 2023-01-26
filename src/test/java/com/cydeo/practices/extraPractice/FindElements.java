package com.cydeo.practices.extraPractice;

import com.cydeo.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElements {


    @BeforeTest
    public void setup() {

        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        */

        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        Driver.getDriver().get("https://www.openxcell.com");

    }

    @Test
    public void numberOfLinksTest() {

        //3. Count the number of the links on the page and verify
        //Expected: 355
        List<WebElement> allLinks = Driver.getDriver().findElements(By.xpath("//a"));
        System.out.println("allLinks.size() = " + allLinks.size());

        int expectedLinkSize = 355;
        int actualLinkSize = allLinks.size();

        Assert.assertEquals(expectedLinkSize,actualLinkSize);


    }

    @Test
    public void textOfLinksTest() {

        //3. Print out all the texts of the links on the page
        List<WebElement> allLinks = Driver.getDriver().findElements(By.xpath("//a"));

        for (WebElement each : allLinks) {
            System.out.println("Text of links = " + each.getText());
        }


    }

    @Test
    public void numberOfEmptyLinksTest() {

        //3. Count the number of links that does not have text and verify
        //Expected: 109
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));

        int numberOfEmptyLinks = 0;

        for (WebElement each : allLinks) {
            if (each.getText().equals("")) {

                numberOfEmptyLinks++;

            }
        }

        System.out.println("numberOfEmptyLinks = " + numberOfEmptyLinks);

        int expectedNumberOfEmptyLinks = 259;
        int actualNumberOfEmptyLinks = numberOfEmptyLinks;

        Assert.assertEquals(expectedNumberOfEmptyLinks,actualNumberOfEmptyLinks);

    }


    @AfterTest
    public void close(){
        Driver.getDriver().close();
    }

}