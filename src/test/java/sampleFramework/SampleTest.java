package sampleFramework;

import java.lang.annotation.Annotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class SampleTest{
  WebDriver driver;
  @BeforeTest
  public void setup() {
	  driver = new FirefoxDriver();
  }
  
  @AfterTest
  public void tearDown() {
	//Close the browser
      driver.quit();
  }
  
  @Test
  public void SearchAssistTest() throws InterruptedException {
	  
	  driver.get("http://www.google.com");
      // Alternatively the same thing can be done like this
      // driver.navigate().to("http://www.google.com");
	  WebElement eleSearchBox = driver.findElement(By.xpath(".//*[@id='gs_htif0']"));
     
	  eleSearchBox.sendKeys("Cheese!");
      Thread.sleep(5000);
     
      // Now submit the form. WebDriver will find the form for us from the element
      WebElement eleSearchBtn = driver.findElement(By.xpath(".//*[@id='gbqfb']"));
      eleSearchBtn.click();
      Thread.sleep(5000);

      //Select mySelect = new Select(element);
      //mySelect.
      // Check the title of the page
      System.out.println("Page title is: " + driver.getTitle());
      
      // Google's search is rendered dynamically with JavaScript.
      // Wait for the page to load, timeout after 10 seconds
     assert(driver.getTitle().contains("Cheese"));

      // Should see: "cheese! - Google Search"
      System.out.println("Page title is: " + driver.getTitle());
  }
}
