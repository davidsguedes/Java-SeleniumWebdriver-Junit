import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteDesafioRegraNegocioDSL {
	
	private WebDriver driver;
	private DSL dsl;
	private TesteCampoTreinamentoPage page;
	
	@Before
	public void iniciar() {
	
		System.setProperty("webdriver.chrome.driver","c:/Users/Guedes/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();; // inicia o browser em tamanho normal;
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new TesteCampoTreinamentoPage(driver);
		
	}
	
	@After
	public void finalizar() {  
	
		driver.quit();
	}
	
	
	
	@Test
	public void deveValidarNomeObrigatorio() {
		
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.pegaValorAlertaEAceita());
			
	}
	
	@Test
	public void deveValidarSobreNomeObrigatorio() {
		
		page.setNome("David");
		page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.pegaValorAlertaEAceita());
			
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		
		page.setNome("David");
		page.setSobreNome("Guedes");
		page.cadastrar();
		Assert.assertEquals("Sexo eh obrigatorio", dsl.pegaValorAlertaEAceita());
			
	}
	
	@Test
	public void deveValidarVegetariano() {
		
		page.setNome("David");
		page.setSobreNome("Guedes");
		page.selecionaSexoMasculino();
		page.selecionaCarne();
		page.selecionaVegano();
		
		page.cadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.pegaValorAlertaEAceita());

	}
	
	
	
	@Test
	 public void deveValidarEsportistaIndeciso() {
		
		page.setNome("David");
		page.setSobreNome("Guedes");
		page.selecionaSexoMasculino();
		page.selecionaCarne();
		page.setEsporte("Natacao");
		page.setEsporte("O que eh esporte?");
		
		page.cadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.pegaValorAlertaEAceita());
		

		
	}

}