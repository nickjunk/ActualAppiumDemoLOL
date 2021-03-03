package appiumDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class iOSSliders extends iOSBasics {

	public static void main(String[] args) throws MalformedURLException {
		
		IOSDriver<IOSElement> driver = iOSCapabilites("UIKitCatalog");
		
		driver.findElementByAccessibilityId("Sliders").click();
		
		//Moving slider (Only for iOS) (Can do more when casting IOSElement)
		IOSElement slider = (IOSElement)driver.findElement(By.xpath("//XCUIElementTypeSlider"));
		slider.setValue("0%");
		slider.setValue("1%"); //Will go to 100%. For 42%, do 0.42%
		
		String value = slider.getAttribute("value");
		Assert.assertEquals(value, "100%");
		
	}

}
