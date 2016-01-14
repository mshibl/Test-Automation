import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SFDCHomePage {
	
	
	public void selectUserMenuDropDown() throws IOException{
		WebElement userMenu = DriverClass.driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		ReuseableMethods.clickButton(userMenu, "UserMenu");
	}
	
	public void clickLogOut() throws IOException{
		WebElement logOut = DriverClass.driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		ReuseableMethods.clickButton(logOut, "logOut");
	}
	
	public void openProfile() throws IOException{
		WebElement myProfile = DriverClass.driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[1]"));
		ReuseableMethods.clickButton(myProfile,"myProfile");
	}

}
