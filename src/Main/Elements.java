package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Elements extends Methods{

	public static  WebElement[] selectRadioButtonElement() throws Exception {
		WebElement [] radioEleArr = new WebElement[4];
		try{
			//Radio 1
			radioEleArr[0]=driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input"));
			//Radio 2
			radioEleArr[1]=driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[1]/input"));
			//Radio 3
			radioEleArr[2]=driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[1]/input"));
			//Radio 4
			radioEleArr[3]=driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[1]/input"));
		}catch (NullPointerException e) {
			System.out.println("RadioBtn element is:  " + e.getMessage());

		} catch (Exception e) {
			System.out.println("Other Exception: "+e.getMessage());
		}
		return radioEleArr;
	}

	public static  WebElement[] selectTextBoxAnswerElement() throws Exception {

		WebElement [] answerEleArr=new WebElement[4];
		//Answer 1
		answerEleArr[0]=driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input"));
		//Answer 2
		answerEleArr[1]=driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input"));
		//Answer 3
		answerEleArr[2]=driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input"));
		//Answer 4
		answerEleArr[3]=driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input"));

		return answerEleArr;
	}
}