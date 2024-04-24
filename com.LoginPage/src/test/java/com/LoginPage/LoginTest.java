package com.LoginPage;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
 
  public static String ChromeDriverPath=".\\src\\test\\resources\\drivers\\chromedriver.exe";
  public static  String baseUrl = "https://tr-services.most.gov.bd/en/auth/login";
  
  public static WebDriver driver;

  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
	  driver = new ChromeDriver();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  driver.get(baseUrl);
		
	 
  }
  
  
  @Test
  public void LoginFormTest() throws InterruptedException {
	  
	  WebElement username = driver.findElement(By.id("loginForm_username"));
	  username.click();
	  username.clear();
	  username.sendKeys("tr-admin@most.gov.bd");
	  
	  
	  WebElement password = driver.findElement(By.id("loginForm_password"));
	  username.click();
	  password.clear();
	  password.sendKeys("Abc123!");
	  
	  
	  WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	  loginButton.click();
	 
	  Thread.sleep(5000);
	  
	  
	  WebElement actualTextField = driver.findElement(By.xpath("//h2[contains(text(), 'Integrated Digital Service Delivery Platform')]"));
	  
	  String actualText = actualTextField.getText();

	  
	  Assert.assertEquals(actualText, "Integrated Digital Service Delivery Platform");
	  
  }
  
  

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
