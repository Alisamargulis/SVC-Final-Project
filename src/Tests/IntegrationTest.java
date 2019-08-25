package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Main.Methods;
import Main.PlayTrivia;
import Main.QandA;

class IntegrationTest {

	@BeforeAll
	public static void openChromeDriver() throws Exception {
		Methods.setUpChrome();
		Methods.openTrivia();
		Methods.clickStartBtn();
		QandA.setSanity();
		QandA.setAllRightQA();	
		PlayTrivia.playAllRightAnswers();		
	}
	
	@AfterAll
	public static void closeBrowser() {
		Methods.closeDriver();
	}
	
	@Test
	public void faceBookTest() throws Exception  {	
	assertTrue(Methods.facebookBtn());	
	}


}
