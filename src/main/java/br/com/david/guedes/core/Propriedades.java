package br.com.david.guedes.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = false;
	
	static Browsers browser = Browsers.FIREFOX;
	
	public enum Browsers{
		CHROME,
		FIREFOX
	}
	
}
