package eCommerceAppDemo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class MobileGesturesTest extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = eCommerceCapabilities();
		
		String product = "Jordan 6 Rings";
		String product2 = "Air Jordan 4 Retro";
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nick with the big dick");
		driver.hideKeyboard(); //Hides any open keyboard
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		
		//Let's Shop button click
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Scroll and search though list of elements for Jordan 6 Rings
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
				+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))"
				+ ".scrollIntoView(new UiSelector().textMatches(\""+product+"\").instance(0));"));
		
		//Add product to cart
		int addToCartLinks = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		//Search products visibile on page by creating a list, and then selecting the appropriate add to cart link
		for(int i=0; i<addToCartLinks; i++) {
			if (driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText().equals(product)) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break; //Be sure to break if product is found
			}
		}
		
		//Scroll and search though list of elements for Air Jordan 4 Retro
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
				+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))"
				+ ".scrollIntoView(new UiSelector().textMatches(\""+product2+"\").instance(0));"));
		
		//Add product to cart
		int addToCartLinks2 = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		//Search products visibile on page by creating a list, and then selecting the appropriate add to cart link
		for(int i=0; i<addToCartLinks2; i++) {
			if (driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText().equals(product2)) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break; //Be sure to break if product is found
			}
		}
		
		//Click on cart
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//Assert gestures
		WebElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));
		
		TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(checkBox))).perform();
		
		WebElement tAndC = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		
		touch.longPress(longPressOptions().withElement(element(tAndC)).withDuration(ofSeconds(2))).release().perform();
		
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		

	}

}
