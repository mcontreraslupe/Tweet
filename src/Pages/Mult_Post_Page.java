package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Test.ts_MultiPost;
import configurations.Settings;

public class Mult_Post_Page {
	
	By txt_post = By.id("tweet-box-home-timeline");
	By btn_post = By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/form/div[3]/div[2]/button");
	By btn_exp = By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[4]/div[2]/ol[1]/li[1]/div/div[2]/div[1]/div/div/button");
	By btn_Del = By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[4]/div[2]/ol[1]/li[1]/div/div[2]/div[1]/div/div/div/ul/li[6]/button");
	By aler_msg = By.xpath("/html/body/div[3]/div/div/span");
	By btn_conf = By.xpath("//html/body/div[33]/div/div[2]/div[4]/button[2]");
	By btn_after = By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[4]/div[2]/ol[1]/li[1]/div/div[2]/div[3]/div[2]/div[4]/button");
	By btn_new = By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[4]/div[1]/button");
	By btn_post_del = By.xpath("//*[@id=\"stream-item-tweet-1107653873655795712\"]");
	By btn_post_ex = By.xpath("//html/body/div[45]/div[2]/div[3]/div/div/div[1]/div[1]/div/div[1]/div/div/div");
	By btn_post_del_conf = By.xpath("//*[@id=\"permalink-overlay-body\"]/div/div[1]/div[1]/div/div[1]/div/div/div/div/ul/li[8]/button");
	By btn_post_del_reconf = By.xpath("//*[@id=\"delete-tweet-dialog-dialog\"]/div[2]/div[4]/button[2]");
	By btn_comment = By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[4]/div[2]/ol[1]/li[1]/div[1]/div[2]/div[3]/div[2]/div[1]/button");
	By aler_del = By.className("alert-messages hidden");   
	WebDriver driver;

	public Mult_Post_Page(WebDriver driver){
		 
        this.driver = driver;
	}
		
	public void setPost	(String strPost){
		driver.findElement(txt_post).sendKeys(strPost);
	}
	
	public void clickPosts(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(txt_post).click();		
	}
	
	public String twweetId(WebDriver driver) throws InterruptedException, AWTException{
		Settings Opciones;
		Opciones = new Settings();
	
		Opciones.TabKeys(8);
		String ValueAttribute = Opciones.GetElementsAttribute(btn_comment, "aria-describedby", driver);
		String locator = ValueAttribute.substring(38, ValueAttribute.length());
		return locator;	
	}
	
	public void clickPost()
	{	
		Settings Opciones;
		Opciones = new Settings();
		
		WebDriverWait wait = new WebDriverWait(driver, Opciones.waitingtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(btn_post));				
		driver.findElement(btn_post).click();							
	}
	
	public void clickBtnNew()
	{		
		Settings Opciones;
		Opciones = new Settings();
		
		WebDriverWait wait = new WebDriverWait(driver, Opciones.waitingtime);
		wait.until(ExpectedConditions.elementToBeClickable(btn_new));		
		driver.findElement(btn_new).click();							
	}
	
	public void clickExp()
	{
		Settings Opciones;
		Opciones = new Settings();
		
		WebDriverWait wait = new WebDriverWait(driver, Opciones.waitingtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(btn_new));
		
		driver.findElement(btn_exp).click();
	}
	
	public void ClickDel(String TweetId, WebDriver driver) throws AWTException, InterruptedException
	{
		
		Settings Opciones;
		Opciones = new Settings();
		
        String FirstPartLocator = "stream-item-tweet-";
		By btn_post_del = By.xpath("//*[@id=\"" + FirstPartLocator + TweetId + "\"]");
//		System.out.print(btn_post_del);
		WebDriverWait wait = new WebDriverWait(driver, Opciones.waitingtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(btn_post_del));
		wait.until(ExpectedConditions.elementToBeClickable(btn_post_del));
		Thread.sleep(1000);	
		driver.findElement(btn_post_del).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(btn_post_ex));		
		driver.findElement(btn_post_ex).click();
		Opciones.EnterKeys(0);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(btn_post_del_conf));
		
		wait.until(ExpectedConditions.elementToBeClickable(btn_post_del_conf));
		driver.findElement(btn_post_del_conf).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(btn_post_del_reconf));		
		driver.findElement(btn_post_del_reconf).click();
	}
	
	public void ClickConf()
	{
		driver.findElement(btn_conf).click();		
	}
	
	public void post(String strPost, WebDriver Driver) throws InterruptedException, AWTException	
	{
		Settings Opciones;
		Opciones = new Settings();
		
		this.setPost(strPost);
		this.clickPost();
		this.clickBtnNew();
		this.clickPosts(Driver);
	}
	
	public void  DeletePost() throws AWTException, InterruptedException	
	{
		Settings Opciones;
		Opciones = new Settings();
						
		this.ClickDel(null, driver);
				
		WebDriverWait wait = new WebDriverWait(driver, Opciones.waitingtime);
		wait .until(ExpectedConditions.elementToBeClickable(btn_after));
		
	}
	
	public void close()
	{
		driver.close();
	}
	
	public void CleanTest(ArrayList<String> DelID , WebDriver driver) throws AWTException, InterruptedException {
		
		for(int i=0; i < DelID.size() ;i++)
        {
			this.ClickDel(DelID.get(i),driver);	
        }
		this.close();			
	}
}
