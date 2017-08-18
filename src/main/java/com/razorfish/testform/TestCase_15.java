package com.razorfish.testform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

/**
Positive Test - enter first name,  last name and phone number. then click button "Clear Form"
                
*/

public class TestCase_15  {
    public static void main( String[] args )
    {
    	 System.setProperty ("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
    	 WebDriver driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.findElement(By.xpath("/html/body/div/form/input[1]")).sendKeys("Leping");
    	 driver.findElement(By.xpath("/html/body/div/form/input[2]")).sendKeys("Guo");
    	 driver.findElement(By.xpath("/html/body/div/form/input[3]")).sendKeys("647-545 8440 ");
    	 driver.findElement(By.xpath("/html/body/div/form/button[2]")).click();  
    	 
    	 String firstNameActual = driver.findElement(By.xpath("/html/body/div/form/input[1]")).getText();
    	 String lastNameActual = driver.findElement(By.xpath("/html/body/div/form/input[2]")).getText();
    	 String phoneNumberActual = driver.findElement(By.xpath("/html/body/div/form/input[3]")).getText();
    	 
    	 Assert.assertEquals("",firstNameActual); 
    	 Assert.assertEquals("",lastNameActual); 	 
    	 Assert.assertEquals("", phoneNumberActual); 
    	 
    	 driver.close();
    	 
    }
}

