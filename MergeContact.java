package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();

driver.get("http://leaftaps.com/opentaps/control/login");
driver.manage().window().maximize();
driver.findElement(By.id("username")).sendKeys("demosalesmanager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.xpath("//input[@type='submit']")).click();
driver.findElement(By.xpath("//div[@id='label']/a")).click();
driver.findElement(By.xpath("//a[text()='Contacts']")).click();
driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
driver.findElement(By.xpath("(//table[@id='widget_ComboBox_partyIdFrom'])/following-sibling::a")).click();
Thread.sleep(3000);
Set<String> windowHandles = driver.getWindowHandles();

List<String> arrayList = new ArrayList<String>(windowHandles);
driver.switchTo().window(arrayList.get(1));
System.out.println("passed1");
Thread.sleep(2000);
System.out.println("passed2");
driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')])[1]/a")).click();

Thread.sleep(3000);
driver.switchTo().window(arrayList.get(0));
//After 36 if the 40th line executed then it will throw NoSuchWindowException
driver.findElement(By.xpath("(//table[@id='widget_ComboBox_partyIdTo'])/following-sibling::a")).click();
Set<String> windowHandles1 = driver.getWindowHandles();

List<String> arrayList1 = new ArrayList<String>(windowHandles1);
driver.switchTo().window(arrayList1.get(1));
Thread.sleep(3000);
driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')])[2]/a")).click();
driver.switchTo().window(arrayList1.get(0));
driver.findElement(By.xpath("//a[text()='Merge']")).click();
//Alert

Alert alert=driver.switchTo().alert();
alert.accept();
String title = driver.getTitle();
System.out.println(title);

if(title.equals("View Contact | opentaps CRM"))
{
	System.out.println("Verified and same ");
}

driver.quit();
//driver.close();
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
	}

}
