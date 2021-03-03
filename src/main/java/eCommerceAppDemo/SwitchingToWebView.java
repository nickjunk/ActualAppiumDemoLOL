package eCommerceAppDemo;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SwitchingToWebView extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = eCommerceCapabilities();
		
		String product = "Jordan 6 Rings";
		
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
		
		//Click on cart
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//Assert gestures
		WebElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(checkBox))).perform();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		//Switching Context to WebView
		Thread.sleep(8000);
		Set<String> contextHandles = driver.getContextHandles();
		for(String context:contextHandles ) {
			System.out.println(context);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore"); //Switching to WebView context here
		driver.findElement(By.name("q")).sendKeys("Hello from the other side"); //Make sure Chromedriver version matches one on emulator/device. Check Appium logs.
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		//Moving back to native app (Android Only)
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
	}

}
