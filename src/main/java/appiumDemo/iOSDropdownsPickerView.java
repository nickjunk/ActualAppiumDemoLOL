package appiumDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class iOSDropdownsPickerView extends iOSBasics {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		IOSDriver<IOSElement> driver = iOSCapabilites("UIKitCatalog");
		
		driver.findElementByAccessibilityId("Progress Views").click();
		Thread.sleep(4000);
		
		//Go back to home page
		driver.findElement(By.xpath("//XCUIElementTypeButton[@label='UIKitCatalog']")).click();
		
		driver.findElementByAccessibilityId("Picker View").click();
		
		//Just sendKeys
		driver.findElementByAccessibilityId("Red color component value").sendKeys("80");
		driver.findElementByAccessibilityId("Green color component value").sendKeys("220");
		driver.findElementByAccessibilityId("Blue color component value").sendKeys("90");

	}

}
