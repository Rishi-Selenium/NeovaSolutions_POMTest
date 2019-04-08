package tests;

import org.testng.annotations.Test;

import Pages_Components.HomePage_Component;
import servicesData.HomePage_Data;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class AbstractTest {
  protected static WebDriver driver;
  HomePage_Component homePage_Component;
  protected static HomePage_Data homePage_Data;
  protected static WebDriverWait wait ;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\Driver\\chromedriver_win32 (9)\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://www.amazon.in");
	  homePage_Component = new HomePage_Component();
	  homePage_Data =new HomePage_Data();
	  wait = new WebDriverWait(driver, 20);
	  
	  PageFactory.initElements(driver, homePage_Component);
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
