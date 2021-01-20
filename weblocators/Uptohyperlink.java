package weblocators;

import java.awt.Dimension;
import java.awt.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Uptohyperlink {
	
	public static void main(String[] args)throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		
		// Edit 
		
		driver.findElement(By.xpath("//h5[@class='wp-categories-title']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("bvvaibhav48@gmail.com");
		Thread.sleep(3000);
		WebElement appendTAB = driver.findElement(By.xpath("//input[@value='Append ']"));
		appendTAB.sendKeys("Hey hi");
		String appendVal = appendTAB.getAttribute("value");
		System.out.println("After Append: " +appendVal);
		Thread.sleep(2000);
		appendTAB.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		WebElement defaultfield = driver.findElement(By.xpath("//input[@value='TestLeaf']"));
		String val = defaultfield.getAttribute("value");
		System.out.println("Default value in the field: " +val);
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		Thread.sleep(3000);
		WebElement check = driver.findElement(By.xpath("//input[@disabled='true']"));
		boolean status = check.isEnabled();
		System.out.println("Is Enable status: " +status);
		if (status == false){
			System.out.println("Confirmed!.Field is Disabled");
			} else {
			System.out.println("Field is enable");
		}
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(3000);
		
		// Buttons 
		
		driver.findElement(By.xpath("//a[@href='pages/Button.html']")).click();
		WebElement location = driver.findElement(By.id("position"));
		org.openqa.selenium.Point vals = location.getLocation();
		System.out.println("x position: " +vals.x + "  Y position: " +vals.y);
		WebElement colourButton = driver.findElement(By.id("color"));
		String rgbvalue = colourButton.getCssValue("background-color");
		String backgroundcolor = colourButton.getAttribute("style");
		System.out.println( backgroundcolor + "  value: " +rgbvalue);
		WebElement hwButton = driver.findElement(By.id("size"));
		org.openqa.selenium.Dimension dimens = hwButton.getSize();
		System.out.println("Height: " +dimens.height + "  width: " +dimens.width);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='home']")).click();
		Thread.sleep(3000);
		
		//Hyper Text 
		
		driver.findElement(By.xpath("//a[@href='pages/Link.html']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@style='color: #CC0000']")).click();
		driver.findElement(By.xpath("//a[@href='pages/Link.html']")).click();
		String reflink = driver.findElement(By.xpath("//a[@href='Button.html']")).getAttribute("href");
		System.out.println("Reference link: " +reflink);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='error.html']")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.navigate().back();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@style='color: #CC0000']")).click();
		Thread.sleep(3000);
		
		//Image
		
		driver.findElement(By.linkText("Image")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
