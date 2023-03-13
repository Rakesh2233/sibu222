package org.imdb.home;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.HomePage;

public class Imdb extends BaseClass {
	@Test
	public void pushpaMovieTest() throws IOException, InterruptedException {

		String movie = excelUtility.getDataFromExcel(1, 1, "Sheet1");
		String url = fileUtility.getDataFromProperty("url");
		String browser = fileUtility.getDataFromProperty("browser");
		String expectedCountryName="India";
		String expectedReleaseDate="December 17, 2021 (United States)";
		
		WebDriver driver=webdriverUtility.setupDriver(browser);
		webdriverUtility.maximizeBrowser();
		driver.get(url);
		webdriverUtility.implicitWait(10);
		HomePage home=new HomePage(driver);
		home.enterMovieName(movie);
		home.clickOnMovie();	
		WebElement element = driver.findElement(By.xpath("//span[.='Details']"));
		jsUtility.initiallizeJSExecutor(driver);
		jsUtility.scrollTillElement(element);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath("//img[@src='https://m.media-amazon.com/images/S/al-eu-726f4d26-7fdb/cca46258-4f6b-4f56-a7c4-19dfa413079b.jpg']"))));
		String actualcountryName = home.getCountryName();
		String actualReleaseDate = home.getReleaseDate();
		System.out.println("Country Name: "+actualcountryName);
		System.out.println("Release Date: "+actualReleaseDate);
		Assert.assertEquals(expectedCountryName, actualcountryName);
		Assert.assertEquals(expectedReleaseDate, actualReleaseDate);
		webdriverUtility.takeScreenShotPage(url, javaUtility);
		driver.quit();
	}
}
