package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		 driver.manage().window().maximize();
		 driver.switchTo().frame("frame1");
		 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
		 driver.switchTo().frame("frame3");
		 driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame("frame2");
		 WebElement drop1 = driver.findElement(By.id("animals"));
		 Select select = new Select(drop1);
		 select.selectByIndex(0);
		 driver.switchTo().defaultContent();
		 System.out.println("The program ends");
		 Thread.sleep(2000);
		 driver.close();
		 
		 
	}

}
