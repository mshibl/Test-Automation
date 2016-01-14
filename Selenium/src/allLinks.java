import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class allLinks {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new FirefoxDriver();
		
	    driver.get("http://timesofindia.indiatimes.com/international-home");
        
        List<WebElement> allTextBoxes = driver.findElements(By.tagName("input"));
        System.out.println("Total number of Link is " + allTextBoxes.size());
        
        for(int i =0; i<allTextBoxes.size(); i++){
            
            try{
                
                
                String linkName = allTextBoxes.get(i).getAttribute("aria-label");
                System.out.println("Link index " + i + " ---> Link Name: " + linkName);
                
                if(linkName.equals("First name")){
                	allTextBoxes.get(i).sendKeys("MY FN: Pavitra");
                }
                
                if(linkName.equals("Last name")){
                	allTextBoxes.get(i).sendKeys("MY LN: India");
                }
                
            }catch(Exception e){
                
            }
            
        }
		
		
		driver.get("http://timesofindia.indiatimes.com/international-home");
		
		List<WebElement> allLinksObj = driver.findElements(By.tagName("a"));
		System.out.println("Total number of Link is " + allLinksObj.size());
		
		for(int i =0; i<allLinksObj.size(); i++){
			
			try{
				
				String linkName = allLinksObj.get(i).getText();
				System.out.println("Link index " + i + " ---> Link Name: " + linkName);
				
				if(linkName.equals("India")){
					allLinksObj.get(i).click();
					break;
				}
				
			}catch(Exception e){
				
			}
			
		}
		
		
		WebElement indiaObj = driver.findElement(By.xpath("//*[@id='nav-india']/a"));
		
		WebElement indiaObj1 = allLinksObj.get(86);
		
		
		
		
		/*WebElement linkObj = allLinksObj.get(1295);
		linkObj.click();
		linkObj.getText();
		linkObj.getAttribute("Value");*/
		
	}

}
