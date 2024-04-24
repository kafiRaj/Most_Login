package com.LoginPage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class FormOpen {
	
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
  public void OpenService() {
	  
	  driver.get("https://tr-license.most.gov.bd/en/services/baera/import-export-permit");
	  
  }
  
  
  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
