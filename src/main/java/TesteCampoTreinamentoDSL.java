import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamentoDSL {

	private WebDriver driver;
	private DSL dsl;	
	
	
	@Before
	public void inicializa() {
	
		System.setProperty("webdriver.chrome.driver","c:/Users/Guedes/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();; // inicia o browser em tamanho normal;
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	 public void TestTextField() {
	
		dsl.preencheCampoTextField("elementosForm:nome", "Teste de escrita no campo");
		Assert.assertEquals("Teste de escrita no campo", dsl.pegaValorCampoTextField("elementosForm:nome"));
				
				//driver.findElement(By.id("elementosForm:nome")).getAttribute("value")); //verifica numa assertiva o valor esperado x enviado
	}
	
	
	@Test
	 public void deveInteragirComTextArea() {
	
		dsl.preencheCampoTextField("elementosForm:sugestoes", "Teste de escrita no textarea");
		Assert.assertEquals("Teste de escrita no textarea", dsl.pegaValorCampoTextField("elementosForm:sugestoes"));
				
		
	}
	
	
	@Test
	 public void deveInteragirComRadioButton() {
		
		dsl.clicaRadioButton("elementosForm:sexo:0");
		Assert.assertTrue(dsl.radioButtonMarcada("elementosForm:sexo:0")); //assertiva (verifica��o)
			
		
	}
	
	
	@Test
	 public void deveInteragirComCheckbox() { 
		
		dsl.clicaRadioButton("elementosForm:comidaFavorita:0");
		Assert.assertTrue(dsl.radioButtonMarcada("elementosForm:comidaFavorita:0")); //assertiva (verifica��o) utilizei a mesma assertiva de radiobutton pois a verifica��o � igual

	}
	
	@Test
	 public void deveInteragirComCombo() {
		
		dsl.selecionaCombo("elementosForm:escolaridade", "Mestrado");
		Assert.assertEquals("Mestrado", dsl.pegaValorCombo("elementosForm:escolaridade"));

		
	}
	
	
	@Test
	 public void deveVerificarValoresCombo() {
	
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade")); //encontra o elemento radiobutton e clica nele
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions(); //Ctrl + 1 associa o retorno da variavel
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		
		for (WebElement option: options) { //o for verificar� todas as op��es da combo at� que seja encontrada a op��o marcada
			
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}		
		}
		Assert.assertTrue(encontrou);

	}
	
	
	@Test
	 public void deveVerificarValoresComboMultiplo() {
		
		dsl.selecionaCombo("elementosForm:esportes", "Natacao");
		dsl.selecionaCombo("elementosForm:esportes", "Corrida");
		dsl.selecionaCombo("elementosForm:esportes", "O que eh esporte?");
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes")); //encontra o elemento combo multipla escolha
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		
		combo.deselectByVisibleText("Natacao");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
	}
	
	
	@Test
	 public void deveInteragirComBotoes() {
		
		dsl.clicaBotao("buttonSimple");
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

	}
	
	
	@Test
	//@Ignore //para ignorar o teste quando est� incompleto
	 public void deveInteragirComLinks() {
		
		
		dsl.clicaLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.pegaValorLink("resultado"));
		//Assert.fail(); //usado quando n�o quero que o teste unitario d� barra verde. Pois mais que possua a anota��o @Ignore, � importante fazer isso.
		
	}
	
	
	@Test
	//@Ignore //para ignorar o teste quando est� incompleto
	 public void deveBuscarTextosNaPagina() {
	
		//driver.findElement(By.tagName("body")); //busca traz todo o texto dentro da tag body da p�gina
		//System.out.println(driver.findElement(By.tagName("body")).getText()); //busca traz todo o texto dentro da tag body da p�gina e imprime no console
		
		//a op��o a seguir n�o � a mais perform�tica, pois varre todo o conte�do do body para ent�o encontrar uma string. Tamb�m n�o � poss�vel identificar onde o elemento est� em rela��o � p�gina.
		//Assert.assertTrue(driver.findElement(By.tagName("body")).
		//getText().contains("Campo de Treinamento")); //vai encontrar o valor que quero identificar dentro do body
		
		Assert.assertEquals("Campo de Treinamento", dsl.pegaValorLink(By.tagName("h3"))); //identificada a tag mais pr�xima do elemento que se quer achar
		
		//Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",driver.findElement(By.tagName("span")).getText()); //pode ocorrer de um elemento a ser buscado possuir uma mesma tag que outro. Vai ocorrer erro caso isso ocorra.
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.pegaValorLink(By.className("facilAchar")));
		
	}
	
	
}
