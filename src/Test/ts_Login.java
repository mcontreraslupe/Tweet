package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import configurations.Settings;
import Pages.LoginPage;

public class ts_Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Settings Opciones;
		LoginPage obj_pageLogin;
		WebDriver driver;
	
		Opciones = new Settings();
//		driver = Opciones.MultiDriver("firefox");
//				
//		obj_pageLogin= new LoginPage(driver);
		
		System.setProperty(Opciones.DriverFirefox, Opciones.DriverFirefoxRoute );
//		driver = new ChromeDriver();
		driver = new FirefoxDriver();
		obj_pageLogin= new LoginPage(driver);
				
		driver.manage().window().fullscreen();
		driver.get(Opciones.baseURL);
		
		obj_pageLogin.login("josedanielperezpera@gmail.com", "DaniPerez123456789");
		
		
		

	}

}
