package appiumDemo;

import java.net.MalformedURLException;
import java.util.HashMap;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class iOSScrolling extends iOSBasics {
	
	public static void main(String[] args) throws MalformedURLException {
		
		IOSDriver<IOSElement> driver = iOSCapabilites("UIKitCatalog");
		
		//To scroll or swipe, use a javascript function
		String scrollScript = "mobile:scroll";
		HashMap<String, Object> scrollObject = new HashMap<String, Object>();
		scrollObject.put("direction", "down");
		scrollObject.put("label", "Web View");
		//executeScript requires HashMap as second argument
		driver.executeScript(scrollScript, scrollObject);
		driver.findElementByAccessibilityId("Web View").click();
		
	}
	
}
