import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TesteDesafioRegraNegocio {
	
	private WebDriver driver;
	

	@Before
	public void iniciar() {
	
		System.setProperty("webdriver.chrome.driver","c:/Users/Guedes/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();; // inicia o browser em tamanho normal;
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
	}
	
	@After
	public void finalizar() {
	
		driver.quit();
	}
	
	
	
	@Test
	public void deveValidarNomeObrigatorio() {
	
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
			
	}
	
	@Test
	public void deveValidarSobreNomeObrigatorio() {
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("David");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
			
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("David");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Guedes");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();
			
	}
	
	@Test
	public void deveValidarVegetariano() {
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("David");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Guedes");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();
	}
	
	
	
	@Test
	 public void deveValidarEsportistaIndeciso() {
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("David");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Guedes");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
				
		
		WebElement element =  driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByIndex(0);
		combo.selectByIndex(4);
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		
		alert.accept();
		
	}

}