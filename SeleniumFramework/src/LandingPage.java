import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LandingPage extends ReuseableMethods{
	
	
	public void launchSFDCApp(){
		DriverClass.driver.get("https://www.salesforce.com/");
	}
	
	
	public void clickLogin() throws IOException{
		WebElement loginButton = DriverClass.driver.findElement(By.xpath(".//*[@id='button-login']"));
		clickButton(loginButton, "Login");
	}
	
	

}
