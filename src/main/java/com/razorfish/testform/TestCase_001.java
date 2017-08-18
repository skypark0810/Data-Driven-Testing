package com.razorfish.testform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;

/**
Positive Test -  correct first name, correct last name and correct phone number. then click button "Submit"
                
*/

public class TestCase_001  {
    public static void main( String[] args )
    {
    	 System.setProperty ("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
    	 WebDriver driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 
    	 String csvFile = "SourceData/positiveTestData.csv";
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
            	 driver.findElement(By.xpath("/html/body/div/form/button[1]")).click();  
          
            	 /**
            	  * Here need to  get the actual content appearing on the web page after the button of Submit being clicked and 
            	  * successfully being sumitted.
            	  */           	
            	 Assert.assertEquals("expectedContent","actualContentAppearing"); 
            	 
            	 // get back to the page of Test Form for iteration of the test case
            	 driver.get(" here is TestFormURL" );   	

             }

         } catch (IOException e) {
             e.printStackTrace();
         }   	
    	  	
    	 driver.close();
    	 
    }
}

