package org.testcases;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.pom.ProductDetailsPOM;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utilites.ClassUtilites;
import org.utilites.ComapterUtilites;

public class ProductDetailsTest extends ClassUtilites {

	ProductDetailsPOM productDetails;

	@BeforeClass
	public void lanuch() {
		lanuchBrowser();
		getUrl("https://www.flipkart.com/");
		impWait(10);
	}

	@Test
	public void productDetails() {
		productDetails = new ProductDetailsPOM();
		sendKeys(productDetails.getproductName(), "iphone");
		clickEvent(productDetails.getproductSearch());
		String totalProduct = getText(productDetails.gettotalProduct());
		String totalProductValue = getTextParticularValue(totalProduct, "of");
		System.out.println("============ List of Products count ==============");
		System.out.println(totalProductValue);
		List<String> productsDetais = getProductsDetais(productDetails.getproductList());
		System.out.println("============ List of Products Details ==============");
		for (String x : productsDetais) {
			System.out.println(x);
		}
		List<Integer> productsPrice = getProductsPrice(productDetails.getproductPrice());
		System.out.println("============ List of Products Price ==============");
		for (Integer x : productsPrice) {
			System.out.println(x);
		}
		ComapterUtilites con = new ComapterUtilites();
		Collections.sort(productsPrice, con);
		int[] priceSorted = getMaxValue(productsPrice);
		System.out.println("============ List of Products Minimum Value ==============");
		System.out.println("Minimum Value is : " + priceSorted[0]);
		System.out.println("============ List of Products Maximum Value ==============");
		System.out.println("Maxmium Value is : " + priceSorted[priceSorted.length - 1]);
		System.out.println("============ List of Products append in key and Value ==============");
		getMapView(getProductsDetais(productDetails.getproductList()),
				getProductsPriceMap(productDetails.getproductPrice()));
	}

}
