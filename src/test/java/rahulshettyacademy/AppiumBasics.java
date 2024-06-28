package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
//import org.openqa.selenium.remote.HttpCommandExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppiumBasics extends BaseTest {
	//AppiumDriver driver;

	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		 //code
		//Click hamberger
		// driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")).click();
		
		//click Drawings
		// driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"store item\").instance(0)")).click();

		//		click and check text of webview
		
		//String webView=driver.findElement(By.xpath("//android.widget.TextView[@text=\"Products\"]")).getText();
       //Assert.assertEquals(webView, "Products");
       //driver.findElement(By.xpath("//android.widget.TextView[@text=\"Products\"]")).click();
		
		
		//Rotate to landscape
		
//		DeviceRotation Landscape=new DeviceRotation(0, 0, 90);
//		driver.rotate(Landscape);
		
		//=Window{9d2edb0 u0 com.saucelabs.mydemoapp.rn/com.saucelabs.mydemoapp.rn.MainActivity}----To start from a specific page, use adb shell dumpsys window|find "mCurrentFocus" to get app pack and app activity
		Activity activity=new Activity("com.saucelabs.mydemoapp.rn","com.saucelabs.mydemoapp.rn.MainActivity");
		((JavascriptExecutor)driver).executeScript("mobile:startActivity",ImmutableMap.of("intent","com.saucelabs.mydemoapp.rn/com.saucelabs.mydemoapp.rn.MainActivity"));
		ScrolltoEnd();
		
		
		//Press Homekey
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
	
}
