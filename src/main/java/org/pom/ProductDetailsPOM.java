package org.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.utilites.ClassUtilites;

public class ProductDetailsPOM extends ClassUtilites {

	public ProductDetailsPOM() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	private WebElement productName;

	public WebElement getproductName() {
		return productName;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement productSearch;

	public WebElement getproductSearch() {
		return productSearch;
	}

	@FindBy(xpath = "//span[@class='BUOuZu']")
	private WebElement totalProduct;

	public WebElement gettotalProduct() {
		return totalProduct;
	}

	@FindBys({ @FindBy(xpath = "//div[@class='KzDlHZ']") })
	private List<WebElement> productList;

	public List<WebElement> getproductList() {
		return productList;
	}

	@FindBys({ @FindBy(xpath = "(//div[contains(@class, 'BfVC2z')]//div[@class='hl05eU'])//div[1]") })
	private List<WebElement> productPrice;

	public List<WebElement> getproductPrice() {
		return productPrice;
	}

}
