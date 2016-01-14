import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class rightClick {
	public static  WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(5000);
		
		WebElement userName = driver.findElement(By.id("username"));
		
		userName.click();
		Thread.sleep(1000);
		Actions actionRt = new Actions(driver);
		
		actionRt.contextClick(userName).build().perform();
		Thread.sleep(1000);
		actionRt.contextClick(userName).sendKeys(Keys.ARROW_DOWN).build().perform();
		
		Thread.sleep(1000);
		actionRt.contextClick(userName).sendKeys(Keys.ARROW_DOWN).build().perform();
		
		Thread.sleep(1000);
		actionRt.contextClick(userName).sendKeys(Keys.ARROW_DOWN).build().perform();
		
		Thread.sleep(1000);
		actionRt.contextClick(userName).sendKeys(Keys.ARROW_DOWN).build().perform();
		
		Thread.sleep(1000);
		actionRt.contextClick(userName).sendKeys(Keys.ENTER).build().perform();
		
		
	}
	
}
