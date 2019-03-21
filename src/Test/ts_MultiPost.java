package Test;

import java.awt.AWTException;
//import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import Pages.Mult_Post_Page;
import Pages.LoginPage;
import configurations.Settings;

public class ts_MultiPost {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		Settings Opciones;
		Mult_Post_Page obj_Mult_Post_Page;
		LoginPage obj_pageLogin;
		WebDriver driver;
			
		Opciones = new Settings();
		
		driver = Opciones.MultiDriver("chrome");
		
		obj_pageLogin= new LoginPage(driver);
		obj_Mult_Post_Page= new Mult_Post_Page(driver);			
		driver.manage().window().fullscreen();
		driver.get(Opciones.baseURL);
		obj_pageLogin.login("josedanielperezpera@gmail.com", "DaniPerez123456789");
		
		ArrayList<String> tweetText = new ArrayList<>(Arrays.asList("Me siento Feliz", "Me siento Alegre", "Me siento Cansado"));
		ArrayList<String> newIdPots = new ArrayList<String>();
			
		for(int i=0; i < tweetText.size() ;i++)
        {
			obj_Mult_Post_Page.post(tweetText.get(i), driver);
			newIdPots.add(obj_Mult_Post_Page.obtainTweetId(driver));					
        }
		
		Random rnd = new Random();
//		System.out.println(rnd.nextInt(3));
		int DelID = rnd.nextInt(3);
		obj_Mult_Post_Page.ClickDel(newIdPots.get(DelID),driver);
		newIdPots.remove(DelID);
		Thread.sleep(1000);		
//		System.out.print(newIdPots);
		
//		**********Clean Test***************
		
		obj_Mult_Post_Page.CleanTest(newIdPots,driver);
	}
}
