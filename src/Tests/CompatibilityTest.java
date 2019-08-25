package Tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import Main.Methods;
import Main.Sanity;
import Main.QandA;

@TestMethodOrder(OrderAnnotation.class)

public class CompatibilityTest extends Sanity {

	
	@BeforeAll
	public static void sanityFireFoxDriver() {
		Methods.setUpFireFox();
		Methods.openTrivia();
		
		QandA.setSanity();
		clickStartBtn();

	}
	
	@AfterAll
	public static void closeTrivia() {
		Methods.tearDown();
	}

}
