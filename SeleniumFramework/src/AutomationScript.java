/* Create reusable method for click button
 * Create reusable method for select check box 
 * Create reusable method for De-select check box
 * 
 * */

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AutomationScript {
	
	// Page Object Method (POM)
	public static void LoginErrorMessage() throws IOException{
		LoginPage LP = new LoginPage();  // Page Object
		String expectedMsg = "Please enter your ";
		
		LP.launchApp();
		LP.enterUN("user@gmail.com");
		LP.enterPWD("");
		LP.clickLogin();
		LP.validateErrorMsg(expectedMsg);
		
		DriverClass.driver.quit();
		
	}
	
	
	
	public static void LoginToSalesForce() throws IOException, InterruptedException{
		
		
		LoginPage LP = new LoginPage(); 
		
		LP.launchApp();
		LP.enterUN("prasanthi.alapati@gmail.com");
		LP.enterPWD("prashsahiti1");
		LP.clickLogin();
		Thread.sleep(4000);
		DriverClass.driver.quit();
	}
	
	// Automation Script or Test Script
	public static void CheckRemeberMe() throws IOException{
		ReuseableMethods.startReport("CheckRemeberMe", "C:/Users/Abhi/Google Drive/Nov 30 2015/Read only/Framework/Report/");
		LoginPage LP = new LoginPage(); 
		LP.launchApp();
		LP.enterUN("prasanthi.alapati@gmail.com");
		LP.enterPWD("prashsahiti1");
		LP.selectRememberMeCheckBox();
		LP.clickLogin();
		SFDCHomePage HP = new SFDCHomePage();
		HP.selectUserMenuDropDown();
		HP.clickLogOut();
		
		LP = new LoginPage(); 
		LP.validateUserNameText("prasanthi.alapati@gmail.com");
		ReuseableMethods.bw.close();
		
		DriverClass.driver.quit();
		
	}
	
	
	
	// Data Driven
	public static void LoginErrorMessageV1() throws IOException{
		
		String expectedMsg = "Please enter your ";
		
		ReuseableMethods.startReport("LoginErrorMessage", "C:/Users/Abhi/Google Drive/Nov 30 2015/Read only/Framework/Report/");
		
		DriverClass.driver.get("https://login.salesforce.com/");
		ReuseableMethods.Update_Report("Pass", "Launch SFDC application ", "SFDC Login application is Launched.");
		
		WebElement userNameField = DriverClass.driver.findElement(By.xpath("//*[@id='username']")); 
		WebElement passwordField = DriverClass.driver.findElement(By.xpath("//*[@id='password']"));
		WebElement loginButton = DriverClass.driver.findElement(By.xpath("//*[@id='Login']"));
		
		/*Enter user name in user name field*/
		ReuseableMethods.enterText(userNameField, "User@gmail.com", "UserName");
				
		/*Clear password*/
		ReuseableMethods.enterText(passwordField, "", "Password");
		
		/*Click Login button*/	
		ReuseableMethods.clickButton(loginButton, "Login");
		
		/*Validate msg*/
		WebElement errorMsg = DriverClass.driver.findElement(By.xpath("//*[@id='error']"));
		ReuseableMethods.validateMsg(errorMsg, expectedMsg, "Error Msg");

		ReuseableMethods.bw.close();
	}
	
	public static void login(){
		System.out.println("Login script is executing...");
	}
	
	public static void logOut(){
		System.out.println("Log out Script is executing...");
	}
	
	public static void testCase1(){
		System.out.println("Testcase 1 is executing...");
	}
	
	public static void testCase2(){
		System.out.println("Testcase 2 is executing...");
	}
	
	public static void testCase3(){
		System.out.println("Testcase 3 is executing...");
	}
	
	
	

}
