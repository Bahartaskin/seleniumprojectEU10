package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_JSExecutor {

    @Test
    public void task7_scroll_test(){

        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[@target='_blank']"));
        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']"));

        //Down-casting our driver type to JavascriptExecutor,
        // so we are able to use the methods coming from that interface

        JavascriptExecutor javaS = (JavascriptExecutor) Driver.getDriver();

        //3- Scroll down to “Cydeo” link
        BrowserUtils.sleep(2);
        javaS.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);

        //4- Scroll up to “Home” link
        BrowserUtils.sleep(2);
        //js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink);
        javaS.executeScript("arguments[0].scrollIntoView(true)", homeLink);
    }

}
