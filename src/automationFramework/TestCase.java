package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCase {

	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://chrono.gg/");
		//WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
		System.setProperty("webdriver.chrome.driver", "C:/Users/GNPZ/Documents/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--kiosk");
		WebDriver driver = new ChromeDriver(options);
		//WebDriver driver = new RemoteWebDriver(DesiredCapabilities.chrome());
		driver.get("https://chrono.gg/");
		// Print a Log In message to the screen
        System.out.println("Successfully opened the website ChronoGG");
      //*[@id="react"]/div/div[1]/header/div/nav[2]/ul/li[3]/a
		//Wait for 5 Sec

		
		//WebElement signin =	driver.findElement(By.xpath("//input[@value='react']"));
		WebElement signin =	driver.findElement(By.id("react"));
		
		signin.click();
		
		Thread.sleep(30);
        // Close the driver
        driver.quit();
	}

}
