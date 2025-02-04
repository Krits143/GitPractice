package org.utilites;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassUtilites {

	public static WebDriver driver;

	public static void lanuchBrowser() {
		driver = new ChromeDriver();
	}

	public static void impWait(long values) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(values, TimeUnit.SECONDS);
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void sendKeys(WebElement element, String productName) {
		element.sendKeys(productName);

	}

	public static void clickEvent(WebElement element) {
		element.click();
	}

	public static String getText(WebElement element) {
		String totalProductValue = element.getText();
		return totalProductValue;
	}

	public static String getTextParticularValue(String data, String splitWord) {
		String result = " ";
		int compareCase = data.indexOf(splitWord, 0);
		if (compareCase > 0) {
			String[] splitdatas = data.split(" ");
			for (int i = 0; i < splitdatas.length - 1; i++) {
				if (splitdatas[i].equalsIgnoreCase(splitWord)) {
					result = "List of Total Product : " + splitdatas[i + 1];
					break;
				}
			}
		}
		return result;
	}

	public static List<String> getProductsDetais(List<WebElement> element) {
		List<String> productList = new LinkedList<String>();
		for (int i = 0; i < element.size(); i++) {
			String text = element.get(i).getText();
			productList.add(text);
		}

		return productList;

	}

	public static List<Integer> getProductsPrice(List<WebElement> element) {
		List<Integer> productPrice = new LinkedList<Integer>();
		for (int i = 0; i < element.size(); i++) {
			String text = element.get(i).getText();
			String replace = text.replace("₹", "").replaceAll(",", "");
			productPrice.add(Integer.parseInt(replace));
		}

		return productPrice;

	}

	public static int[] getMaxValue(List<Integer> element) {
		int[] no = new int[element.size() - 1];

		for (int i = 0; i < element.size() - 1; i++) {
			no[i] = element.get(i);
		}
		return no;
	}

	public static List<String> getProductsPriceMap(List<WebElement> element) {
		List<String> productPrice = new LinkedList<String>();
		for (int i = 0; i < element.size(); i++) {
			String text = element.get(i).getText();
			productPrice.add(text);
		}

		return productPrice;

	}

	public static void getMapView(List<String> element, List<String> data) {
		Map<String, String> mp = new LinkedHashMap<String, String>();
		for (int i = 0; i <= element.size() - 1; i++) {
			mp.put(element.get(i), data.get(i));
		}

		Set<Entry<String, String>> entrySet = mp.entrySet();

		for (Entry x : entrySet) {
			System.out.println(x.getKey() + " : " + x.getValue());
		}

	}

}
