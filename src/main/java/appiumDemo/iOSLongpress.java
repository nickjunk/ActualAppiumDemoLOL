package appiumDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import static java.time.Duration.ofSeconds;

public class iOSLongpress extends iOSBasicsRealDevice {

	public static void main(String[] args) throws MalformedURLException {
		
		IOSDriver<IOSElement> driver = iOSCapabilites("longtap");
		
		MobileElement longTapElement = (MobileElement) driver.findElement(By.name("Long tap"));
		//You know what this looks like
		IOSTouchAction touch = new IOSTouchAction(driver);
		touch.longPress(longPressOptions().withElement(element(longTapElement)).withDuration(ofSeconds(2))).release().perform();
		//Always add .perform();
		MobileElement emailSwitchElement = driver.findElement(By.xpath("//XCUIElementTypeSwitch[2]"));
		touch.tap(tapOptions().withElement(element(emailSwitchElement))).perform();
		
	}

}
