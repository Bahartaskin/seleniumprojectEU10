package com.cydeo.practices.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Facebook_T1 {

    //TC #1: Facebook title verification
    //1. Open Chrome browser
    //2. Go to https://www.facebook.com
    //3. Verify title:
    //Expected: “Facebook - Log In or Sign Up”

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){

            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAIlED!!");
        }
    }

}
