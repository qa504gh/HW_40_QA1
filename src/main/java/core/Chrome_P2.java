package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_P2 {

	static WebDriver driver;

	public static void main(String[] cla) throws InterruptedException {
		Logger.getLogger("").setLevel(Level.OFF);
		System.out.println("Browser: Chrome");
		System.setProperty("webdriver.chrome.driver", "/WebDrivers/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		System.out.println("Title: " + driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("abrleya@yahoo.com");
		Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys(System.getenv("fb_password"));
		Thread.sleep(1000);
		driver.findElement(By.id("u_0_b")).click();
		Thread.sleep(5000);
		System.out.println("Check 0");
		driver.findElement(By.xpath("//*[@id='mount_0_0']/div/div[1]/div[1]/div[2]/div[4]/div[1]/div[4]/a/span/span")).click();
		Thread.sleep(5000);
		System.out.println("Check 1");
		
		Thread.sleep(2000);	
		System.out.println("Check 2 - Selecting btn: Friends");
		//--- another version for <Selecting btn: Friends>
		driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[3]/div[1]/span[1]")).click();
		
		String friends = driver.findElement(By.xpath("//div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[3]/div[1]/span/span[2]")).getText();
		Thread.sleep(1000);
		System.out.println("You have " + friends + " friends");
		
		System.out.println("Check 2");
				Thread.sleep(1000);	
		driver.findElement(By.xpath("//div[1]/div[2]/div[4]/div[1]/span/div/div[1]/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span")).click();
		driver.quit();
	}
}