package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Actions_Hover {

    @Test
    public void hovering_Test(){

        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        //Locate all images under here:
        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //Locate all the "user" texts under here:
        WebElement userText1 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement userText2 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement userText3 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));

        //2. Hover over to first image
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        actions.moveToElement(image1).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(userText1.isDisplayed(),"Failed userText1");

        //4. Hover over to second image
        BrowserUtils.sleep(2);
        actions.moveToElement(image2).perform();

        //5. Assert:
        //a. “name: user2” is displayed
        Assert.assertTrue(userText2.isDisplayed(),"Failed userText2");

        //6. Hover over to third image
        BrowserUtils.sleep(2);
        actions.moveToElement(image3).perform();

        //7. Confirm:
        //a. “name: user3” is displayed
        Assert.assertTrue(userText3.isDisplayed(),"Failed userText3");


        Driver.getDriver().close();


    }

}
