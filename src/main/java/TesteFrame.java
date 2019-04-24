import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrame {
	
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
	 public void deveInteragirComFrame() {
	
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert(); //muda o foco para um alerta que salte a página
		String texto = alert.getText();
		Assert.assertEquals("Frame OK!", texto); //
		alert.accept();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		
		Assert.assertEquals("Frame OK!", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		
		//driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
				
	}
	
	

}
