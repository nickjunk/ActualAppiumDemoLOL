package appiumDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidChromeTest extends AndroidBasicsChrome {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = androidCapabilities();
		driver.get("http://facebook.com");
		
		WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement passwordBox = driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
		
		emailBox.sendKeys("jarjarbinks@email.com");
		passwordBox.sendKeys("secretlySith66");
		loginButton.click();
		
		driver.close();
	}

}
