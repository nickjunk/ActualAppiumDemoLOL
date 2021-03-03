package appiumDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidBasicsChrome {
	
	public static AndroidDriver<AndroidElement> driver;
	
	public static AndroidDriver<AndroidElement> androidCapabilities() throws MalformedURLException {
		
		DesiredCapabilities dC = new DesiredCapabilities();
		dC.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); //Change here for real device once it is connected. Once connected all test cases should work.

		//dC.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dC.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dC);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Setting global implicit wait
		
		return driver;
		
	}
	
}
