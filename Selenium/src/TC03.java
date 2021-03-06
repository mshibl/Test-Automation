import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TC03 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
	    driver.findElement(By.id("username")).sendKeys("mohamed.shibl@hotmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Password123");
	    driver.findElement(By.id("rememberUn")).click();
	    driver.findElement(By.id("Login")).click();
	    Thread.sleep(15000);
	    driver.findElement(By.cssSelector("img.profileTrigger")).click();
	    driver.findElement(By.linkText("Log Out")).click();
	    Thread.sleep(10000);
	    String expectedUserName = "mohamed.shibl@hotmail.com";
	    String actualUserName = driver.findElement(By.id("idcard-identity")).getText();
	   
		if(actualUserName.equals(expectedUserName)){
			System.out.println("Pass: Expected username is matching with actual username '" + actualUserName + "'");
		}else{
			System.out.println("Fail: Expected username " + expectedUserName + " is not matching with actual username '" + actualUserName + "'");
		}

	}


}
