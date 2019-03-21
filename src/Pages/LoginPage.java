package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import configurations.Settings;

//import Test.ts_Post;

public class LoginPage {
	
	WebDriver driver;
	By txt_mail = By.xpath("//*[@id=\"doc\"]/div/div[1]/div[1]/div[1]/form/div[1]/input");
	By txt_pass = By.xpath("//*[@id=\"doc\"]/div/div[1]/div[1]/div[1]/form/div[2]/input");
	By btn_login = By.xpath("//*[@id=\"doc\"]/div/div[1]/div[1]/div[1]/form/input[1]");
	By txt_post = By.id("tweet-box-home-timeline");
	By btn_post = By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div/form/div[3]/div[2]/button");
	By Logo_Twitt = By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[1]/span");
	
	public LoginPage(WebDriver driver){
		 
        this.driver = driver;
        
    }
	public void setMail	(String strMail)
	{
		Settings Opciones;
		Opciones = new Settings();
		WebDriverWait wait = new WebDriverWait(driver, Opciones.waitingtime);
		wait .until(ExpectedConditions.presenceOfElementLocated(Logo_Twitt));
		driver.findElement(txt_mail).click();
		driver.findElement(txt_mail).sendKeys(strMail);
	}
	
	public void setPass	(String strPass)
	{
		driver.findElement(txt_pass).click();
		driver.findElement(txt_pass).sendKeys(strPass);
	}
	
	public void clickLogin()
	{
		Settings Opciones;
		Opciones = new Settings();
		driver.findElement(btn_login).click();
	}
	
	public void login(String strMail, String strPass)	
	{
		this.setMail(strMail);
		this.setPass(strPass);
		this.clickLogin();
	}
}
