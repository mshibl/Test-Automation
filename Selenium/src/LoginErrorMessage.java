import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginErrorMessage {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		String expectedErrorMessage = "Please enter your password."; 
		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("User@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		WebElement errorObj = driver.findElement(By.id("error"));
		String actualErrorMessage = errorObj.getText();

		if(expectedErrorMessage.equals(actualErrorMessage)){
			System.out.println("Pass: Expected error message is matching with actual error message '" + actualErrorMessage + "'");
		}else{
			System.out.println("Fail: Expected error message " + expectedErrorMessage + " is not matching with actual error message '" + actualErrorMessage + "'");
		}

	}


}
