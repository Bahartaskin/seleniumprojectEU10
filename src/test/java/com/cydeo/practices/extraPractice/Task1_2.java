package com.cydeo.practices.extraPractice;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1_2 {


    @BeforeTest
    public void setup(){
        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        */

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");

    }

    @Test
    public void smartBearTest1(){

        //3. Enter username: “Tester”
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("allLinks.size() = " + allLinks.size());

        //7. Print out each link text on this page
        for (WebElement each : allLinks) {

            System.out.println("Text of links = " + each.getText());

        }

    }

    @Test
    public void smartBearTest2(){

        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button
        SmartBearUtils.loginToSmartBear();

        //6. Click on Order
        WebElement orderLink = Driver.getDriver().findElement(By.xpath("//a[@href='Process.aspx']"));
        orderLink.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select familyAlbum = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));

        familyAlbum.selectByValue("FamilyAlbum");

        WebElement quantityBox = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantityBox.clear();
        quantityBox.sendKeys("2");

        //. Click to “Calculate” button
        WebElement calculateButton = Driver.getDriver().findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker faker = new Faker();

        WebElement customerName = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        customerName.sendKeys(faker.name().fullName());

        WebElement street = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys(faker.address().streetName());

        WebElement city = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        city.sendKeys(faker.address().city());

        WebElement state = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        state.sendKeys(faker.address().state());

        WebElement zipCode = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zipCode.sendKeys(faker.address().zipCode().replaceAll("-",""));

        //10. Click on “visa” radio button
        WebElement visaRadioButton = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaRadioButton.click();

        //11. Generate card number using JavaFaker
        WebElement cardNumber = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        WebElement expireDate = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expireDate.sendKeys(faker.numerify("##/##"));

        //12. Click on “Process”
        WebElement processButton = Driver.getDriver().findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

        //13. Verify success message “New order has been successfully added.”
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@class='buttons_process']/strong"));
        String expectedSuccessMessage = "New order has been successfully added.";
        String actualSuccessMessage = successMessage.getText();

        Assert.assertEquals(expectedSuccessMessage,actualSuccessMessage,"Test failed!!");


    }


    @AfterTest
    public void close(){
        Driver.getDriver().close();
    }


}
