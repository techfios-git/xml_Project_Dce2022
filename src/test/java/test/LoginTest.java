package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"userName", "password"})
	public void userShouldBeAbleToLogin(String userName, String password) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.validateDashboardPage();
		
		BrowserFactory.tearDown();
	}

}
