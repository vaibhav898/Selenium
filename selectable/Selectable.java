package selectable;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args)throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com");
		driver.findElement(By.xpath("//a[@href='pages/selectable.html']")).click();
		Thread.sleep(1000);
		List <WebElement> selectList = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
		System.out.println("number of available select list : "+selectList.size());
		Actions selectAction = new Actions(driver);
		selectAction.clickAndHold(selectList.get(0)).clickAndHold(selectList.get(1)).clickAndHold(selectList.get(2)).clickAndHold(selectList.get(3)).build().perform();
  	    Thread.sleep(2000);
		driver.close();	
	}

}
