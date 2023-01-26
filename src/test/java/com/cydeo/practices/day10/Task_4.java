package com.cydeo.practices.day10;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_4 {

    @BeforeTest
    public void setup(){
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");
    }

    @AfterTest
    public void close(){
        Driver.getDriver().close();
    }

    @Test
    public void scrollPractice_Test1(){

        //3- Scroll down to “Sign Up For Mailing List”
        //4- Scroll using Actions class “moveTo(element)” method
        Actions actions = new Actions(Driver.getDriver());

        WebElement signUpForMailingList = Driver.getDriver().findElement(By.xpath("//a[@href='/sign_up']"));
        BrowserUtils.sleep(2);
        actions.moveToElement(signUpForMailingList).perform();

        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
        BrowserUtils.sleep(3);
        actions.sendKeys(Keys.PAGE_UP).build().perform();

    }


}
