package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverUtility {
	private WebDriver driver;
	private Actions act;
	private WebDriverWait wait;

	/**
	 * The method is used to setup the driver instance
	 * @param browser
	 * @return
	 */
	public WebDriver setupDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		default:
			System.out.println("you entered wrong browser");
			break;
		}	
		return driver;
	}
	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to wait the page by using implicit wait
	 * @param longTimeout
	 */
	public void implicitWait(long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}

	/**
	 * This method is used to wait the page by using explicit wait
	 * @param element
	 */
	public void waitTillElementInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * This method is used to navigate the application
	 * @param url
	 */
	public void openApplication(String url) {
		driver.get(url);
	}
	
	public void takeScreenShotPage(Object currentClass,JavaUtility javaUtility) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./errorShots/"+currentClass.getClass().getSimpleName()+" "+javaUtility.getCurrentDate("dd_MM_yyyy_HH_mm_sss")+".png");
		try {
			FileUtils.copyFile(src, dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}