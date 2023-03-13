package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {
	WebDriver driver;
	public WikiPage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@id='searchInput']")
	private WebElement textBox;
	
	@FindBy(xpath = "//button[.='Search']")        ////input[@id='searchButton']
	private WebElement searchBtn;
	
	@FindBy(xpath = "//div[.='Release date']/ancestor::tr/descendant::li")
	private WebElement releaseDate;
	
	@FindBy(xpath = "//th[.='Country']/ancestor::tr/descendant::td")
	private WebElement countryName;
	
	public void enterMovieName(String movie) {
		textBox.sendKeys(movie);
	}
	
	public void clickOnSearchBtn() {
		searchBtn.click();
	}
	public String getReleaseDate() {
		String release = releaseDate.getText();
		return release;
	}
	public String getCountryName() {
		String country=countryName.getText();
		return country;
	}
}
