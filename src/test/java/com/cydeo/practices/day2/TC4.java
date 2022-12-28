package com.cydeo.practices.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC4 {

    //TC #4: Practice Cydeo – Class locator practice
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/inputs
    //3- Click to “Home” link
    //4- Verify title is as expected:
    //Expected: Practice
    //
    //PS: Locate “Home” link using “className” locator

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/inputs");

        WebElement homeLink = driver.findElement(By.cssSelector("a[class= 'nav-link']"));
        homeLink.click();

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAIlED!!");
        }



    }

}
