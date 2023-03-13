package org.wiki.home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import genericUtility.BaseClass;
import objectRepository.WikiPage;

public class WikiTest extends BaseClass {
	
	@Test
	public void wikiTest() {

		String movieName = excelUtility.getDataFromExcel(1, 1, "Sheet1");
		String browser = fileUtility.getDataFromProperty("browser");
		String wiki = fileUtility.getDataFromProperty("wikiUrl");
		String expectedCountryName="India";
		String expectedReleaseDate="17 December 2021";
		
		WebDriver driver = webdriverUtility.setupDriver(browser);
		webdriverUtility.maximizeBrowser();
		webdriverUtility.implicitWait(10);
		webdriverUtility.openApplication(wiki);
		WikiPage w=new WikiPage(driver);
		w.enterMovieName(movieName);
		w.clickOnSearchBtn();
		WebElement poster = driver.findElement(By.xpath("//div[.='Theatrical release poster']"));
		jsUtility.initiallizeJSExecutor(driver);
		jsUtility.scrollTillElement(poster);
		String actualReleaseDate = w.getReleaseDate();
		String actualCountryName = w.getCountryName();
		System.out.println("Realese date of the movie: "+actualReleaseDate);
		System.out.println("Country name: "+actualCountryName);
		Assert.assertEquals(expectedCountryName, actualCountryName);
		Assert.assertEquals(expectedReleaseDate, actualReleaseDate);
		webdriverUtility.takeScreenShotPage(webdriverUtility, javaUtility);
		driver.quit();
	}
}