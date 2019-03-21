package Test;

import org.openqa.selenium.WebDriver;

import Pages.Home;
import Pages.LoginPage;
import configurations.Settings;

public class ts_Post {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Settings Opciones;
		Home obj_home;
		LoginPage obj_pageLogin;
		WebDriver driver;
			
		Opciones = new Settings();
		
		driver = Opciones.MultiDriver("chrome");

		obj_pageLogin= new LoginPage(driver);
		obj_home= new Home(driver);
//				
		driver.manage().window().fullscreen();
		driver.get(Opciones.baseURL);
		obj_pageLogin.login("josedanielperezpera@gmail.com", "DaniPerez123456789");
		obj_home.post("Me siento Feliz");
		obj_home.DeletePost();
		
		driver.close();
	}
}
