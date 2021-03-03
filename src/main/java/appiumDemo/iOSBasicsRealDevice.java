package appiumDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class iOSBasicsRealDevice {

static IOSDriver<IOSElement> driver;
	
	public static IOSDriver<IOSElement> iOSCapabilites(String app) throws MalformedURLException {
		
		String longTapApp = "/Users/nicholas/Library/Developer/Xcode/DerivedData/longtap-ejvyuuntbjlnbjeymkybiybnaslb/Build/Products/Debug-iphoneos/longtap.app";
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.4"); 
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "xcuitest");
		dc.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
		dc.setCapability("commandTimeouts", "12000");
		if(app.equals("UIKitCatalog")) {
			dc.setCapability(MobileCapabilityType.APP, "/Users/nicholas/Desktop/UIKitCatalog.app");
		} else if(app.equals("longtap")) {
			dc.setCapability(MobileCapabilityType.APP, longTapApp);
		}
		dc.setCapability("xcodeSigningId", "iPhone Developer");
		//dc.setCapability("xcodeOrgId", "");
		dc.setCapability("udid", "00008030-001C709E1401802E");
		dc.setCapability("updateWDABundleID", "io.appiumLearningNicholasJunk.WebDriverAgentRunner");
		
		driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
		
		return driver;
		
	}
	
}
