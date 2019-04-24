import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteDesafioCadastroComSucessoDSL {
	
	private WebDriver driver;
	private DSL dsl;
	private TesteCampoTreinamentoPage page;
	
	
	@Before
	public void inicia() {
		
		System.setProperty("webdriver.chrome.driver","c:/Users/Guedes/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(100, 00));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new TesteCampoTreinamentoPage(driver);
		
		
	}
	
	@After
	public void finaliza() {
		driver.quit();
		
	}
	
	
	@Test
	public void devePreencherNovoCadastroComSucesso() {
		
		page.setNome("David");
		Assert.assertEquals("David", page.obterNomeCadastro());
		
		
		page.setSobreNome("Guedes");
		Assert.assertEquals("Guedes", page.obterSobreNomeCadastro());
		
		page.selecionaSexoMasculino();
		Assert.assertEquals("M", page.obterSexoCadastro());
		Assert.assertTrue(dsl.radioButtonMarcada("elementosForm:sexo:0"));
		
		page.selecionaCarne();
		Assert.assertEquals("carne", page.obterComidaCarneCadastro());
		Assert.assertTrue(dsl.radioButtonMarcada("elementosForm:comidaFavorita:0"));
		
		page.selecionaPiza();
		Assert.assertEquals("pizza", page.obterComidaPizzaCadastro());
		Assert.assertTrue(dsl.radioButtonMarcada("elementosForm:comidaFavorita:2"));
		
		page.selecionaEscolaridadeMestrado("Mestrado"); 
		Assert.assertEquals("Mestrado", page.obterEscolaridadeMestradoCadastro());
		
		page.setEsporte("Natacao");
					
		
		page.cadastrar();
		
		
		
		
		
		
		
		
		
		
		
		
	}

	

}
