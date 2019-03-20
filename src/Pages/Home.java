package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Settings;

public class Home {
	By txt_post = By.id("tweet-box-home-timeline");
	By btn_post = By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/form/div[3]/div[2]/button");
	By btn_exp = By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[4]/div[2]/ol[1]/li[1]/div/div[2]/div[1]/div/div/button");
	By btn_Del = By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[4]/div[2]/ol[1]/li[1]/div/div[2]/div[1]/div/div/div/ul/li[6]/button");
	By aler_msg = By.xpath("/html/body/div[3]/div/div/span");
	By btn_conf = By.xpath("/html/body/div[33]/div/div[2]/div[4]/button[2]");
	By btn_after = By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[4]/div[2]/ol[1]/li[1]/div/div[2]/div[3]/div[2]/div[4]/button");
	By btn_new = By.xpath("//*[@id=\"timeline\"]/div[4]/div[1]/button");
	WebDriver driver;
	public Home(WebDriver driver){
		 
        this.driver = driver;
	}
	
	
	public void setPost	(String strPost)
	{
		driver.findElement(txt_post).sendKeys(strPost);
	}
	
	public void clickPost()
	{
		boolean text_found = false;
		Settings Opciones;
		Opciones = new Settings();
		driver.findElement(btn_post).click();
		WebDriverWait wait = new WebDriverWait(driver, Opciones.waitingtime);
		
		text_found = Opciones.TextLookFor("See 1 new Tweet", driver);
		
		if (text_found == true)
		{
			
		}
//		wait .until(ExpectedConditions.urlContains(Opciones.baseURL));
		wait .until(ExpectedConditions.presenceOfElementLocated(aler_msg));
		
	}
	
	public void clickExp()
	{
		Settings Opciones;
		Opciones = new Settings();
		
		
		
		 
				 
		WebDriverWait wait = new WebDriverWait(driver, Opciones.waitingtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(btn_new));
//		wait .until(ExpectedConditions.presenceOfElementLocated(btn_exp));
		
		driver.findElement(btn_exp).click();
	}
	
	public void ClickDel(WebDriver driver)
	{
		
		Settings Opciones;
		Opciones = new Settings();
		
//		Opciones.ScrollToElement(driver, "Delete Tweet");
		driver.findElement(btn_Del).click();
//		WebDriverWait wait = new WebDriverWait(driver, Opciones.waitingtime);
//		wait .until(ExpectedConditions.urlContains(Opciones.baseURL));
		
	}
	
	public void ClickConf()
	{
		Settings Opciones;
		Opciones = new Settings();
		driver.findElement(btn_conf).click();
//		WebDriverWait wait = new WebDriverWait(driver, Opciones.waitingtime);
//		wait .until(ExpectedConditions.urlContains(Opciones.baseURL));
		
	}
	
	public void post(String strPost)	
	{
		Settings Opciones;
		Opciones = new Settings();
		
		this.setPost(strPost);
		this.clickPost();
		this.clickExp();
				
		
	}
	
	public void DeletePost()	
	{
		Settings Opciones;
		Opciones = new Settings();
		
		
		this.ClickDel(driver);
		this.ClickConf();
		
		WebDriverWait wait = new WebDriverWait(driver, Opciones.waitingtime);
		wait .until(ExpectedConditions.elementToBeClickable(btn_after));
		
		
	}

}
