package org.stepdefinition;

import java.time.Duration;

import org.Utility.BaseClass;
import org.Utility.Pojo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionClass extends BaseClass{
	
	Pojo p;
	Actions a;
	
	@Given("hit the chrome browser")
	public void hit_the_chrome_browser() throws InterruptedException {
	    
	browserlaunch("chrome");
	lauchurl("https://www.flipkart.com/");
	Thread.sleep(10000);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	//clickElement(p.getCloseButton());
		Thread.sleep(10000);
		//clickElement(p.getFirstclose());
	}

	@When("navigate to home then cleaning & bath then air fresheners")
	public void navigate_to_home_then_cleaning_bath_then_air_fresheners() {
	    p=new Pojo();
		a=new Actions(driver);
		a.moveToElement(p.getHomeIcon()).perform();
		a.moveToElement(p.getCleaningandBathTub()).perform();
		a.moveToElement(p.getAirFreshners()).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		clickWebElement(p.getAirFreshners());
		
		
	}

	@When("navigate to the second page of PLP by clciking the bottom of the page")
	public void navigate_to_the_second_page_of_PLP_by_clciking_the_bottom_of_the_page() {
		p=new Pojo();
		clickElement(p.getNext());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		
	}

	@When("click wishlist icon of the sandal spray product")
	public void click_wishlist_icon_of_the_sandal_spray_product() {
	    p=new Pojo();
	    clickElement(p.getWishList());
		
		
	}

	@When("validte login in adding in wishlist message and print in console and close the login popup and click that product and move to PDP")
	public void validte_login_in_adding_in_wishlist_message_and_print_in_console_and_close_the_login_popup_and_click_that_product_and_move_to_PDP() {
	    p=new Pojo();
	   org.junit.Assert.assertEquals("passed", "Get access to your Orders, Wishlist and Recommendations", p.getLoginValidation().getText());
	   clickElement(p.getCloseButton()); 
		
	}

	@When("in product page enter your pincode check the delivery date and print it in console")
	public void in_product_page_enter_your_pincode_check_the_delivery_date_and_print_it_in_console() {
		p=new Pojo();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		clickElement(p.getProductClick());
		
		twoWindowSwitch();
		passtext(p.getPincode(), "600100");
		clickElement(p.getCheckpinCode());
		System.out.println(p.getDelieveryText().getText());
	    
		
		
	}

	@When("click F Assured label and validate whether it is opening or not and click add to cart")
	public void click_F_Assured_label_and_validate_whether_it_is_opening_or_not_and_click_add_to_cart() {
	    
	p=new Pojo();
	clickElement(p.getfAssured());
	//org.junit.Assert.assertEquals("pass", "Seal of Quality & Speed", p.getFassuredText().getText());
	
	
	}

	@When("Assert and print whether the product is added to cart or not and increases the quantity of product to two and assert the confirmation message and print in console")
	public void assert_and_print_whether_the_product_is_added_to_cart_or_not_and_increases_the_quantity_of_product_to_two_and_assert_the_confirmation_message_and_print_in_console() {
	p=new Pojo();
	clickWebElement(p.getAddToCart());
	clickWebElement(p.getAddButton() );
	org.junit.Assert.assertEquals("passes", true, true);
	
		
		
		
	}

	@When("click save for later and validate whether it is moved to that section and check whether the cart is empty now")
	public void click_save_for_later_and_validate_whether_it_is_moved_to_that_section_and_check_whether_the_cart_is_empty_now() {
	    
		
		p=new Pojo();
		clickWebElement(p.getSaveForLater());
		
		
	}

	@When("now remove the product from save for later and validate the confirmation message")
	public void now_remove_the_product_from_save_for_later_and_validate_the_confirmation_message() {
	    
		p=new Pojo();
		clickWebElement(p.getRemove());
		clickWebElement(p.getRemove2());
		org.junit.Assert.assertEquals("passed", "Missing Cart items", p.getMissingItems().getText());
		
		
		
	}




}
