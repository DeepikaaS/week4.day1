package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
//Number of Frames on a Page
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		int countIframesInPage = iframeList.size();
//int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of Frames on a Page:" + countIframesInPage);
		WebElement frame1 = driver.findElement(By.xpath("(//div[@id='wrapframe'])[1]/iframe[1]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("(//button[text()='Click Me'] )")).click();
		Thread.sleep(2000);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snap1/handle.png");
		FileUtils.copyFile(screenshotAs, dst);
		/*
		 * File src1 = driver.getScreenshotAs(OutputType.FILE); File dst = new
		 * File("./Frames/frame1.png"); FileUtils.copyDirectory(src1, dst);
		 */
		System.out.println("The screenshot is took");
//driver.findElement(By.id("Click")).click();

		String text1 = driver.findElement(By.id("Click")).getText();
		System.out.println("The click me text in button changed to :" + text1);
		driver.switchTo().defaultContent();

		WebElement frame2 = driver.findElement(By.xpath("(//div[@id='wrapframe'])[2]/iframe[1]"));
		driver.switchTo().frame(frame2);
//switching to inner frame
		driver.switchTo().frame(0);
		WebElement secondbutton = driver.findElement(By.xpath("(//button[text()='Click Me'] )"));
		secondbutton.click();
//driver.findElement(By.id("Click1")).click();
		String text2 = secondbutton.getText();
		System.out.println("The  second frame click me text in button changed to :" + text2);
		driver.switchTo().defaultContent();
		WebElement frame3 = driver.findElement(By.xpath("//div[@id='wrapframe'][3]/iframe"));
		driver.switchTo().frame(frame3);
//Number of Frames on a Page
//List<WebElement> iframeList3 = driver.findElements(By.tagName("iframe"));
//int countIframes3  = iframeList3.size();
		int countIframes3 = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of Frames on a Page:" + countIframes3);
//driver.close();
	}

}
