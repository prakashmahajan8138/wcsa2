package generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;



public class BaseTest implements IAutoConstant {
	protected WebDriver driver;
	@BeforeTest
	public void setUp() throws InterruptedException, IOException {

		Flib flib = new Flib();
		//read the browse value
		String browserValue1=flib.readPropertyFile(PROP_PATH,"browser");

		//read the url
		String url=flib.readPropertyFile(PROP_PATH, "url");

		if(browserValue1.equalsIgnoreCase("chrome"))
		{
			//avoid illegal exception
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();//open chrome browser
			driver.manage().window().maximize();//maximize the browser
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.get(url);//launch the web application


		}
		else if(browserValue1.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();//open Firefox browser
			driver.manage().window().maximize();//maximize the browser
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.get(url);//launch the web application



		}
		else
		{
			Reporter.log("invalid choice",true);
		}

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
