package frame;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com");
		driver.findElement(By.xpath("//a[@href='pages/frame.html']")).click();
		Thread.sleep(1000);
		List<WebElement> numOfFrames = driver.findElements(By.tagName("iframe"));
		int numberOfFrames = numOfFrames.size();
		System.out.println("Number of frames in main page : " +numberOfFrames);
		WebElement frameOne = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(frameOne);
		driver.findElement(By.id("Click")).click();
		Thread.sleep(1000);	
		driver.switchTo().defaultContent();
		WebElement frameTwo = driver.findElement(By.xpath("//iframe[@src='page.html']"));
		driver.switchTo().frame(frameTwo);
		int numOfFramesInNest = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Num Of Nested frames : " +numOfFramesInNest);
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click1")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='countframes.html']")));
	  int TotalNumberOfFrames = driver.findElements(By.tagName("iframe")).size();
	  System.out.println("Toatl number of frames: " +TotalNumberOfFrames);
	  Thread.sleep(1000);
	  driver.switchTo().defaultContent();
	  driver.navigate().back();
	  Thread.sleep(1000);
		driver.close();
	}

}
