package Jenkins.DemoJenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunDemoTest {

	@Test
	public void runMyTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement googleSearchBar = driver.findElement(By.cssSelector("#APjFqb"));
		WebElement googleFeelBtn = driver.findElement(RelativeLocator.with(By.tagName("input")).below(googleSearchBar));
		googleFeelBtn.click();
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		//Assert.assertEquals(driver.getCurrentUrl(), "Testdata");
		System.out.println("Hello JENKINS.....");
		driver.quit();
	}
	
	

}
