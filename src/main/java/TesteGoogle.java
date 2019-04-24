import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

	
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
	public void test() {
		
		//System.setProperty("webdriver.gecko.driver","c:/Users/Guedes/driver/geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver","c:/Users/Guedes/driver/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().setPosition(new Point(100, 00)); //define posição da tela qundo inicia o browser do teste. É sempre com referência ao canto superior esquero.
		//driver.manage().window().setSize(new Dimension(1200, 765)); //define tamanho da tela;
		//driver.manage().window().fullscreen(); // inicia o browser em tela cheia;
		//driver.manage().window().maximize();; // inicia o browser em tamanho normal;
		driver.get("http://www.google.com.br");;
		//System.out.println(webdriver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		//driver.quit(); //encerra todas as abas e estancias do driver;
		//driver.close(); //encerra somente a aba atual
	}
	
}
