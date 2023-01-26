package com.cydeo.practices.day10;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Task_7 {

   @Test
    public void scrollTask(){

       //TC #7: Scroll using JavascriptExecutor
       //1- Open a chrome browser
       //2- Go to: https://practice.cydeo.com/large
       Driver.getDriver().get("https://practice.cydeo.com/large");

       //3- Scroll down to “Cydeo” link
       JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
       WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[@href='https://cydeo.com/']"));
       BrowserUtils.sleep(2);
       js.executeScript("arguments[0].scrollIntoView()",cydeoLink);

       //4- Scroll up to “Home” link
       WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[@href='/']"));
       BrowserUtils.sleep(2);
       js.executeScript("arguments[0].scrollIntoView()",homeLink);



       //5- Use below provided JS method only
       //
       //JavaScript method to use : arguments[0].scrollIntoView(true)
       //
       //Note: You need to locate the links as web elements and pass them as
       //arguments into executeScript() method

   }

}
