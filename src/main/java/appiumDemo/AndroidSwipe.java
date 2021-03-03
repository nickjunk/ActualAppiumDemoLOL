package appiumDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import static java.time.Duration.ofSeconds;

public class AndroidSwipe extends AndroidBasics {
	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = androidCapabilities("real");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();
		//Cannot use xpath if there is special characters ($, %, &, etc.) Can use * for 'any tagName is acceptable'
		
		WebElement from = driver.findElement(By.xpath("//*[@content-desc='3']"));
		WebElement to = driver.findElement(By.xpath("//*[@content-desc='9']"));
		
		driver.findElement(By.xpath("//*[@content-desc='6']")).click();
		
		TouchAction touch = new TouchAction(driver);
		
		touch.longPress(longPressOptions().withElement(element(from)).withDuration(ofSeconds(1))).moveTo(element(to)).release().perform();
		
		
	}

}
