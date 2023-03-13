package genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsUtility {
	JavascriptExecutor js;
	
	public void initiallizeJSExecutor(WebDriver driver) {
		js=(JavascriptExecutor)driver;
	}
	
	public void scrollTillElement(WebElement element) {
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")");
	}
}