package br.com.david.guedes.suites;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.david.guedes.core.DriverFactory;
import br.com.david.guedes.test.TesteCadastro;
import br.com.david.guedes.test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteRegrasCadastro.class

})
public class SuiteTeste {
	
	@AfterClass
	public static void FinalizaTudo() {
		DriverFactory.killDriver();
	}

}
