package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ListCustomerPage extends BasePage{
	
WebDriver driver;
	
	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	//webElement
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]") WebElement DELETE_OK_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]") WebElement ADD_CUSTOMER_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]") WebElement SEARCH_BAR_LIST_CUSTOMER_ELEMENT;
	
	
	
	//tbody/tr[1]/td[3]/a
	//tbody/tr[2]/td[3]/a
	//tbody/tr[3]/td[3]/a
	//tbody/tr[1]/td[7]/a[2]
	//tbody/tr[1]/td[7]/a[1]
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";
	String after_xpath_delete = "]/td[7]/a[2]";
	String after_xpath_profile = "]/td[7]/a[1]";
	
	public void validateInsertedNameAndDelete() {
		for(int i = 1; i <= 5; i++) {
			String nameFromList = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			if(nameFromList.contains(AddCustomerPage.getInsertedName())) {
				System.out.println("inserted name exist..");
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
				DELETE_OK_BUTTON_ELEMENT.click();
			}
		}
	}
	
	public void validateListCustomerPage() {
		Assert.assertTrue(ADD_CUSTOMER_BUTTON_ELEMENT.isDisplayed(), "List Customer Page is not available.");
	}
	
	public void clickOnAddCustomerButtonOnListCustomer() {
		ADD_CUSTOMER_BUTTON_ELEMENT.click();
	}
	
	public void insertSearchBarListCustomer() {
		SEARCH_BAR_LIST_CUSTOMER_ELEMENT.sendKeys(AddCustomerPage.getInsertedName());
	}
	
	public void validateInsertedNameOnSearchBarAndProfilePage() {
		for(int i = 1; i <= 5 ; i++) {
			String nameFromList = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			if(nameFromList.contains(AddCustomerPage.getInsertedName())) {
				System.err.println("inserted Name exist...");
				driver.findElement(By.xpath(before_xpath + i + after_xpath_profile)).click();
				break;
			}
		}
	}


}
