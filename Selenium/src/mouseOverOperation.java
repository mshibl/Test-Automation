import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class mouseOverOperation {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.salesforce.com/");
		Thread.sleep(5000);
		
		
		WebElement obj = driver.findElement(By.xpath("//*[@id='nav']/ul/li[2]/span/span/span/a"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(obj).build().perform();
		
	}
}
