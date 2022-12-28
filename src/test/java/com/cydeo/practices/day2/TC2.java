package com.cydeo.practices.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC2 {

    // TC #2: Zero Bank header verification
    //1. Open Chrome browser
    //2. Go to http://zero.webappsecurity.com/login.html
    //3. Verify header text
    //Expected: “Log in to ZeroBank”

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement headerText = driver.findElement(By.tagName("h3"));
        String expectedHeaderText =  "Log in to ZeroBank";
        String actualHeaderText = headerText.getText();

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header Text verification PASSED!");
        }else{
            System.out.println("Header Text verification FAILED!");
        }

    }

}
