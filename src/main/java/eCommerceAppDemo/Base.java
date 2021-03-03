package eCommerceAppDemo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
	public static AndroidDriver<AndroidElement> driver;

	public static AndroidDriver<AndroidElement> eCommerceCapabilities() throws MalformedURLException {
		
		File appDir = new File("src");
		File app = new File(appDir, "General-Store.apk");
		
		DesiredCapabilities dC = new DesiredCapabilities();
		dC.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus6");
		dC.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dC.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dC.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dC);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Setting global implicit wait
		
		return driver;
		
	}
	
}
