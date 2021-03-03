package eCommerceAppDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FormFillingErrorTest extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = eCommerceCapabilities();
		
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		
		//Let's Shop button click
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Retrieve error text
		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(toastMessage);
		Assert.assertEquals(toastMessage, "Please enter your name");
		
	}

}
