/* WSP to display the radio button selected
 * */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class radioButton {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new FirefoxDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		
		List<WebElement> radioButton = driver.findElements(By.name("group1"));
		Thread.sleep(2000);
		radioButton.get(0).click();
		System.out.println(radioButton.get(0).getAttribute("value"));
		
		System.out.println();
		Thread.sleep(2000);
		radioButton.get(1).click();
		Thread.sleep(2000);
		radioButton.get(2).click();
		
		
	}
}
