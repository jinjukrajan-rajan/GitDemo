package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest2{

	@Test
	public void bwserTest() throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("/html/body/app-root/nav/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a")).click();
		
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)","");
		Thread.sleep(2000);
		String text=driver.findElement(By.xpath("/html/body/app-root/app-product-details/div/div[2]/div/ul/div[3]/li/div/div/a")).getText();
		System.out.println(text);
		// "/html/body/app-root/app-product-details/div/div[2]/div/ul/div[3]/li/div/div/a");
		Thread.sleep(3000);
//		driver.findElement(By.name("q")).sendKeys("test");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	}
}
