import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class testCase1 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new FirefoxDriver(); // This will launch Firefox browser
		driver.get("https://login.salesforce.com/");  // Launch application
		
		
		driver.manage().window().maximize();
		
		WebElement userNameObj = driver.findElement(By.xpath("//input[@id='username']"));
		userNameObj.sendKeys("MyName@gmail.com");
		
		
		
//		userNameObj = driver.findElement(By.id("username"));
//		userNameObj.sendKeys("Nav@gmail.com");
		
		WebElement passWordObj = driver.findElement(By.id("password"));
		passWordObj.sendKeys("Pass123");
		
		WebElement remCheckBox = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		remCheckBox.click();
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		Thread.sleep(3000);
		
		WebElement errorObj = driver.findElement(By.id("error"));
		String errorMessage = errorObj.getText();
		
		System.out.println(errorMessage);
		
		userNameObj = driver.findElement(By.xpath("//input[@id='username']"));
		String textVal = userNameObj.getAttribute("value");
		System.out.println(textVal);
		
	}

}
