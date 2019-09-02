package Tests;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;

import Main.Methods;
import Main.PlayTrivia;
import Main.QandA;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class FunctionalityTestCase1_2  {

	static int setupIndex=1;

	@BeforeAll
	public static void openChromeDriver() throws Exception {//setupChrome start Trivia web page
		System.out.println("<--------Start functionality tests: Long_String, Play_wrong_answers--------->");
	}
	
	@BeforeEach
	public void setQuestionAndAnswers() throws Exception {
		Methods.setUpChrome();
		Methods.openTrivia();
		Methods.clickStartBtn();
	}
	
	@AfterEach
	public void afterTestSetUp() throws InterruptedException {
		setupIndex+=1;
		Thread.sleep(5000);
		Methods.tearDown();
	}
	
	@AfterAll
	public void quitDriver() throws InterruptedException {
		System.out.println("<--------Finish functionality test--------->");
	}
	
	@RepeatedTest(4) 
	@DisplayName("Test Case- Insert long_String questions & answers")
	public void testFuncLongString() throws Exception {
		QandA.setGame1(setupIndex); //Set Q&A arrays for test
		
		System.out.println("Start repeated test " + setupIndex);
		String mark="null";
		QandA.setAllRightQA();
		try {
			mark=PlayTrivia.playAllRightAnswers();//Result: string_get success/failed mark
		} catch (NullPointerException e) {
			System.out.println(e.getMessage() + "Not playes all games, didnt get to last page : success");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals("Sucsses",mark);
		System.out.println("End repeat test :" + (setupIndex)+" Expected: Success, Actual: "+ mark);
	}	
	
	@RepeatedTest(7) 
	@DisplayName("Test case- Play wrong answers")
	public void testFuncPlayWrong() throws Exception {
		System.out.println("Start repeated test wrong answer " + (setupIndex-4));
//		QandA.setSanity(); // set Q&A basic
		QandA.setGame1(setupIndex); //Set Q&A arrays for test
		String mark="null";
		QandA.setAllRightQA();
		
		try {
			mark=PlayTrivia.playWrongAnswers();//Result: string_get success/failed mark
		} catch (NullPointerException e) {
			System.out.println(e.getMessage() + "Not playes all games, didnt get to last page : Failed");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("End of repeat test :" + (setupIndex-4) + " Expected: Failed, Actual: "+ mark);
		assertEquals("Failed",mark);
		
	}	

	
	
	
	
	
	
	
}

