package com.cydeo.practices.extraPractice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3 {


    @Test
    public void orderVerification(){

        //TC#3: Smartbear software order verification
        //1. Open browser and login to Smartbear software
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtils.loginToSmartBear();

        //2. Click on View all orders
        WebElement viewAllOrders = Driver.getDriver().findElement(By.xpath("//a[text()='View all orders']"));
        viewAllOrders.click();

        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebElement orderDate = Driver.getDriver().findElement(By.xpath("//td[text()='Susan McLaren']/following-sibling::td[3]"));
        String expectedOrderDate = "01/05/2010";
        String actualOrderDate = orderDate.getText();

        Assert.assertEquals(expectedOrderDate,actualOrderDate);

        Driver.getDriver().close();



    }

}
