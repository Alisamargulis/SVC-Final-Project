package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;

import Main.Methods;
import Main.PlayTrivia;
import Main.QandA;
@TestMethodOrder(OrderAnnotation.class)

class FunctionalityTestCase4Test extends Methods {


	@BeforeAll
	public static void openChromeDriverCase4() throws Exception {
		setUpChrome();
		openTrivia();
		clickStartBtn();
		QandA.setSanity();

	}

	@AfterAll
	public static void closeChromeDriver() throws InterruptedException {
		tearDown();
	}

	@Test
	@Order(1)
	@DisplayName("1) Test question mark")
	void testQuestionMark1() throws Exception {

		QandA.setAllRightQA();
		assertTrue(questionMark(driver.findElement(By.xpath("//*[@id=\"2\"]/h3"))));

	}

	@Test
	@Order(2)
	@DisplayName("2) Test question mark")
	void testQuestionMark2() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]")).click();
		clickNextBtnGame();
		assertTrue(questionMark(driver.findElement(By.xpath("//*[@id=\"1\"]/h3"))));

	}

	@Test
	@Order(3)
	@DisplayName("3) Test question mark")
	void testQuestionMark3() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]")).click();
		clickNextBtnGame();
		driver.findElement(By.xpath("//*[@id=\"1\"]/input[1]")).click();
		clickNextBtnGame();
		assertTrue(questionMark(driver.findElement(By.xpath("//*[@id=\"0\"]/h3"))));

	}

	@Test
	@Order(4)
	@DisplayName("4) Test Try Again button")
	void tryAgainBtnTest() throws Exception {
		QandA.setAllRightQA();
		PlayTrivia.playAllRightAnswers();
		assertTrue(tryAgainBtn());
	}

	@Test
	@Order(5)
	@DisplayName("5) Test Quit button on last page")
	void quitBtn2() throws Exception  {
		PlayTrivia.playAllRightAnswers();
		assertTrue(quitBtn(),"Quit button : ");
	}
}