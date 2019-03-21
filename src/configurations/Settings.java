package configurations;
import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class Settings {
	public String baseURL = "https://twitter.com/";
	public String DriverChrome = "webdriver.chrome.driver";
	public String DriverChromeRoute = "C:\\Users\\Hideki\\eclipse-workspace\\Libs\\selenium\\chromedriver.exe";
	public String DriverFirefox = "webdriver.gecko.driver";
	public String DriverFirefoxRoute = "C:\\Users\\Hideki\\eclipse-workspace\\Libs\\selenium\\geckodriver.exe";
	public int waitingtime = 30;
	
	public WebDriver MultiDriver(String Browser)
	{
		WebDriver driver = null;
		switch(Browser.toLowerCase())
		{
		case "chrome": 
		
			System.setProperty(DriverChrome, DriverChromeRoute );
			driver = new ChromeDriver();
			
			break;
		case "firefox": 
			
			System.setProperty(DriverFirefox, DriverFirefoxRoute );
			driver = new FirefoxDriver();
				
			break;
			
		case "IExplorer": 
			
			break;	
		default:
			System.out.print("Unable to Select Browser");
			break;	
		}
		
		return driver;

	}
	
	public boolean TextTweetDel(By tweetDelMesages, WebDriver driver) {
		boolean response;
		Boolean WarningElements = driver.findElements(tweetDelMesages).size() > 0;
		System.out.print("this is the web list: " + WarningElements + "\n");
		if(WarningElements == true) {
			response = true;
			System.out.println("Text found " + "\n");
		}
		
		else
			
		{
			System.out.println("Text not found " + "\n");
			response = false;
		}
		
		return response;
	}
	
	
	public void ScrollToElement(WebDriver driver, String ElementToScroll){
    	
    	JavascriptExecutor je = (JavascriptExecutor) driver;
		   	
    	//FIRST METHOD, identified the element where we need to scroll
		WebElement element = driver.findElement((By.xpath("//*[contains(text(), '" + ElementToScroll + "')]")));
		
		//with a javascript we make the scroll
		je.executeScript("arguments[0].scrollIntoView(true);",element);	
    }
	
	public String GetElementsAttribute(By Locator, String attributeName, WebDriver driver)
	{	
		String attribute = driver.findElement(Locator).getAttribute(attributeName);
						
		return attribute;	
	}
		
	public boolean TextLookFor(String text_look_for, WebDriver driver) {
		boolean response;
		
		java.util.List<WebElement> WarningElements = driver.findElements(By.xpath("//*[contains(text(),'" + text_look_for + "')]"));
		System.out.print("this is the web list: " + WarningElements + "\n");
		
		if(WarningElements.size() > 0) {
			response = false;
			System.out.println("Text found Text Look For");
		}
		
		else
			
		{
			System.out.println("Text not found Text Look for");
			response = true;
		}
		
		return response;
	}
	
	public void EnterKeys(int iterations) throws AWTException, InterruptedException {
				
		//Use this robot to upload the file
		Robot robot = new Robot();
		
		for(int i=0;i<=iterations;i++)
        {
			Thread.sleep(100);
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
//			System.out.println(iterations);
			
        }
	}
		
		public void TabKeys(int iterations) throws AWTException, InterruptedException {
			
			//Use this robot to upload the file
			Robot robot = new Robot();
			
			for(int i=0;i<=iterations;i++)
	        {
				Thread.sleep(100);
				robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
//				robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
//				System.out.println(iterations);
	        }
	}
		public Boolean ElementIsNotPresentByLocator(WebDriver driver, By Locator){
	    	
	    	Boolean isPresent = driver.findElements(Locator).size() > 0;
	    	
	    	return isPresent;
	    }
}
