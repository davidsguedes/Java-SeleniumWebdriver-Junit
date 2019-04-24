import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {
	
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
	 public void deveInteragirComAlertSimples() {
	
		driver.findElement(By.id("alert")).click();
		
		Alert alert = driver.switchTo().alert(); //muda o foco para um alerta que salte a página
		
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto); //
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
