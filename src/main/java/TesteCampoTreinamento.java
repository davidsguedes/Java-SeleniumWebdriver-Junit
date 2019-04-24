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

public class TesteCampoTreinamento {

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
	 public void TestTextField() {
	
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita no campo"); //procura um elemento pelo seu id e escreve nele
		//driver.findElement(By.id("elementosForm:nome")).getAttribute("value"); //procura um elemento pelo seu id e pega o seu valor
		Assert.assertEquals("Teste de escrita no campo", driver.findElement(By.id("elementosForm:nome")).getAttribute("value")); //verifica numa assertiva o valor esperado x enviado
	}
	
	
	@Test
	 public void deveInteragirComTextArea() {
	
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de escrita no textarea"); //procura um elemento pelo seu id e escreve nele \\no textarea é possível escrever com mais linhas utilizando \n
		//driver.findElement(By.id("elementosForm:nome")).getAttribute("value"); //procura um elemento pelo seu id e pega o seu valor
		Assert.assertEquals("Teste de escrita no textarea", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value")); //verifica numa assertiva o valor esperado x enviado
				
		
	}
	
	
	@Test
	 public void deveInteragirComRadioButton() {
	
		driver.findElement(By.id("elementosForm:sexo:0")).click(); //encontra o elemento radiobutton e clica nele
		//driver.findElement(By.id("elementosForm:sexo:0")).isSelected(); //vai verificar se o elemento está marcado
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected()); //assertiva (verificação)
			
		
	}
	
	
	@Test
	 public void deveInteragirComCheckbox() {
	
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click(); 
		//driver.findElement(By.id("elementosForm:sexo:0")).isSelected(); //vai verificar se o elemento está marcado
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected()); //assertiva (verificação)

	}
	
	@Test
	 public void deveInteragirComCombo() {
	
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade")); //encontra o elemento radiobutton e clica nele
		Select combo = new Select(element);
		//combo.selectByIndex(2); //começa do 0
		//combo.selectByValue("2grauincomp"); //devo inspecionar o value do elemento
		combo.selectByVisibleText("Mestrado"); //exatamente como mostrado em tela para o usuario
		//combo.getFirstSelectedOption().getText() //pega o valor (texto) que selecionei
		Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());

		
	}
	
	
	@Test
	 public void deveVerificarValoresCombo() {
	
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade")); //encontra o elemento radiobutton e clica nele
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions(); //Ctrl + 1 associa o retorno da variavel
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		
		for (WebElement option: options) { //o for verificará todas as opções da combo até que seja encontrada a opção marcada
			
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}		
		}
		Assert.assertTrue(encontrou);

	}
	
	
	@Test
	 public void deveVerificarValoresComboMultiplo() {
	
		WebElement element = driver.findElement(By.id("elementosForm:esportes")); //encontra o elemento combo multipla escolha
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
			
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		
		combo.deselectByVisibleText("Natacao");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
	}
	
	
	@Test
	 public void deveInteragirComBotoes() {
	
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

	}
	
	
	@Test
	//@Ignore //para ignorar o teste quando está incompleto
	 public void deveInteragirComLinks() {
	
		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		//Assert.fail(); //usado quando não quero que o teste unitario dê barra verde. Pois mais que possua a anotação @Ignore, é importante fazer isso.
		
	}
	
	
	@Test
	//@Ignore //para ignorar o teste quando está incompleto
	 public void deveBuscarTextosNaPagina() {
	
		//driver.findElement(By.tagName("body")); //busca traz todo o texto dentro da tag body da página
		//System.out.println(driver.findElement(By.tagName("body")).getText()); //busca traz todo o texto dentro da tag body da página e imprime no console
		
		//a opção a seguir não é a mais performática, pois varre todo o conteúdo do body para então encontrar uma string. Também não é possível identificar onde o elemento está em relação à página.
		//Assert.assertTrue(driver.findElement(By.tagName("body")).
		//getText().contains("Campo de Treinamento")); //vai encontrar o valor que quero identificar dentro do body
		
		Assert.assertEquals("Campo de Treinamento",driver.findElement(By.tagName("h3")).getText()); //identificada a tag mais próxima do elemento que se quer achar
		
		//Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",driver.findElement(By.tagName("span")).getText()); //pode ocorrer de um elemento a ser buscado possuir uma mesma tag que outro. Vai ocorrer erro caso isso ocorra.
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",driver.findElement(By.className("facilAchar")).getText());
		
	}
	
	
}
