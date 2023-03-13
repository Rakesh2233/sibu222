package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchBox;

	@FindBy(xpath = "//div[.='Allu Arjun, Fahadh Faasil']")
	private WebElement movieName;

	@FindBy(xpath = "//span[.='Country of origin']/parent::li/descendant::a[@role='button']")
	private WebElement countryName;

	@FindBy(xpath = "//a[.='Release date']/parent::li/descendant::div[@class='ipc-metadata-list-item__content-container']")
	private WebElement releaseDate;


	public void enterMovieName(String movie) {
		searchBox.sendKeys(movie);
	}
	public void clickOnMovie() {
		movieName.click();
	}	
	public String getCountryName() {
		String country = countryName.getText();
		return country;
	}
	public String getReleaseDate() {
		String release = releaseDate.getText();
		return release;
	}
	
	
	public WebElement getElement() {
		WebElement movieDetail = driver.findElement(By.xpath("//span[.='Details']"));
		return movieDetail;
	}
}
