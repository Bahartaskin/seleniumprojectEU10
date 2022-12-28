package com.cydeo.practices.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC3 {

    //TC #3: Back and forth navigation
    //1- Open a chrome browser
    //2- Go to: https://google.com
    //3- Click to Gmail from top right.
    //4- Verify title contains:
    //  Expected: Gmail
    //5- Go back to Google by using the .back();
    //6- Verify title equals:
    //  Expected: Google

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://google.com");

        WebElement gmail = driver.findElement(By.cssSelector("a[class='gb_j']"));
        gmail.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Gmail";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAIlED!!");
        }

        driver.navigate().back();

        String actualGoogleTitle = driver.getTitle();
        String expectedGoggleTitle = "Google";

        if ( actualGoogleTitle.equals(expectedGoggleTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAIlED!!");
        }

    }

}
