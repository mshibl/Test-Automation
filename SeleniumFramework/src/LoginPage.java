import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends ReuseableMethods{
	
	public void launchApp(){
		DriverClass.driver.get("https://login.salesforce.com/");
	}
	
	// Functional Method
	public  void enterUN(String userName) throws IOException{
		WebElement userNameField = DriverClass.driver.findElement(By.xpath("//*[@id='username']")); 
		
		enterText(userNameField, userName, "UserName");
	}
	
	
	public  void enterPWD(String pwd) throws IOException{
		WebElement passwordField = DriverClass.driver.findElement(By.xpath("//*[@id='password']"));
		enterText(passwordField, pwd, "Password");
	}
	
	public  void clickLogin() throws IOException{
		WebElement loginButton = DriverClass.driver.findElement(By.xpath("//*[@id='Login']"));
		clickButton(loginButton, "Login");
	}
	
	public void validateErrorMsg(String expectedMsg) throws IOException{
		WebElement errorMsg = DriverClass.driver.findElement(By.xpath("//*[@id='error']"));
		validateMsg(errorMsg, expectedMsg, "Error Msg");
	}

	public void selectRememberMeCheckBox() throws IOException{
		WebElement rembMeCheckBox = DriverClass.driver.findElement(By.xpath("//*[@id='rememberUn']"));
		selectCheckBox(rembMeCheckBox, "Remember me");
	}
	
	public void validateUserNameText(String expectedTextMsg){
		WebElement userNameField = DriverClass.driver.findElement(By.xpath("//*[@id='username']"));
		validateTextBoxMsg(userNameField, expectedTextMsg);
	}
}
