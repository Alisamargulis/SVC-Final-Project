package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import Main.Methods;
import Main.QandA;
@TestMethodOrder(OrderAnnotation.class)

public class FunctionalityTestCase3 extends Methods{

	@BeforeAll
	//Setup Chrome and start Trivia web page
	public static void openChromeDriver() throws Exception {
		setUpChrome();
		openTrivia();
		clickStartBtn();
		QandA.setSanity();
	}

	@AfterAll
	public static void disposeBrowser() {
		closeDriver();
	}

	@Test
	@Order(1)
	@DisplayName("1) Check radio buttons- answer page 1")
	void radiocheck1() throws Exception {
		insertQuestion(0);
		assertFalse(radioIsChecked());
	}

	@Test
	@Order(2)
	@DisplayName("2) Back button 1")
	void back1() throws Exception  {	
		clickBackBtn();
		assertTrue(elementAvailiable("question number: 1"));
		clickNextBtn();	
		insertAnswers();
		QandA.chooseCorrectAnswer(0);
		clickNextBtn();	// Open question 2 page
	} 

	@Test
	@Order(3)
	@DisplayName("3) Back button 2")
	void back2() throws Exception {
		clickBackBtn();
		clickNextBtn();	// Open question 2
		insertQuestion(1);// Next to answer page 2
		assertTrue(Methods.elementAvailiable("question number: 2")); 
	}

	@Test
	@Order(4)
	@DisplayName("4) Check radio buttons- answer page 2")
	void radioCheck2() throws Exception {
		assertFalse(radioIsChecked()); // Answers 2 check radio buttons
	}

	@Test
	@Order(5)
	@DisplayName("5) Back button 3")
	void back3() throws Exception  {
		clickBackBtn(); // Back to question 2
		assertTrue(elementAvailiable("question number: 2"));
		clickNextBtn();	// Open answers 2
		insertAnswers(); // Submit answers 2
		QandA.chooseCorrectAnswer(1);
		clickNextBtn();	// Open question 3
	} 

	@Test
	@Order(6)
	@DisplayName("6) Back button 4")
	void back4() throws Exception {
		clickBackBtn(); // Back to answers 2
		assertTrue(elementAvailiable("question number: 2")); //answers page 2 opens
		clickNextBtn();	// Open question 3
	}

	@Test
	@Order(7)
	@DisplayName("7) Check radio buttons- answer page 3")
	void radioCheck3() throws Exception {
		insertQuestion(2);// Next to answer page 3
		assertFalse(radioIsChecked()); //Answers 3 check radio buttons
	}

	@Test
	@Order(8)
	@DisplayName("8) Back button 5")
	void back5() throws Exception  {
		clickBackBtn(); //Back to question 3
		assertTrue(elementAvailiable("question number: 3"));
	}

	@Test
	@Order(9)
	@DisplayName("9)Let's Play Trivia page")
	void letsPlay() throws Exception  {
		clickNextBtn();	//Open answers 3 page
		insertAnswers(); //Submit answers 3
		QandA.chooseCorrectAnswer(2);
		assertTrue(elementAvailiable("You finished to build the test - lets play!!"));
	}

	@Test
	@Order(10)
	@DisplayName("10) Quit button")
	void quitBtn1() throws Exception  {
		assertTrue(quitBtn(),"Quit button : ");
	}



}



