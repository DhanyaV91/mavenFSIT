package mavenfsit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class mavenfsitproj {
	  WebDriver driver;
	
	  @Test(dataProvider = "dp")
	  public void testcase(String n, String s) throws InterruptedException {
		  driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(n);
		  driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(s);
		  driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id='welcome']")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();	  
	  }

	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "Admin", "admin123" },
	      new Object[] { "linda.anderson", "linda.anderson" },
	    };
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize();	  
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }
}
