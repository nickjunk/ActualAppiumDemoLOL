package eCommerceAppDemo;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductSelectTest extends Base {

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
		
		//Asserting total amount in cart
		int attempts = 0;
		
		ArrayList<AndroidElement> totalProducts = null;
		//product is not listed by that ID, however if element is loading late, use this while loop so it can try more than once

		while(attempts<5) {
			try {
				totalProducts = (ArrayList<AndroidElement>) driver.findElementsById("com.androidsample.generalstore:id/productPrice");
				break;
			} catch(StaleElementReferenceException e) {
				
			}
			attempts++;
		}

		Double totalPrice = 0.0;
		for(int i=0; i<totalProducts.size(); i++) {
			String s = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			String s1 = s.substring(1);
			Double toAdd = Double.parseDouble(s1);
			totalPrice+=toAdd;
		}
		Double printedTotal = Double.parseDouble(driver.findElement(By.id("com.android.generalstore:id/totalAmountLbl")).getText());
		
		Assert.assertEquals(printedTotal, totalPrice);
		
	}

}
