package appiumDemo;

import java.net.MalformedURLException;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidTest extends AndroidBasics {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = androidCapabilities("real");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
		//Select by xpath is same as Selenium (Use class as tagname)
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		//Select by id (Use resource-id)
		driver.findElement(By.id("android:id/checkbox")).click();
		//For cases without unique identifiers
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//With className
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Hello!");
		//Grab list of elements by className and pick out singular index
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		
		//Can use annotation such as below:
		// @AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']") or @IOSFindBy for iPhone
		// public WebElement preferences;
		
	}

}
