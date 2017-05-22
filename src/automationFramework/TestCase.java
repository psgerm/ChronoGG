package automationFramework;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

public class TestCase {


	
	public static void main(String[] args) throws InterruptedException {
		
		Properties prop = new Properties();
		InputStream input = null;
		String chromeDriverPath = null;
		String user = null;
		String pass=null;
		input = Main.class.getResourceAsStream("aplication.properties"); 
				//getClass().getClassLoader().getResourceAsStream("aplication.properties");
		
	    // load a properties file
		try {
			prop.load(input);
			chromeDriverPath = prop.getProperty("chromeDriverPath");
			user = prop.getProperty("user");
			pass = prop.getProperty("pass");
		}catch (Exception ex){
			
		}
	    
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--kiosk");
		WebDriver driver = new ChromeDriver(options);

		//Carga la web
		driver.get("https://chrono.gg/");
		
		// Print a Log In message to the screen
        System.out.println("Successfully opened the website ChronoGG");

		driver.findElement(By.xpath(".//*[@id='react']/div/div[1]/header/div/nav[2]/ul/li[3]/a")).click();
		
		
		WebElement userInput = driver.findElement(By.xpath(".//*[@id='signin-email']"));
		userInput.sendKeys(user);
		
		WebElement passInput = driver.findElement(By.xpath(".//*[@id='signin-password']"));
		passInput.sendKeys(pass);
		
		
		WebElement login = driver.findElement(By.xpath(".//*[@id='react-tabs-1']/form/div[2]/button"));
		login.click();
		
		WebElement coinButton = driver.findElement(By.xpath(".//*[@id='reward-coin']/div[1]"));
		coinButton.click();
		
		//Wait for 5 Sec		
		Thread.sleep(30);
		
        // Close the driver
        driver.quit();
	}

}
