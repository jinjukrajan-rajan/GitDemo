package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest2 {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		//Start server
				service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\ADMIN\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				
				UiAutomator2Options options=new UiAutomator2Options();
				options.setDeviceName("Pixel3aphone");
				options.setChromedriverExecutable("C:\\Users\\ADMIN\\Downloads\\chromedriver-win64\\chromedriver.exe");
				//options.setApp("D:\\Appium\\appium\\src\\test\\java\\resources\\Android-MyDemoAppRN.1.3.0.build-244.apk");
				
				options.setCapability("browserName", "Chrome");
				//options.setApp("D:\\Appium\\appium\\src\\test\\java\\resources\\General-Store.apk");
				
				
				// driver=new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),null);	
				  driver= new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
				  
				  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 
	}
	
	
	


public double ConvertStringtoDouble(String s) {
	
	System.out.println("1");
	System.out.println("2");
	return (Double.parseDouble(s.substring(1)));
	
}
	



	@AfterClass
	public void tearDown() {
		driver.quit();
		 //stop server
		service.stop();
	}

}
