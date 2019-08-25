package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QandA {

	protected static WebDriver driver;

	private static String[] question; //Insert question from array to text field
	//	private static String[] questionMark; //TO DO - CHECK QUESTION MARK!!!

	private static String[] answer; // Array of all 4 answers
	protected static int[] correctAnswer;// Check correct answer radioBtn 1-4
	protected static int[] wrongAnswer;// Check wrong answer radioBtn 1-4

	public QandA(String [] question,String[] answer,int[] correctAnswer) {
		QandA.question=question;
		QandA.answer=answer;
		QandA.correctAnswer=correctAnswer;

	}

	public QandA(int[] wrongAnswer ) {
		QandA.wrongAnswer=wrongAnswer; 	
	}

	public static String getQuestion(int i) {
		return question[i];
	}

	public static String getAnswer(int i) {
		return answer[i];
	}
	public void setQuestion(String[] question) {
		QandA.question = question;
	}

	public void setAnswer(String[] answer) {
		QandA.answer = answer;
	}

	public static int getCorrectAnswer(int i) { //Get the number of the right answer- for checking radio button
		return correctAnswer[i];
	}

	public void setCorrectAnswer(int[] correctAnswer) {
		QandA.correctAnswer = correctAnswer;
	}

	public static int getWrongAnswer(int i) { //Get the number of the wrong answers array - for checking radio button
		return wrongAnswer[i];
	}

	public static void setWrongAnswer(int[] wrongAnswer) {
		QandA.wrongAnswer = wrongAnswer;
	}


	//Check the correct answer radio button after submit answers

	public static void chooseCorrectAnswer(int i) throws Exception   {   
		WebElement [] answerEle=Elements.selectRadioButtonElement();
		switch (correctAnswer[i]) {
		case 1:
			try {
				answerEle[0].click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2: 	
			try {
				answerEle[1].click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3: 	
			try {
				answerEle[2].click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4: 
			try {
				answerEle[3].click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
		}
		Methods.clickNextBtn();
	}	
	//Set Q&A for sanity test 
	
	public static void setSanity() {
		String [] question= {"a","b","c"};
		String [] answer = {"a", "b","c","d"};
		int []  correctAnswer={1,2,3};
		new QandA(question, answer, correctAnswer);
	}

	//Input for creating Question and Answer pages, correct or wrong answers
	
	public static void setGame1(int setupIndex) { 
		switch(setupIndex) {

		case 1://Question length 10 / Answers length 5 / set correct answers to play
			String [] question1= {"aaaaaaaaaa", "bbbbbbbbbb","cccccccccc"};
			String [] answer1 =new String [] {"aaaaa", "bbbbb","ccccc","ddddd"};//5 characters
			int []  correctAnswer1=new int [] {1,2,3};
			new QandA(question1, answer1, correctAnswer1);
			System.out.println("Test: Question length 10 / Answers length 5");
			break;
		case 2://Question length 20 / Answers length 15 / set correct answers to play
			String [] question2= {"aaaaaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbbb","cccccccccccccccccccc"};
			String [] answer2 =new String [] {"aaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbb","ccccccccccccccc","ddddddddddddddd"};//15 characters
			int []  correctAnswer2=new int [] {1,2,3};
			new QandA(question2, answer2, correctAnswer2);
			System.out.println("Test: Question length 20 / Answers length 15");
			break;

		case 3://Question length 30 / Answers length 20 / set correct answers to play
			String [] question3= {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb","cccccccccccccccccccccccccccccc"};
			String [] answer3 =new String [] {"aaaaaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbbb","cccccccccccccccccccc","dddddddddddddddddddd"};//20 characters
			int []  correctAnswer3=new int [] {1,2,3};
			new QandA(question3, answer3, correctAnswer3);
			System.out.println("Test: Question length 30 / Answers length 20");
			break;

		case 4://Question length 40 / Answers length 25 / set correct answers to play
			String [] question4= {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb","cccccccccccccccccccccccccccccccccccccccc"};
			String [] answer4 =new String [] {"aaaaaaaaaaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbbbbbbbb","ccccccccccccccccccccccccc","ddddddddddddddddddddddddd"};//25 characters
			int []  correctAnswer4=new int [] {1,2,3};
			new QandA(question4, answer4, correctAnswer4);
			System.out.println("Test: Question length 40 / Answers length 25");
			break;
			
		case 5: 
			int[] wrongAnswer1={2,2,3};
			new QandA(wrongAnswer1);
			System.out.println("Test: Wrong answer Trivia game - 1-wrong 2-correct 3-correct");
			break;

		case 6:
			int[] wrongAnswer2={2,1,3};
			new QandA(wrongAnswer2);
			System.out.println("Test: Wrong answer Trivia game - 1-wrong 2-wrong 3-correct");
			break;

		case 7:
			int[] wrongAnswer3={2,2,1};
			new QandA(wrongAnswer3);
			System.out.println("Test: Wrong answer Trivia game - 1-wrong 2-wrong 3-wrong");
			break;

		case 8:
			int[] wrongAnswer4={1,4,3};
			new QandA(wrongAnswer4);
			System.out.println("Test: Wrong answer Trivia game - 1-correct 2-wrong 3-correct");
			break;

		case 9:
			int[] wrongAnswer5={1,4,4};
			new QandA(wrongAnswer5);
			System.out.println("Test: Wrong answer Trivia game - 1-correct 2-wrong 3-wrong");
			break;

		case 10:
			int[] wrongAnswer6={1,2,4};
			new QandA(wrongAnswer6);
			System.out.println("Test: Wrong answer Trivia game - 1-correct 2-correct 3-wrong");
			break;

		case 11:
			int[] wrongAnswer7={4,2,4};
			new QandA(wrongAnswer7);
			System.out.println("Test: Wrong answer Trivia game - 1-wrong 2-correct 3-wrong");
			break;
		}
	}
	// Submit all 3 questions & answers + choose the right answer

		public static void setAllRightQA() throws Exception{
			Methods.insertQuestion(0);
			Methods.insertAnswers();
			chooseCorrectAnswer(0);

			Methods.insertQuestion(1);
			Methods.insertAnswers();
			chooseCorrectAnswer(1);

			Methods.insertQuestion(2);
			Methods.insertAnswers();
			chooseCorrectAnswer(2);
			Methods.elementAvailiable("Play");
			Methods.playBtn();	
		}

}
