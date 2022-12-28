package com.cydeo.practices.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Facebook_T2 {

    //TC #2: Facebook incorrect login title verification
    //1. Open Chrome browser
    //2. Go to https://www.facebook.com
    //3. Enter incorrect username
    //4. Enter incorrect password
    //5. Verify title changed to:
    //Expected: “Log into Facebook”

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        WebElement userName = driver.findElement(By.cssSelector("input[id='email']"));
        userName.sendKeys("incorrectUserName");

        WebElement password = driver.findElement(By.cssSelector("input[id='pass']"));
        password.sendKeys("incorrectPassword");

        WebElement signInButton = driver.findElement(By.cssSelector("button[value='1']"));
        signInButton.click();

        String expectedTitle = "Log into Facebook";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){

            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAIlED!!");
        }

        //failled because actualTitle is Log in to Facebook

    }

}
