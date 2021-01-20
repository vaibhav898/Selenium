package windows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com");
		driver.findElement(By.xpath("//a[@href='pages/Window.html']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("home")).click();
		Set <String> windowHandler = driver.getWindowHandles();
		Iterator <String> windowIterator = windowHandler.iterator();
		String parentWindow = windowIterator.next();
		System.out.println("Parent window address : "+parentWindow);
		String childWindow = windowIterator.next();
		driver.switchTo().window(childWindow);
		System.out.println("Child window address : " +childWindow);
		Thread.sleep(1500);
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//button[@onclick='openWindows()']")).click();
		Set<String> windowHandler2 = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(windowHandler2);
		System.out.println("Number of opened windows: " + tabs.size());
		driver.quit();
		
		}

}
