package Tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import Main.Methods;
import Main.Sanity;
import Main.QandA;

public class SanityTest extends Sanity {
	
	@BeforeAll
	public static void openChromeDriver() {
		Methods.setUpChrome();
		Methods.openTrivia();
		clickStartBtn();
		QandA.setSanity();
		
	}
	@AfterAll
	public static void closeBrowser() {
		closeDriver();
	}

}