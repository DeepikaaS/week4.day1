package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev64527.service-now.com/navpage.do");
		driver.manage().window().maximize();
		// Moved to Frame
		WebElement frame1 = driver
				.findElement(By.xpath("(//div[@class='navpage-main-left ng-isolate-scope']/iframe)[1]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("Servicenow@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		System.out.println("Came out of frame");
		driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		// String parent = driver.getWindowHandle();
		driver.findElement(By.id("lookup.incident.caller_id")).click();

		driver.switchTo().defaultContent();
		System.out.println("Again Came out of frame");

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> arrayList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(arrayList.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		// driver.switchTo().window(parent);
		driver.switchTo().window(arrayList.get(0));

		WebElement frame3 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame3);
		System.out.println("Again switched to frame");

		driver.findElement(By.id("incident.short_description")).sendKeys("Hi iam typing the value directly ");

		String incidentNo = driver.findElement(By.xpath("//input[@name='incident.number']")).getAttribute("value");
		System.out.println("The New Incident Number is: " + incidentNo);

		driver.findElement(By.xpath("(//button[@value='sysverb_insert'])[2]")).click();
		//System.out.println(driver.switchTo().activeElement());
		//driver.switchTo().defaultContent();
		//System.out.println("came out of window");
		/*
		 * WebElement frame4 =
		 * driver.findElement(By.xpath("//iframe[@name='gsft_main']"));
		 * driver.switchTo().frame(frame4);
		 * System.out.println("Again switched to frame"); driver.findElement(By.xpath(
		 * "//input[@id='eb0e2db687363010d4c6edf73cbb35fb_text']")).sendKeys(incidentNo,
		 * Keys.ENTER);
		 */
		/*
		 * WebElement searchArea =
		 * driver.findElement(By.xpath("//div[@role='search']/input")); WebDriverWait
		 * wait1=new WebDr WebDriverWait wait = new
		 * WebDriverWait(driver,duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.elementToBeClickable(searchArea));
		 * Thread.sleep(4000);
		 */
		driver.findElement(By.xpath("//div[@role='search']/input")).sendKeys(incidentNo, Keys.ENTER);
		String text = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();

		if (incidentNo.contains(text)) {
			System.out.println("The Incident get created");
		} else {
			System.out.println("The incident not get created");
		}

	}

}
