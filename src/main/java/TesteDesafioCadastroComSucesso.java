import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteDesafioCadastroComSucesso {
	
	@Test
	public void devePreencherNovoCadastro() {
		
		System.setProperty("webdriver.chrome.driver","c:/Users/Guedes/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(100, 00));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("David");
		Assert.assertEquals("David", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		
		
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Guedes");
		Assert.assertEquals("Guedes", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
		
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertEquals("M", driver.findElement(By.id("elementosForm:sexo:0")).getAttribute("value"));
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Assert.assertEquals("carne", driver.findElement(By.id("elementosForm:comidaFavorita:0")).getAttribute("value"));
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		
		
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertEquals("pizza", driver.findElement(By.id("elementosForm:comidaFavorita:2")).getAttribute("value"));
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		
		
		WebElement escolaridade  = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo1 = new Select(escolaridade);
		combo1.selectByVisibleText("Mestrado");
		Assert.assertEquals("Mestrado", combo1.getFirstSelectedOption().getText());
		
		
		
		WebElement esportes  = driver.findElement(By.id("elementosForm:esportes"));
		
		Select combo2 = new Select(esportes);
		combo2.selectByVisibleText("Natacao");
		combo2.selectByVisibleText("Futebol");
		
		List<WebElement> allSelectedOptions = combo2.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
	}

	

}
