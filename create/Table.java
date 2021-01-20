package create;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.findElement(By.xpath("//a[@href='pages/table.html']")).click();
		List<WebElement> rows =driver.findElements(By.xpath("//*[@id=\"table_id\"]/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("No of rows :" +rowCount );
		List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"table_id\"]/tbody/tr[1]/th"));
		int columnCount = columns.size();
		System.out.println("Number of columns: " +columnCount);
		String progressVal = driver.findElement(By.xpath("//*[@id=\"table_id\"]/tbody/tr[4]/td[2]")).getText();
		System.out.println("Progress value of interact with elements : " +progressVal);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='vital'])[3]")).click();
		Thread.sleep(2000);
		String bxpath = "//*[@id=\"table_id\"]/tbody/tr[";
		String axpath = "]/td[5]";
		System.out.println("Mentor List : ");
		for(int i=2;i<=rowCount;i++) {
			String actxpath = bxpath+i+axpath;
			String mentorList = driver.findElement(By.xpath(actxpath)).getText();
			System.out.println(mentorList);
			}
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.close();
	}

}
