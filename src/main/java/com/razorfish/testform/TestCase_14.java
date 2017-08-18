package com.razorfish.testform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

/**
Negative Test - correct first name, correct last name(with symbol) and without phone number. 

*/

public class TestCase_14  {
    public static void main( String[] args )
    {
    	 System.setProperty ("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
    	 WebDriver driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.findElement(By.xpath("/html/body/div/form/input[1]")).sendKeys("Leping");
    	 driver.findElement(By.xpath("/html/body/div/form/input[2]")).sendKeys("Guo");
    	 driver.findElement(By.xpath("/html/body/div/form/input[3]")).sendKeys(" ");
    	 driver.findElement(By.xpath("/html/body/div/form/button[1]")).click();  
    	 // Here need to  get the actual content appearing on the web page after the button of Submit being clicked.
    	 Assert.assertEquals("expectedContent","actualContentAppearing"); 
    	 
    	 driver.close();
    	 
    }
}

