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

	public static void setUpFireFox() {
		driver= new  FirefoxDriver();
	}

	public static void setUpChrome() {
		driver= new ChromeDriver();
	}

	public static void openTrivia() {  //Open browser move to the middle
		driver.manage().window().setPosition(new Point(400,0));
		driver.get(url);
	}

	public static void closeDriver() {
		driver.close();
	}

	public static void tearDown() {
		driver.quit();
	}


	public static void insertQuestion(int i)  { // Insert Question from array + next button
		try {
			driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input")).sendKeys(QandA.getQuestion(i));
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage()+ " ERROR IN INSERT QUESTION");
		}
		Methods.clickNextBtn();
	}

	public static void insertAnswers() throws Exception{
		WebElement [] answerEleArr=Elements.selectTextBoxAnswerElement();
		for(int i=0;i<4;i++) {
			answerEleArr[i].sendKeys(QandA.getAnswer(i));
		}
	}

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

	public static boolean radioIsChecked() throws Exception { //Check radio buttons unchecked
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

	public static void resultOfPlayAllCorrect() {
		String mark="null";
		try {
			mark=PlayTrivia.playAllRightAnswers();//Result: string_get success/failed mark
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(mark=="Sucsses") {
			System.out.println("Test end page has:" + mark + " Test pass");
		}else{
			System.out.println("Test end page - failed");
		}
	}


	// Buttons 


	public static void clickStartBtn() {	//Click on start button, open question page
		driver.findElement(By.id("startB")).click();	
	}

	public static void clickNextBtn() {	// Click on next button submit Q&A process
		try {
			driver.findElement(By.id("nextquest")).click();
		}
		catch(Exception e) {
			System.out.println("Next button in Q&A submit doesnt work");
		}
	}
	public static void clickNextBtnGame() {	// Click on next button in Trivia game
		driver.findElement(By.id("btnnext")).click();
	}

	public static void clickBackBtn() {	// Click on back button sumbit Q&A process
		try {
			driver.findElement(By.xpath("//*[@id=\"backquest\"]")).click();
		}
		catch(Exception e) {
			System.out.println("Back button doesnt work");
		}
	}

	public static Boolean playBtn() { //Click on play button 
		boolean startGame= false;
		driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
		if (driver.getPageSource().contains(QandA.getQuestion(0))||driver.getPageSource().contains(QandA.getQuestion(1))||driver.getPageSource().contains(QandA.getQuestion(2))){
			startGame=true;
		}
		return startGame; 
	}

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

	public static Boolean tryAgainBtn() throws Exception {
		boolean checkPage=false;
		driver.findElement(By.xpath("//*[@id=\"markpage\"]/center/button[1]")).click();
		if (driver.getPageSource().contains(QandA.getQuestion(0))||driver.getPageSource().contains(QandA.getQuestion(1))||driver.getPageSource().contains(QandA.getQuestion(2))){
			checkPage=true;
		}
		return checkPage;
	}
}

