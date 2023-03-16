package NdzLaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Product {
//	public static WebDriver driver;
	public Search_Product(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement  searchButtonWebElemnt;
	
	@FindBy(name = "search")
	private WebElement  searchBarWebElemnt;
	
	public WebElement getSearchButtonWebElemnt() {
		return searchButtonWebElemnt;
	}

	public WebElement getSearchBarWebElemnt() {
		return searchBarWebElemnt;
	}
	
	@FindBy(xpath="//header/descendant::button/child::span[text()='Add']")
	private WebElement addtocart;
	
	@FindBy(xpath="//button/child::span[text()='plus']/parent::button")
	private WebElement quantityPlus;

	public WebElement getQuantityPlus() {
		return quantityPlus;
	}

	public WebElement getAddtocart() {
		return addtocart;
	}
	
	public WebElement Task(WebDriver driver) {
		Actions ac = new Actions(driver);
		ac.moveToElement(getAddtocart()).perform();
		getAddtocart().click();
		return addtocart;
				
	}
	
}
