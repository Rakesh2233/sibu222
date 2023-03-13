package genericUtility;

import org.openqa.selenium.WebDriver;

import objectRepository.HomePage;

public class InstanceClass {
	public WebDriver driver;
	public FileUtility fileUtility;
	public JavaUtility javaUtility;
	public ExcelUtility excelUtility;
	public WebdriverUtility webdriverUtility;
    public JsUtility jsUtility;
	protected String url;
	protected String browser;
	protected String timeouts;
	public HomePage home;
}
