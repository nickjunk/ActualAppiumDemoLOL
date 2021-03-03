package appiumDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class AndroidDragAndDrop extends AndroidBasics {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = androidCapabilities("real");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		
		TouchAction touch = new TouchAction(driver);
		
		WebElement from = driver.findElements(By.className("android.view.View")).get(0);
		WebElement to = driver.findElements(By.className("android.view.View")).get(2);
		
		touch.longPress(element(from)).moveTo(element(to)).release().perform();

	}

}
