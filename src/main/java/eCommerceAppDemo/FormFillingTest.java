package eCommerceAppDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FormFillingTest extends Base {
	
	@Test
	public static  void formFillingTest() throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = eCommerceCapabilities();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nick with the big dick");
		driver.hideKeyboard(); //Hides any open keyboard
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		
		//Scroll to find 'Argentina' in dropdown
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		
		//Let's Shop button click
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
	}
	
	public static void main(String[] args) throws MalformedURLException {
		
		formFillingTest();
		
	}
	
}
