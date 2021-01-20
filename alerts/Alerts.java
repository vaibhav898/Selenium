package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

		public static void main(String[] args) throws InterruptedException {
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.get("http://www.leafground.com/");
				driver.findElement(By.xpath("//a[@href='pages/Alert.html']")).click();
				driver.findElement(By.xpath("//button[@onclick='normalAlert()']")).click();
				Thread.sleep(1000);
				Alert alertOne = driver.switchTo().alert();
				System.out.println("Alert-1: " +alertOne.getText());
				Thread.sleep(1000);
				alertOne.accept();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@onclick='confirmAlert()']")).click();
				Alert alertTwo = driver.switchTo().alert();
				System.out.println("Alert-2: " +alertTwo.getText());
				Thread.sleep(1000);
				alertTwo.accept();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@onclick='confirmPrompt()']")).click();
				Alert alertThree = driver.switchTo().alert();
				alertThree.sendKeys("Tech Marshals");
				System.out.println("Alert-3: " +alertThree.getText());
				Thread.sleep(2000);
				alertThree.accept();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@onclick='lineBreaks()']")).click();
				Alert alertFour = driver.switchTo().alert();
				System.out.println("Alert-4: " +alertFour.getText());
				Thread.sleep(1000);
				alertFour.accept();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@onclick='sweetalert()']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/button")).click();
				Thread.sleep(1000);
				driver.navigate().back();
				Thread.sleep(1000);
				driver.close();
			}
		}


