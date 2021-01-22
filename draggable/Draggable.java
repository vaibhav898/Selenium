package draggable;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args)throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com");
		driver.findElement(By.xpath("//a[@href='pages/drag.html']")).click();
		Thread.sleep(1000);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement box = driver.findElement(By.id("mydiv"));
		Point xyValue = box.getLocation();
		int x = xyValue.x;
		int y = xyValue.y;
		System.out.println(x);
		System.out.println(y);
		Actions dragAction = new Actions(driver);
		dragAction.clickAndHold(drag).moveByOffset(x, y).release(drag).build().perform();
		dragAction.clickAndHold(drag).moveByOffset(x+5, y+5).release(drag).build().perform();
		Thread.sleep(1000);
		driver.close();
	}

}
