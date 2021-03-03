package appiumDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

//import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GesturesAndroid extends AndroidBasics{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = androidCapabilities("emulator");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		//Tap Gesture -> import TouchActions class using driver as an argument
		//TouchAction touch = new TouchAction(driver);
		//Use Actions class for instead if receiving ClassCastException -> Do not forget .build().perform();
		Actions actions = new Actions(driver);
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		//Make sure to use .perform() within TouchActions class (same with Actions class in Selenium)
		//touch.singleTap(driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"))).perform();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		
		//touch.longPress(driver.findElement(By.xpath("//android.widget")))
		actions.clickAndHold(driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"))).build().perform();;
		
		System.out.println(driver.findElement(By.id("android:id/title")).isDisplayed());
		
	}

}
