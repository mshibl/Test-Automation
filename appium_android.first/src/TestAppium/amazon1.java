package TestAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class amazon1
{
	WebDriver dr;
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException{
		
		File app=new File("C:/Users/Selenium/Desktop/app/in.amazon.mShop.android.shopping.apk");
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","Motorola xt1068");
		capabilities.setCapability("platformVersion","5.0.2");
		capabilities.setCapability("platformName","Android");
		
		capabilities.setCapability("app",app.getAbsolutePath());
		
		
		dr=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		dr.quit();
		
	}
	

}
