package appiumDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidChromeTest2 extends AndroidBasicsChrome {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = androidCapabilities();
		driver.get("http://cricbuzz.com");
		
		driver.findElement(By.xpath("//a[@href='#menu']")).click();
		driver.findElement(By.cssSelector("a[title='Cricbuzz Home']")).click();
		
		//Browser scroll requires JavascriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 480)", "");
		
		boolean h4 = driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header");

		Assert.assertTrue(h4);
		System.out.println(h4);
		
		driver.close();
		
	}

}
