package appiumDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class iOSTest extends iOSBasics {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		IOSDriver<IOSElement> driver = iOSCapabilites("UIKitCatalog");
		
		driver.findElementByAccessibilityId("Alert Views").click();
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Text Entry']")).click();
		//For edit box
		driver.findElement(By.xpath("//XCUIElementTypeCell")).sendKeys("Whoop there it is!");
		
		driver.findElementByAccessibilityId("OK").click();
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='Confirm / Cancel']")).click();
		
		String message = driver.findElement(By.xpath("//*[contains(@name, 'message')]")).getText();
		Assert.assertEquals(message, "A message should be a short, complete sentence.");
		
		driver.findElementByAccessibilityId("Confirm").click();
		
	}

}
