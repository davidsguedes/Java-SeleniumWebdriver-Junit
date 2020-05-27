package br.com.david.guedes.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	//private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	private DriverFactory() {
	}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		
		WebDriver driver= null;
		
		switch (Propriedades.browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "c:/Users/Guedes/driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "c:/Users/Guedes/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		default:
			break;
		}	
			
		driver.manage().window().setSize(new Dimension(1200, 765));

		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if(driver!=null){
		driver.quit();
		driver=null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
	

}