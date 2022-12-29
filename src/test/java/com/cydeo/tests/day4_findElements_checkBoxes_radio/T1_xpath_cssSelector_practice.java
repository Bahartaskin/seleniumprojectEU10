package com.cydeo.tests.day4_findElements_checkBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {

    //XPATH and CSS Selector PRACTICES
    //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
    //TC #1: XPATH and cssSelector Practices
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/forgot_password
    //3. Locate all the WebElements on the page using XPATH and/or CSS
    //locator only (total of 6)
    //a. “Home” link
    //b. “Forgot password” header
    //c. “E-mail” text
    //d. E-mail input box
    //e. “Retrieve password” button
    //f. “Powered by Cydeo text
    //4. Verify all web elements are displayed.
    //First solve the task with using cssSelector only. Try to create 2 different
    //cssSelector if possible
    //
    //Then solve the task using XPATH only. Try to create 2 different
    //XPATH locator if possible

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/forgot_password");

        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //Locate homeLink using cssSelector syntax #2
        WebElement homeLink_ex2= driver.findElement(By.cssSelector("a.nav-link"));
        //Locate homeLink using cssSelector, href value
        WebElement homeLink_ex3= driver.findElement(By.cssSelector("a[href='/']"));

        //b. “Forgot password” header
        //Locate header using cssSelector: locate parent element and move down to h2
        WebElement header_ex1 = driver.findElement(By.cssSelector("div.example > h2"));
        //Locate header using xpath, and using web elements text "Forgot Password"
        //WebElement header_ex2 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        WebElement emailText = driver.findElement(By.cssSelector("label[for='email']"));
        //c. “E-mail” text
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

        WebElement emailInput = driver.findElement(By.xpath("//input[@type='text']"));
        //d. E-mail input box
        WebElement inputBox_ex1 = driver.findElement(By.xpath("//input[@name='email']"));
        //Locate inputBox using xpath contains method
        //tagName[contains(@attribute,'value')]
        WebElement inputBox_ex2 = driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));


        //e. “Retrieve password” button
        //button[@type='submit']
        //button[@class='radius']
        WebElement retrievePasswordBtn = driver.findElement(By.xpath("//button[@id='form_submit']"));
        WebElement retrievePasswordButton = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));


        //f. “Powered by Cydeo text
        WebElement poweredByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        WebElement poweredByCydeoTxt = driver.findElement(By.cssSelector("div[style='text-align: center;']"));


        System.out.println("homeLink = " + homeLink.isDisplayed());
        System.out.println("homeLink_ex2 = " + homeLink_ex2.isDisplayed());
        System.out.println("homeLink_ex3 = " + homeLink_ex3.isDisplayed());
        System.out.println("header_ex1 = " + header_ex1.isDisplayed());
        System.out.println("forgotPasswordHeader = " + forgotPasswordHeader.isDisplayed());
        System.out.println("emailText = " + emailText.isDisplayed());
        System.out.println("emailLabel = " + emailLabel.isDisplayed());
        System.out.println("emailInput = " + emailInput.isDisplayed());
        System.out.println("inputBox_ex1 = " + inputBox_ex1.isDisplayed());
        System.out.println("inputBox_ex2 = " + inputBox_ex2.isDisplayed());
        System.out.println("retrievePasswordBtn = " + retrievePasswordBtn.isDisplayed());
        System.out.println("retrievePasswordButton = " + retrievePasswordButton.isDisplayed());
        System.out.println("poweredByCydeoText = " + poweredByCydeoText.isDisplayed());
        System.out.println("poweredByCydeoTxt = " + poweredByCydeoTxt.isDisplayed());


    }

}
