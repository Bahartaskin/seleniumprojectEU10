package com.cydeo.practices.extraPractice;

import com.cydeo.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBearUtils {


    public static void  loginToSmartBear(){



        //3. Enter username: “Tester”
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
    }

}
