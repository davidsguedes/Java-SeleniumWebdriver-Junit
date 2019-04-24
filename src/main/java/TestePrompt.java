import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class TestePrompt {
	
	
private WebDriver driver;
	
	@Before
	public void inicializa() {
	
		System.setProperty("webdriver.chrome.driver","c:/Users/Guedes/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();; // inicia o browser em tamanho normal;
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	
	
	
	@Test
	public void deveInteragirComPrompt() {
	
		driver.findElement(By.id("prompt")).click();
		
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Digite um numero", alert.getText());
		
		alert.sendKeys("12");
		alert.accept();
		
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
				
	}

}
