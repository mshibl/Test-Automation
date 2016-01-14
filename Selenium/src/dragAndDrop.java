import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class dragAndDrop {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("http://dhtmlx.com/docs/products/dhtmlxTree/");
		
		driver.manage().window().maximize();
		 
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		Thread.sleep(8000);
		
		
		WebElement fromObj = driver.findElement(By.xpath("//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		
		WebElement toObj = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		
		Actions builder = new Actions(driver);
		
		builder.clickAndHold(fromObj).moveToElement(toObj).release(toObj).build().perform();
		
//		dragAndDrop.perform();
		
	}
}
