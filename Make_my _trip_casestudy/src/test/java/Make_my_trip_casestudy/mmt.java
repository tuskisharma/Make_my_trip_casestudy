package Make_my_trip_casestudy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mmt extends util{
	public String url="https://www.makemytrip.com/";
	WebDriver driver;
	@BeforeTest
	public void BT() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test(enabled=true,priority = 0)
	public void tc1() throws InterruptedException{
		Actions act=new Actions(driver);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Holiday Packages']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='lbl_input makeFlex column latoBold']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Bangalore']")).click();
		Thread.sleep(3000);
	    driver.findElement(By.id("toCity")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@class='dest-search-input']")).sendKeys("singapore");
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Singapore']")).click();
	    Thread.sleep(3000);
		driver.findElement(By.id("search_button")).click();
		Thread.sleep(3000);
	}
	@Test(enabled=true,priority = 1)
	public void tc2() throws InterruptedException,IOException{
		Actions act=new Actions(driver);
	driver.findElements(By.xpath("//*[@class='modify-search_input ']")).get(2).click();
	Thread.sleep(10000);
	WebElement u5=driver.findElement(By.xpath("//*[text()='15']"));
	util.clickElementByJS(u5, driver);
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@class='primaryBtn big fill btn btn-top-nav btn-lg']")).click();
	Thread.sleep(10000);
	WebElement   a=driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div[4]/div/div[1]/div[2]/div/div/div[1]/div/div[5]"));
	act.dragAndDropBy(a, -170, 0).build().perform();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[text()='A Short Trip to Singapore']")).click();
	Thread.sleep(5000);
	System.out.println(driver.getTitle());
}
	@Test(enabled=true,priority = 2)
	public void tc3()throws InterruptedException,IOException{
		Actions act=new Actions(driver);
		ArrayList<String> tab=new ArrayList<String>(driver.getWindowHandles());
		int a=tab.size();
		System.out.println(a);
		driver.switchTo().window(tab.get(1));
 		Thread.sleep(5000);
		WebElement   d=driver.findElement(By.xpath("//*[@class='hotel-row-wrapper ']/div/div/div/span"));
		util.scrollIntoView(d, driver);
		util.clickElementByJS(d, driver);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='sidePanelBody']/div[3]/div[2]/div[7]/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='makeFlex column packageUpdate']/div/p")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@class='add-activity-container']/div[2]/span")).click();
		Thread.sleep(6000);
		WebElement    w=driver.findElement(By.xpath("//*[@class='sidePanelBody']/div[9]/div[2]/div[3]/span"));
		util.scrollIntoView(w, driver);
		util.clickElementByJS(w, driver);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@class='makeFlex column packageUpdate']/div/p")).click();
	}
	@Test(enabled = true,priority = 3)
	public void tc4() throws InterruptedException,IOException{
		driver.findElement(By.xpath("//*[@class='initerary-nav']/li[2]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@class='initerary-nav']/li[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='initerary-nav']/li[4]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='initerary-nav']/li[5]")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
