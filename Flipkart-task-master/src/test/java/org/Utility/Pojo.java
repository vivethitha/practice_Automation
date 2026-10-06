package org.Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo extends BaseClass {

	public Pojo() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[text()='Home']")

	private WebElement homeIcon;

	public WebElement getHomeIcon() {
		return homeIcon;
	}

	@FindBy(xpath = "//a[text() = 'Cleaning & Bath']")

	private WebElement CleaningandBathTub;

	public WebElement getCleaningandBathTub() {
		return CleaningandBathTub;
	}

	public WebElement getAirFreshners() {
		return airFreshners;
	}

	@FindBy(xpath = "//a[text() = 'Air Fresheners']")

	private WebElement airFreshners;
	
	@FindBy(xpath="//span[text()='Next']")
	private WebElement next;

	@FindBy(xpath="(//div[@class='_36FSn5'])[25]")
	private WebElement wishList;
	
	
	@FindBy(xpath="//p[@class='_1-pxlW']")
	private WebElement loginValidation;
	
	@FindBy(xpath="//button[text()='✕']")
	private WebElement closeButton;
	
	
	public WebElement getNext() {
		return next;
	}

	public WebElement getWishList() {
		return wishList;
	}

	public WebElement getLoginValidation() {
		return loginValidation;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}

	public WebElement getProductClick() {
		return productClick;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getCheckpinCode() {
		return checkpinCode;
	}

	public WebElement getDelieveryText() {
		return delieveryText;
	}

	public WebElement getfAssured() {
		return fAssured;
	}

	public WebElement getFassuredText() {
		return FassuredText;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getPlaceOrder() {
		return placeOrder;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getAddQuantititext() {
		return addQuantititext;
	}

	public WebElement getSaveForLater() {
		return saveForLater;
	}

	public WebElement getRemove() {
		return remove;
	}

	public WebElement getRemove2() {
		return remove2;
	}

	public WebElement getMissingItems() {
		return missingItems;
	}

	@FindBy(xpath="//a[contains(text(),'Odonil Special')]")
	private WebElement productClick;
	
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement pincode;
	
	@FindBy(xpath="//span[text()='Check']")
	private WebElement checkpinCode;
	
	
	@FindBy(xpath="//div[@class='_3XINqE']")
	private WebElement delieveryText;
	
	@FindBy(xpath="//span[@class='b7864- _2Z07dN']")
	private WebElement fAssured;
	
	@FindBy(xpath="//span[text()='Seal of Quality & Speed']")
	private WebElement FassuredText;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//span[text()='Place Order']")
	private WebElement placeOrder;

	@FindBy(xpath="//button[text()='+']")
	private WebElement addButton;
	
	@FindBy(xpath="//div[contains(text(),'You've changed']")
	private WebElement addQuantititext;

	@FindBy(xpath="//div[text()='Save for later']")
	private WebElement saveForLater;

	@FindBy(xpath="//div[text()='Remove']")
	private WebElement remove;

	@FindBy(xpath="(//div[text()='Remove'])[1]")
	private WebElement remove2;

	@FindBy(xpath="//div[text()='Missing Cart items?']")
	private WebElement missingItems;

	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']" )
	private WebElement firstclose;

	public WebElement getFirstclose() {
		return firstclose;
	}

	
	
	
}
