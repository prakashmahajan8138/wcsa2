package generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverCommonLib extends BaseTest{

	public void verifyPageTitle(String expectedTitle,String pageName)
	{
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("The title is matched for "+pageName);
		}
		else
		{
			System.out.println("The title is not matched for "+pageName);
		}
	}

	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}

	public void switchToFrame(String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}

	public void switchToFrame(WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}

	public void maximizeTheBrowser()
	{
		driver.manage().window().maximize();
	}

	public void selectOptionOfDropDown(WebElement ssd, int index) throws InterruptedException
	{
		Select sel = new Select(ssd);
		Thread.sleep(3000);
		sel.selectByIndex(index);
	}
	public void selectOptionOfDropDown(WebElement ssd, String Value) throws InterruptedException
	{
		Select sel = new Select(ssd);
		Thread.sleep(3000);
		sel.selectByValue(Value);
	}
	public void selectOptionOfDropDown(String text, WebElement ssd) throws InterruptedException
	{
		Select sel = new Select(ssd);
		Thread.sleep(3000);
		sel.selectByVisibleText(text);
	}

	public void acceptAlertPopup()
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void acceptConfirmationPopup()
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void dismissConfirmationPopup()
	{
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public void rightClick(WebElement target)
	{
		Actions ts = new Actions(driver);
		ts.contextClick(target).perform();
	}
	public void doubleClickFeatures(WebElement target)
	{
		Actions ts = new Actions(driver);
		ts.doubleClick(target).perform();
	}
	public void mouseHover(WebElement target)
	{
		Actions ts = new Actions(driver);
		ts.moveToElement(target).perform();
	}

	public void dragAndDropFeatures(WebElement source, WebElement destination)
	{
		Actions ts = new Actions(driver);
		ts.dragAndDrop(source, destination).perform();
	}

	public void hitTheButton() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void copyTheText() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	public void pasteTheText() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	public void scrollup(int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+pixelCount+")");
	}

	public void scrolldown(int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+(-pixelCount)+")");
	}

	public void scrollLeft(int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+(-pixelCount)+",0)");
	}

	public void scrollRight(int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+pixelCount+",0)");
	}

	public void scrollTillAParticularWebElement(WebElement target)
	{
		Point loc = target.getLocation();
		int xaxis = loc.getX();
		int yaxis = loc.getY();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+xaxis+","+yaxis+")");
	}

	public void getAllOptionsOfDropDown(WebElement element)
	{
		Select sel = new Select(element);
		List<WebElement> allops = sel.getAllSelectedOptions();

		for(WebElement op:allops)
		{
			String text = op.getText();
			System.out.println(text);
		}
	}
}