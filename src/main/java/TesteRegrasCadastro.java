import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
	
	
	private WebDriver driver;
	private DSL dsl;
	private TesteCampoTreinamentoPage page;
	
	
	@Parameter
	public String nome;
	
	@Parameter(value=1)
	public String sobrenome;
	
	@Parameter(value=2)
	public String sexo;
	
	@Parameter(value=3)
	public List<String> comidas;
	
//	@Parameter(value=4)
//	public String[] esportes;
//	
	@Parameter(value=4)
	public String esporte;
	
	@Parameter(value=5)
	public String msg;
	
	@Before
	public void iniciar() {
	
		System.setProperty("webdriver.chrome.driver","c:/Users/Guedes/driver/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();; // inicia o browser em tamanho normal;
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new TesteCampoTreinamentoPage(driver);
		
	}
	
	@After
	public void finalizar() {  
	
		driver.quit();
	}
	
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {

//			{"", "", "", Arrays.asList(), new String[]{},"Nome eh obrigatorio"},
//			{"David", "", "", Arrays.asList(), new String[]{},"Sobrenome eh obrigatorio"},			
//			{"David", "Guedes", "", Arrays.asList(), new String[]{},"Sexo eh obrigatorio"},
//			{"David", "Guedes", "Masculino", Arrays.asList("Carne","Vegetariano"), new String[]{},"Tem certeza que voce eh vegetariano?"},
//			{"David", "Guedes", "Masculino", Arrays.asList("Vegetariano"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
			
			
			{"", "", "", Arrays.asList(), "","Nome eh obrigatorio"},
			{"David", "", "", Arrays.asList(), "","Sobrenome eh obrigatorio"},
			{"David", "Guedes", "", Arrays.asList(), "","Sexo eh obrigatorio"},
			{"David", "Guedes", "Masculino", Arrays.asList("Carne","Vegetariano"), "","Tem certeza que voce eh vegetariano?"},
//			{"David", "Guedes", "Masculino", Arrays.asList("Vegetariano"), "Karate", "O que eh esporte?", "Voce faz esporte ou nao?"}

			
		});
	}
	
	
	
	@Test
	 public void deveValidarRegrasDeCadastro() {
		
		page.setNome(nome);
		page.setSobreNome(sobrenome);
		
		if(sexo.equals("Masculino")) {
			page.selecionaSexoMasculino();
		}
		if(sexo.equals("Feminino")) {
			page.selecionaSexoFeminino();
		}
		
		
		if(comidas.contains("Carne")) page.selecionaCarne();
		if(comidas.contains("Pizza")) page.selecionaPiza();
		if(comidas.contains("Vegetariano"))page.selecionaVegano();
		 
		if(!esporte.isEmpty()) {
			page.setEsporte(esporte);
		}
		
		//page.setEsporte(esportes);
		//page.setEsporte(esporte2);
		page.cadastrar();
		System.out.println(msg);

		Assert.assertEquals(msg, dsl.pegaValorAlertaEAceita());
		

		
	}
	
	

}
