package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args)throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.findElement(By.xpath("//a[@href='pages/checkbox.html']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div[1]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div[3]/input")).click();
		Thread.sleep(1000);
		WebElement isSelected = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/input"));
		boolean statusTwo = isSelected.isSelected();
		if (statusTwo == true) {
			System.out.println("Confirmed!, selenium is checked");
		} else {
			System.out.println("Selenium is unchecked");
		}
		Thread.sleep(1000);
		WebElement deSelect = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[2]/input"));
		boolean statusOne = deSelect.isSelected();
		if(statusOne==true) {
			deSelect.click();
			System.out.println("Successfully DeSelected!");
		} else {
			System.out.println("i think checkbox is already unchecked.");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[1]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[3]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[4]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[5]/input")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.close();

	}

}
