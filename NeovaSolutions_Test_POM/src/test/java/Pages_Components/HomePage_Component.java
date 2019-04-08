package Pages_Components;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import tests.AbstractTest;

public class HomePage_Component extends AbstractTest{

	@FindBy(id ="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(className ="nav-input")
	WebElement searchButton;
	
	@FindBy(id="a-autoid-10-announce")
	WebElement size2XL;
	
	@FindBy(id="a-autoid-0-announce")
	WebElement sortDropdownEle;
	
	@FindBy(id = "s-result-sort-select_2")
	WebElement hightoLow;
	
	@FindBy(xpath ="//span[contains(text(),'Mufti')]")
	WebElement selectBrand;
	
	@FindBy(linkText = "See more")
	WebElement seeMoreLink;
	
	@FindBy(xpath = "//div[@data-asin='B079M4M4S2']")
	WebElement tshirtLink;
	
	@FindBy(id="native_size_name_3")
	WebElement tshirtSizedropdown;
	
	@FindBy(id="feature-bullets")
	WebElement productDescription;
	
	public void searchProduct() {
		searchBox.sendKeys("t-shirt");
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}

	public void selectSize() {
		size2XL.click();
	}
	/*
	 * Select the price band from High to Low
	 */
	public void selectPriceBand() {
		sortDropdownEle.click();
		wait.until(ExpectedConditions.visibilityOf(hightoLow)).click();
	}
	/*
	 * Click link See More to open up all brands page
	 */
	public void clickSeeMore() {
		seeMoreLink.click();
	}
	/*
	 * Select Brand to Mufti
	 */
	public void selectBrand() {
		wait.until(ExpectedConditions.visibilityOf(selectBrand)).click();
	}
	/*
	 * Select First T-shirt
	 */
	public void selectTshirt() {
		tshirtLink.click();
	}
	/*
	 * Switch to new Window as product selection opens up a new Tab
	 */
	public void switchNewTab() {
		
		Set<String> allWindows = driver.getWindowHandles();
		for(String currentWindow : allWindows) {
			if(!driver.getWindowHandle().equals(currentWindow)) {
				driver.switchTo().window(currentWindow);
				
			}
		}
	}
	/*
	 * Select the size of T-Shirt to XXL 
	 */
	public void selectNewSize() {
		tshirtSizedropdown.click();
	}
	/*
	 * Get the Product Description from UI
	 */
	public String getProductDescription() {
		return productDescription.getText();
	}
	/*
	 * Verify Product Description
	 * expectedValue : Data from Services
	 * actualValue : Data from UI
	 * @return : boolean True if expected and actual values are equal else returns False
	 */
	public boolean verifyProductDescriptin() {
		String expectedValue = homePage_Data.productDescriptionFromServices().replaceAll("\\s","");
		String actualValue = getProductDescription().replaceAll("\\s","");
		return expectedValue.equals(actualValue);
	}
}
