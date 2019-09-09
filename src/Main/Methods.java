package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Methods {

	protected static WebDriver driver;
	protected static String url = "https://svcollegetest.000webhostapp.com/";

	
	// Open FireFox browser
	public static void setUpFireFox() {
		driver= new FirefoxDriver();
	}

	//Open Chrome browser
	public static void setUpChrome() {
		driver= new ChromeDriver();
	}

	// Open URL of Trivia game and move window of browser to the middle
	public static void openTrivia() {  
		driver.manage().window().setPosition(new Point(400,0));
		driver.get(url);
	}

	// Close browser 
	public static void closeDriver() {
		driver.close();
	}
	
	// Quit browser
	public static void tearDown() {
		driver.quit();
	}

	// Insert Question from array of questions and clicking next button
	public static void insertQuestion(int i)  { 
		try {
			driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input")).sendKeys(QandA.getQuestion(i));
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage()+ " ERROR IN INSERT QUESTION");
		}
		Methods.clickNextBtn();
	}

	// Insert Answers from array of answers 
	public static void insertAnswers() throws Exception{
		WebElement [] answerEleArr=Elements.selectTextBoxAnswerElement();
		for(int i=0;i<4;i++) {
			answerEleArr[i].sendKeys(QandA.getAnswer(i));
		}
	}

	//Check if element is available in current page
	public static boolean elementAvailiable(String s) { // Check if page contains
		boolean available=false; 
		try {
			if(driver.getPageSource().contains(s)){
				available=true;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return available; 
	}

	// Check if radio buttons are checked
	public static boolean radioIsChecked() throws Exception { 
		WebElement[] radioCheck= Elements.selectRadioButtonElement();
		boolean	radioBtn=false; ;
		for(int i=0; i<4;i++) {
			try {
				if(radioCheck[i].isSelected()==true) {
					radioBtn=true;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		return radioBtn;
	}

	// Check the result of the Trivia game : Success / Failed
	public static void resultOfPlayAllCorrect() {
		String mark="null";
		try {
			mark=PlayTrivia.playAllRightAnswers();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(mark=="Sucsses") {
			System.out.println("Test end page has:" + mark + " Test pass");
		}else{
			System.out.println("Test end page - failed");
		}
	}
	
	//Method checks question mark in Trivia game questions 
	 public static boolean questionMark(WebElement element) {
		 boolean qMark= false; 
		 String question= null; 
		 question=element.getText();
		 if(question.charAt(question.length()-1)=='?') {
			 qMark=true; 
		 }
		 
		 return qMark;
	 }

	// Buttons 

	// Click start button- opens 1st question page 
	public static void clickStartBtn() {	
		driver.findElement(By.id("startB")).click();	
	}
	
	// Click on next button submit Q&A process
	public static void clickNextBtn() {	
		try {
			driver.findElement(By.id("nextquest")).click();
		}
		catch(Exception e) {
			System.out.println("Next button in Q&A submit doesnt work");
		}
	}
	
	// Click on next button in Trivia game
	public static void clickNextBtnGame() {	
		driver.findElement(By.id("btnnext")).click();
	}
	
	// Click on back button submit Q&A process
	public static void clickBackBtn() {	
		try {
			driver.findElement(By.xpath("//*[@id=\"backquest\"]")).click();
		}
		catch(Exception e) {
			System.out.println("Back button doesnt work");
		}
	}
	
	// Click on back button during Trivia game
		public static void clickBackBtnGame() {	
			try {
				driver.findElement(By.xpath("//*[@id=\"btnback\"]")).click();
			}
			catch(Exception e) {
				System.out.println("Back button doesnt work in trivia game");
			}
		}
	
	//Click on play button and check if page contains one of the questions submitted 
	public static Boolean playBtn() { 
		boolean startGame= false;
		driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
		if (driver.getPageSource().contains(QandA.getQuestion(0))||driver.getPageSource().contains(QandA.getQuestion(1))||driver.getPageSource().contains(QandA.getQuestion(2))){
			startGame=true;
		}
		return startGame; 
	}

	//Click on Facebook button at the end of the game to share on Facebook
	public static boolean facebookBtn() {
		try {
			driver.findElement(By.xpath("//*[@id=\"fackBook2\"]/img")).click();
		}
		catch(Exception e) {
			System.out.println("Facebook button error");
		}
		driver.switchTo().alert().accept();
		return elementAvailiable("Facebook");
	}

	//Click on try again button and checks if Trivia game starts over
	public static Boolean tryAgainBtn() throws Exception {
		boolean checkPage=false;
		driver.findElement(By.xpath("//*[@id=\"markpage\"]/center/button[1]")).click();
		if (driver.getPageSource().contains(QandA.getQuestion(0))||driver.getPageSource().contains(QandA.getQuestion(1))||driver.getPageSource().contains(QandA.getQuestion(2))){
			checkPage=true;
		}
		return checkPage;
	}
	
	//Click on quit button and checks if page contains "Trivia"
		public static Boolean quitBtn() throws Exception {
			boolean checkPage=true;
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[2]")).click();
			if (driver.getPageSource().contains("Trivia")){
				checkPage=false;
			}
			return checkPage;
		}
	
	
	
	
}

