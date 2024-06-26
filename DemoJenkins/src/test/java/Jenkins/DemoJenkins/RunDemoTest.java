package Jenkins.DemoJenkins;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunDemoTest {

	@Test
	public void runMyTest() throws InterruptedException, MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setBrowserName("chrome");
		//cap.setBrowserName("firefox");
		cap.setBrowserName("MicrosoftEdge");
		cap.setPlatform(Platform.UNIX);
		//ChromeOptions option = new ChromeOptions();
		//FirefoxOptions option = new FirefoxOptions();
		EdgeOptions option = new EdgeOptions();
		option.merge(cap);
        option.addArguments("--headless");
        option.addArguments("--disable-gpu");
        option.addArguments("--window-size=1920,1200");
        option.addArguments("--ignore-certificate-errors");      
        option.addArguments("--silent");
        option.addArguments("--remote-allow-origin=*");
        
		String hubURL = "http://65.2.3.215:4444";
		WebDriver driver = new RemoteWebDriver(new URL(hubURL), option);
		driver.get("https://www.google.com");
		WebElement googleSearchBar = driver.findElement(By.cssSelector("#APjFqb"));
		WebElement googleFeelBtn = driver.findElement(RelativeLocator.with(By.tagName("input")).below(googleSearchBar));
		googleFeelBtn.click();
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		//Assert.assertEquals(driver.getCurrentUrl(), "Testdata");
		System.out.println("Hello JENKINS I am here.....");
		driver.quit();

	}
	
	

}
