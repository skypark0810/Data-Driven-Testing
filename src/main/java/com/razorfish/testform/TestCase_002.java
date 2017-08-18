package com.razorfish.testform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;

/**
Negative Test -  wrong first name, or wrong last name, or wrong phone number. then click button "Submit"
                
*/

public class TestCase_002  {
    public static void main( String[] args )
    {
    	 System.setProperty ("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
    	 WebDriver driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 
    	 String csvFile = "SourceData/negativeTestData.csv";
         String line = "";
         String cvsSplitBy = ",";

         try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
         {

             while ((line = br.readLine()) != null) {

                 // use comma as separator
                 String[] info = line.split(cvsSplitBy);
                 String firstName = info[0];
                 String lastName = info[1];
                 String phoneNumber = info[2];
                 
             	 driver.findElement(By.xpath("/html/body/div/form/input[1]")).sendKeys(firstName);
            	 driver.findElement(By.xpath("/html/body/div/form/input[2]")).sendKeys(lastName);
            	 driver.findElement(By.xpath("/html/body/div/form/input[3]")).sendKeys(phoneNumber);
            	 driver.findElement(By.xpath("/html/body/div/form/button[2]")).click();  
                
            	 // verify not being submitted.    	 
            	 String expectedContent = "Test Form";
            	 String actualContent = driver.findElement(By.xpath("/html/body/div/h1")).getText();            	 
            	 Assert.assertEquals(expectedContent,actualContent); 
            	
            	 // clearing the text area for iteration of the test case
            	 driver.findElement(By.xpath("/html/body/div/form/button[2]")).click();
            	   
             }

         } catch (IOException e) {
             e.printStackTrace();
         }   	
    	  	
    	 driver.close();
    	 
    }
}

