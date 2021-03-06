// Write a selenium code to read all content of the webtable

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class webTable {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new FirefoxDriver();
		driver.get("http://www.espncricinfo.com/new-zealand-v-sri-lanka-2015-16/engine/match/914205.html");
		Thread.sleep(5000);
		
		WebElement webTable = driver.findElement(By.xpath("//*[@id='full-scorecard']/div[2]/div/table[1]/tbody"));
		
		List<WebElement> allRows = webTable.findElements(By.tagName("tr"));
		
		for (int i = 1; i < allRows.size(); i+=2) {
			List<WebElement> allColumn = allRows.get(i).findElements(By.tagName("td"));
			
			for (int j = 1; j< allColumn.size(); j++){
				WebElement column = allColumn.get(j);
				String columnData = column.getText();
				System.out.print(columnData + " | ");		
			}	
			
			System.out.println("");	
		}
		
	}

}
