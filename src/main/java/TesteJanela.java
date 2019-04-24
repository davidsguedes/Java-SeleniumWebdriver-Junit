import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteJanela {
	
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
	 public void deveInteragirComJanelaPopupComTitulo() {
	
			
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo popup!");
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo Janela principal");
		
		
	}
	
	
	@Test
	 public void deveInteragirComJanelaPopupSemTitulo() {
	
		
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle()); //pega o id da janela quando não possui o seu valor
		System.out.println(driver.getWindowHandles()); //retorna uma coleção de janelas
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]); //a primeira posição da coleção (0) é a janela principal, por isso, para o popuo, preciso da segunda (1)
		driver.findElement(By.tagName("textarea")).sendKeys("teste pop sem nome");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]); // retorno para a janela principal
		driver.findElement(By.tagName("textarea")).sendKeys("teste pop principal");
				
	}
	

}
