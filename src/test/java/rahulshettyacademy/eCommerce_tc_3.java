package rahulshettyacademy;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_3 extends BaseTest{

	@Test
	public void fillForm() throws InterruptedException {
		// Testcase: in cart add 2 items, check the sum is proper and check checkbox and tap on button
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jinju");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		//Scroll until Argentina is found
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		
driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Cart']")));
		
		int pricecount=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum=0;
		for(int i=0;i<pricecount;i++) {
			String x=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			x.substring(1);//remove the $ and read characters from index 1
			Double price=ConvertStringtoDouble(x);
			sum+=price;
			
		}
		String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	
		Assert.assertEquals(sum,ConvertStringtoDouble(total));
		
		//Testcase 4: Long press on T&C, check box select, tap on button
		
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPress(ele);
		Alert tcalert=driver.switchTo().alert();
		String actual=driver.findElement(By.xpath("//android.widget.TextView[@text='Terms Of Conditions']")).getText();
		Assert.assertEquals(actual, "Terms Of Conditions");
		tcalert.dismiss();
		
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		
		
	}
}
