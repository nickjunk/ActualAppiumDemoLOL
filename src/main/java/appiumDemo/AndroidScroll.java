package appiumDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidScroll extends AndroidBasics {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = androidCapabilities("real");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		//Check out this convoluted shit, but it works! Just change "WebView" to whatever as the scroll to.
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

	}

}
