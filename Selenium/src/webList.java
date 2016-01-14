import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class webList {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.webex.com/");
		Thread.sleep(3000);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:/Users/Abhi/Google Drive/Nov 30 2015/Read only/Documents/Screen Shot/test.jpg"));
		driver.quit();
		
//		
//		WebElement webListObj = driver.findElement(By.xpath("//*[@id='City']"));
//		
//		Select wb = new Select(webListObj);
//		
//		wb.selectByIndex(0);
//		wb.selectByValue("D");
//		wb.selectByVisibleText("Mumbai");
//		
//		Thread.sleep(3000);
		
		
		
	}
}
