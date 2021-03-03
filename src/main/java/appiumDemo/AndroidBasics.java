package appiumDemo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidBasics {
	
	public static AndroidDriver<AndroidElement> driver;
	
	public static AndroidDriver<AndroidElement> androidCapabilities(String device) throws MalformedURLException {
		
		File f = new File("src");
		File fA = new File(f, "ApiDemos-debug.apk");
		
		DesiredCapabilities dC = new DesiredCapabilities();
		if(device.equals("emulator")) {
			dC.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus6");
		} else if(device.equals("real")) {
			dC.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); //Change here for real device once it is connected. Once connected all test cases should work.

		}
		dC.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dC.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dC.setCapability(MobileCapabilityType.APP, fA.getAbsolutePath());
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dC);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Setting global implicit wait
		
		return driver;
		
	}
	
}
