package Main;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
@TestMethodOrder(OrderAnnotation.class)

public class Sanity extends Methods {
	
	@Test
	@Order(1)
	@DisplayName("1) 1st question page opens ")
	public void testQuestion1Page() throws Exception {
		assertTrue(elementAvailiable("question number: 1"));	
	}
	@Test
	@Order(2)
	@DisplayName("2) Insert 1st question, check next page")
	public void Question1Page() throws Exception {
		insertQuestion(0);
		assertTrue(elementAvailiable("Please enter 4 possible answers and Mark the right one!"));
	}
	@Test
	@Order(3)
	@DisplayName("3) Insert answers, check next page")
	public void answer1Page() throws Exception {
		insertAnswers();
		QandA.chooseCorrectAnswer(0);
		assertTrue(elementAvailiable("question number: 2"));
	}
	@Test
	@Order(4)
	@DisplayName("4) Insert 2nd question, check next page")
	public void question2Page() throws Exception {
		insertQuestion(1);
		assertTrue(elementAvailiable("Please enter 4 possible answers and Mark the right one!"));
	}
	@Test
	@Order(5)
	@DisplayName("5) Insert answers, check next page")
	public void answer2Page() throws Exception {
		insertAnswers();
		QandA.chooseCorrectAnswer(1);
		assertTrue(elementAvailiable("question number: 3"));
	}
	@Test
	@Order(6)
	@DisplayName("6) Insert 3rd question, check next page")
	public void question3Page() throws Exception {
		insertQuestion(2);
		assertTrue(elementAvailiable("Please enter 4 possible answers and Mark the right one!"));
	}
	@Test
	@Order(7)
	@DisplayName("7) Insert answers, check next page")
	public void answer3Page() throws Exception {
		insertAnswers();
		QandA.chooseCorrectAnswer(2);
		assertTrue(elementAvailiable("You finished to build the test - lets play!!"));
	}
	@Test
	@Order(8)
	@DisplayName("8) Click on Play button")
	public void playBtnTest()  {
		assertTrue(playBtn());
		assertTrue(elementAvailiable("Test"));

	} 
	@Test
	@Order(9)
	@DisplayName("9) Play Trivia game")
	public void playGame() throws Exception {
		assertEquals("Sucsses",PlayTrivia.playAllRightAnswers());
	}
}

