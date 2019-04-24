import org.openqa.selenium.WebDriver;

public class TesteCampoTreinamentoPage {

	//classe para implementar padrão pageObject
	// classes que estão utilizando esse padrão
		//TesteDesafioCadastroComSucessoDSL
		//
	
	private DSL dsl;
	
	public TesteCampoTreinamentoPage(WebDriver driver) {
		dsl  = new DSL(driver);
	}
	


	public void setNome(String nome) {
		
		dsl.preencheCampoTextField("elementosForm:nome", nome);
	}
	
	
	public void setSobreNome(String nome) {
		
		dsl.preencheCampoTextField("elementosForm:sobrenome", nome);
	}
	
	public void selecionaSexoMasculino() {
		
		dsl.clicaRadioButton("elementosForm:sexo:0");
	}
	
public void selecionaSexoFeminino() {
		
		dsl.clicaRadioButton("elementosForm:sexo:1");
	}
	
	
	
	public void selecionaCarne() {
		
	dsl.clicaBotao("elementosForm:comidaFavorita:0");
	}
	
	public void selecionaPiza() {
		
		dsl.clicaBotao("elementosForm:comidaFavorita:2");
	}
	
	
	public void selecionaVegano() {
		
		dsl.clicaBotao("elementosForm:comidaFavorita:3");
	}
	
	
	public void selecionaEscolaridadeMestrado (String escolaridade) {
		dsl.selecionaCombo("elementosForm:escolaridade", escolaridade);
	}
	
	
	public void setEsporte(String modalidade) {
		dsl.selecionaCombo("elementosForm:esportes", modalidade);
	}
	
	
//	public void setEsporte(String... modalidade) {
//		for (String modalidades: modalidade)		
//			dsl.selecionaCombo("elementosForm:esportes", modalidades);
//	}
	
	
	
	public void cadastrar() {
		dsl.clicaBotao("elementosForm:cadastrar");
	}
	
	public String obterNomeCadastro() {
		return dsl.pegaValorCampoTextField("elementosForm:nome");
	}
	
	public String obterSobreNomeCadastro() {
		return dsl.pegaValorCampoTextField("elementosForm:sobrenome");
	}
	
	public String obterSexoCadastro() {
		return dsl.pegaValorCampoTextField("elementosForm:sexo:0");
	}
	
	public String obterComidaCarneCadastro() {
		return dsl.pegaValorCampoTextField("elementosForm:comidaFavorita:0");
	}

	public String obterComidaPizzaCadastro() {
		return dsl.pegaValorCampoTextField("elementosForm:comidaFavorita:2");
	}

	public String obterEscolaridadeMestradoCadastro() {
		return dsl.pegaValorCombo("elementosForm:escolaridade");
	}
	
	
	
}
