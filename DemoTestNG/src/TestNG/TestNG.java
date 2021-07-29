package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
 
public class TestNG {
  	
  	WebDriver driver;
  	
  @Test
  public void testcase1() {
  	  //Setting up the chrome driver exe, the second argument is the location where you have kept the driver in your system.
  	  System.setProperty("webdriver.chrome.driver", "/Users/dondaasian/Downloads/chromedriver");
  	 
  	  // Setting the driver to chrome driver
  	  driver = new ChromeDriver();
  	  // Use get function to navigate to the URL and waits for the components to load.
  	  String url = "https://www.google.com";
  	  driver.get(url);
  	  // Maximize current window.
  	  driver.manage().window().maximize();
  	  // Capturing the title and validating if expected is equal to actual.
  	  String expectedTitle = "Google";
  	  String actualTitle = driver.getTitle();
  	  Assert.assertEquals(actualTitle, expectedTitle);
  	  // Locates the search box web element using className attributes.
  	  WebElement searchBox = driver.findElement(By.name("q"));
  	  // Inputs text into the search box.
  	  searchBox.sendKeys("Litify");
  	  // Click enter.
  	  searchBox.sendKeys(Keys.ENTER);
  	  // Use findElement to search for the href: https://www.litify.com/ - then click on the element.
  	  driver.findElement(By.xpath("//a[@href='https://www.litify.com/']")).click();	
  	  // Create a chain of actions to hover and click on Our Story.
  	  Actions action = new Actions(driver);
  	  WebElement we = driver.findElement(By.xpath("//*[text()='About Litify']"));
  	  action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[text()='Our Story']"))).click().build().perform();
  	  // Validate the click of actions directs to the current URL. 
  	  String URL = driver.getCurrentUrl();
  	  Assert.assertEquals(URL, "https://www.litify.com/about/");
  	  // Find Content Card Div that displays Our Story text.
  	  driver.findElement(By.xpath(".//div[@class='content-card-text']"));
  	  // Find text on the page.
  	  driver.findElement(By.xpath("//*[text()='Our Story']"));
    }
  
  @BeforeMethod
  public void beforeMethod() {
  	  System.out.println("Starting the browser session");
  }
 
  @AfterMethod
  public void afterMethod() {
  	  System.out.println("Closing the browser session");
  	  driver.quit();
  }
}