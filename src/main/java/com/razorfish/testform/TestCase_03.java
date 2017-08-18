package com.razorfish.testform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

/**
 * 
 Positive test - for correct first name (with 20 characters), correct last name and correct phone number
 *
 */
public class TestCase_03   
{
    public static void main( String[] args )
    {
    	System.setProperty ("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
    	 WebDriver driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.findElement(By.xpath("/html/body/div/form/input[1]")).sendKeys("LepingLepingLepingLeping");
    	 driver.findElement(By.xpath("/html/body/div/form/input[2]")).sendKeys("Guo");
    	 driver.findElement(By.xpath("/html/body/div/form/input[3]")).sendKeys("647-545 8440");
    	 driver.findElement(By.xpath("/html/body/div/form/button[1]")).click();  
    	 // Here need to  get the actual content appearing on the web page after the button of Submit being clicked.
    	 Assert.assertEquals("expectedContent","actualContentAppearing"); 
    	 
    	 driver.close();
    	 
    }
}

