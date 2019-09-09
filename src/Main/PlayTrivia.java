package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlayTrivia extends Methods{

	//Play Trivia game with all the right answers, choosing answers from correct answers array
	public static String playAllRightAnswers() throws Exception  { 
		WebElement answer;
		answer=driver.findElement(By.xpath("//*[@id=\"2\"]/h3"));
		for(int i=0;i<3;i++) {
			if (answer.getText().toString().equals(QandA.getQuestion(i))) {
				switch (QandA.correctAnswer[i]) {
				case 1:
					driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]")).click();
					break;
				case 2:
					driver.findElement(By.xpath("//*[@id=\"2\"]/input[2]")).click();
					break;
				case 3: 
					driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]")).click();
					break;
				case 4: 
					driver.findElement(By.xpath("//*[@id=\"2\"]/input[4]")).click();
					break;
				default:
				}
			}
		}
		Methods.clickNextBtnGame();

		answer=driver.findElement(By.xpath("//*[@id=\"1\"]/h3"));
		for(int j=0;j<3;j++) {
			if (answer.getText().toString().equals(QandA.getQuestion(j))) {
				switch (QandA.correctAnswer[j]) {
				case 1:
					driver.findElement(By.xpath("//*[@id=\"1\"]/input[1]")).click();
					break;
				case 2: 
					driver.findElement(By.xpath("//*[@id=\"1\"]/input[2]")).click();
					break;
				case 3: 
					driver.findElement(By.xpath("//*[@id=\"1\"]/input[3]")).click();
					break;
				case 4: 
					driver.findElement(By.xpath("//*[@id=\"1\"]/input[4]")).click();
					break;
				default:
					System.out.println("No correct answer found. ");
				}
			}
		}
		Methods.clickNextBtnGame();
		answer=driver.findElement(By.xpath("//*[@id=\"0\"]/h3"));
		for(int k=0;k<3;k++) {
			if (answer.getText().toString().equals(QandA.getQuestion(k))) {
				switch (QandA.correctAnswer[k]) {
				case 1:
					driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]")).click();
					break;
				case 2: 
					driver.findElement(By.xpath("//*[@id=\"0\"]/input[2]")).click();
					break;
				case 3: 
					driver.findElement(By.xpath("//*[@id=\"0\"]/input[3]")).click();
					break;
				case 4: 
					driver.findElement(By.xpath("//*[@id=\"0\"]/input[4]")).click();

					break;
				default:
					System.out.println("No correct answer found. ");
				}
			}
		}
		Methods.clickNextBtnGame();
		String finishGame = driver.findElement(By.id("mark")).getText();
		return finishGame;

	}

	//Play Trivia game with wrong answers, choosing answers from wrong answers array

	public static String playWrongAnswers() throws Exception  { 
		WebElement answer=driver.findElement(By.xpath("//*[@id=\"2\"]/h3"));
		for(int i=0;i<3;i++) {
			if (answer.getText().toString().equals(QandA.getQuestion(i))) {
				switch (QandA.wrongAnswer[i]) {
				case 1:
					driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]")).click();
					break;
				case 2: 
					driver.findElement(By.xpath("//*[@id=\"2\"]/input[2]")).click();
					break;
				case 3: 
					driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]")).click();
					break;
				case 4: 
					driver.findElement(By.xpath("//*[@id=\"2\"]/input[4]")).click();
					break;
				default:
				}
			}
		}
		Methods.clickNextBtnGame();
		answer=driver.findElement(By.xpath("//*[@id=\"1\"]/h3"));
		for(int j=0;j<3;j++) {
			if (answer.getText().toString().equals(QandA.getQuestion(j))) {
				switch (QandA.wrongAnswer[j]) {
				case 1:
					driver.findElement(By.xpath("//*[@id=\"1\"]/input[1]")).click();
					break;
				case 2: 
					driver.findElement(By.xpath("//*[@id=\"1\"]/input[2]")).click();
					break;
				case 3: 
					driver.findElement(By.xpath("//*[@id=\"1\"]/input[3]")).click();
					break;
				case 4: 
					driver.findElement(By.xpath("//*[@id=\"1\"]/input[4]")).click();
					break;
				default:
					System.out.println("No correct answer found. ");
				}
			}
		}
		Methods.clickNextBtnGame();
		answer=driver.findElement(By.xpath("//*[@id=\"0\"]/h3"));
		for(int k=0;k<3;k++) {
			if (answer.getText().toString().equals(QandA.getQuestion(k))) {
				switch (QandA.wrongAnswer[k]) {
				case 1:
					driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]")).click();
					break;
				case 2: 
					driver.findElement(By.xpath("//*[@id=\"0\"]/input[2]")).click();
					break;
				case 3: 
					driver.findElement(By.xpath("//*[@id=\"0\"]/input[3]")).click();
					break;
				case 4: 
					driver.findElement(By.xpath("//*[@id=\"0\"]/input[4]")).click();
					break;
				default:
					System.out.println(" No correct answer found. ");
				}
			}
		}
		Methods.clickNextBtnGame();
		String finishGame = driver.findElement(By.id("mark")).getText();
		return finishGame;
	}

}
