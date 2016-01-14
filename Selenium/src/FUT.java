import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FUT {

	static WebDriver driver;
	private static Scanner user_input;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new FirefoxDriver(); // This will launch Firefox browser
		driver.get("https://www.easports.com/fifa/ultimate-team/web-app");  // Launch application
		
		driver.manage().window().maximize();
		
		WebElement userNameObj = driver.findElement(By.id("email"));
		userNameObj.sendKeys("mohamed.shibl.hussein@gmail.com");
		
		WebElement passwordObj = driver.findElement(By.id("password"));
		passwordObj.sendKeys("Superpower88");
		
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();
		
		user_input = new Scanner( System.in );
		String securityCode;
		System.out.print("Enter Security Code: ");
		securityCode = user_input.next( );
		
		System.out.println(securityCode);
		
		WebElement secCodeInput = driver.findElement(By.id("twofactorCode"));
		secCodeInput.sendKeys(securityCode);
		
		WebElement submitSecCode = driver.findElement(By.id("btnTFAVerify"));
		submitSecCode.click();
		
		WebElement notNow = driver.findElement(By.id("btnCancel"));
		notNow.click();
		
		Thread.sleep(10000);
		
		WebElement secQuesInput = driver.findElement(By.cssSelector(".futPhishingTextBoxTyped"));
		secQuesInput.sendKeys("aaaaa");
		
		WebElement secQuesContinue = driver.findElement(By.cssSelector(".futPhishingButtonArrow"));
		secQuesContinue.click();
				
		
	}

}
