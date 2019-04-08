package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractTest{
	
	@Test(priority=0, description = "Verify the product description by performing a stated flow on Ecommerce Website")
	public void givenTestFlow() {
		homePage_Component.searchProduct();
		homePage_Component.clickSearchButton();
		homePage_Component.selectSize();
		homePage_Component.selectPriceBand();
		homePage_Component.clickSeeMore();
		homePage_Component.selectBrand();
		homePage_Component.selectTshirt();
		homePage_Component.switchNewTab();
		homePage_Component.selectNewSize();
		Assert.assertTrue(homePage_Component.verifyProductDescriptin(),"Verify Product Description");
		
	}

}
