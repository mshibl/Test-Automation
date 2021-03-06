import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TC04 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
	    driver.findElement(By.id("username")).sendKeys("mohamed.shibl@hotmail.com");
	    driver.findElement(By.id("forgot_password_link")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("un")).sendKeys("mohamed.shibl@hotmail.com");
	    driver.findElement(By.id("continue")).click();
	    
	    String expectedText = "We’ve sent you an email with a link to finish resetting your password.";
	    String actualText = driver.findElement(By.xpath(".//*[@id='forgotPassForm']/div/p[1]")).getText();
	   
		if(actualText.equals(expectedText)){
			System.out.println("Pass: Expected password reset message is matching with actual password reset message '" + actualText + "'");
		}else{
			System.out.println("Fail: Expected password reset message " + expectedText + " is not matching with actual password reset message '" + actualText + "'");
		}
	}
}
