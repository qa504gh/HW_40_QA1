package core;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Edge {

	static WebDriver driver;

	public static void main(String[] cla) throws InterruptedException {
		// 	Logger class used to set the log level. setLevel(Level.OFF)>>> turning all logs OFF.
		Logger.getLogger("").setLevel(Level.OFF);

		System.out.println("----- Start of Test: HW_40_QA1 - Edge ---------");
		
		//--- Initiating Chrome Browser
		System.out.println("Browser: Edge");
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		//EdgeOptions option = new EdgeOptions();
	   //((ChromeOptions) option).addArguments("--disable-notifications");

		driver = new EdgeDriver();
		
		//--- Test Start time
		final long start = System.currentTimeMillis();
		System.out.println("Test Start Time: " + start);

		Thread.sleep(1000);
		
		//String timeStampST = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(finish));
		String timeStampST = new SimpleDateFormat("MM.dd.YYYY: HH.mm.ss").format(new Date(start));
		System.out.println("Test Strated: " + timeStampST);
		Thread.sleep(1000);
		
		// Opening in Chrome Browser - URL under the test
		driver.get("http://facebook.com");
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Title: " + driver.getTitle());
		
		// Declaring waiting time
		WebDriverWait wait = new WebDriverWait(driver, 25);
		
		// Login page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("abrleya@yahoo.com");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys(System.getenv("fb_password"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("u_0_b"))).click();
		
		System.out.println("Check 1 - Selecting btn: TimeFrame");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mount_0_0']/div/div[1]/div[1]/div[2]/div[4]/div[1]/div[4]/a/span/span"))).click();
		
		Thread.sleep(4000);	
		System.out.println("Check 2 - Selecting btn: Friends");
		//--- another version for <Selecting btn: Friends>
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://www.facebook.com/leya.abramson/friends']//div//span[@dir='auto']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[3]/div[1]/span[1]"))).click();
		Thread.sleep(5000);	
		
		System.out.println("Check 3 - Selecting inbtn: Friends - Num of Friends");
		String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[3]/div[1]/span/span[2]"))).getText();
		Thread.sleep(5000);	
		System.out.println("You have " + friends + " friends");
		
		System.out.println("Check 4 - Selecting button Account");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[1]/div[2]/div[4]/div[1]/span/div/div[1]/i"))).click();
		
		System.out.println("Check 5 - Exit btn");
		Thread.sleep(3000);	
		String exitBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span"))).getText();
		System.out.println("exitBTN: " + exitBTN + " <- menu text");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span"))).click();
		
		System.out.println("Check EndTime and quit browser");
		Thread.sleep(1000);
		final long finish = System.currentTimeMillis();
		Thread.sleep(1000);
		driver.quit();
		System.out.println("Test End Time: " + finish/1000.0);
	
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(finish));
		String timeStamp = new SimpleDateFormat("MM.dd.YYYY: HH.mm.ss").format(new Date(finish));
		System.out.println("Test Ended: " + timeStamp);
		
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");
		System.out.println("----- End of Test: HW_40_QA1 - Edge ---------");
	}//
}//
