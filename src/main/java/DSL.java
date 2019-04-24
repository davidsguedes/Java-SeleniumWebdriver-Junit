import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	
	//MÉTODOS DA CLASSE testeCampoTreinamento
	
	private WebDriver driver;
	private Alert alert;
	
	
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	


	public void preencheCampoTextField(String id_campo, String texto) {
		
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	
	public String pegaValorCampoTextField(String id_campo) {
	
		return driver.findElement(By.id(id_campo)).getAttribute("value");
		
	}
	
	
	public void clicaRadioButton(String id_campo) {
		
		driver.findElement(By.id(id_campo)).click();
	}
	
	
	public boolean radioButtonMarcada (String id_campo) {
		
		return driver.findElement(By.id(id_campo)).isSelected();
	}
	
	
	public void selecionaCombo(String id, String valor) {

		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
		
	}
	
	public String pegaValorCombo (String id) {
		
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void clicaBotao(String id) {
		
		driver.findElement(By.id(id)).click();
	}
	
	
	public void clicaLink (String text) {
		
		driver.findElement(By.linkText(text)).click();
		
	}
	
	
	public String pegaValorLink (By by) {
		
		return driver.findElement(by).getText();
		
	}
	
	
	public String pegaValorLink (String id) {
		
		return pegaValorLink(By.id(id));
		
	}
	
	public void mudaFocoParaAlerta() {
		
		alert = driver.switchTo().alert();
		
	}
	
	public String pegaValorAlertaEAceita () {
		
		alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	
	}
	
	
	
}
