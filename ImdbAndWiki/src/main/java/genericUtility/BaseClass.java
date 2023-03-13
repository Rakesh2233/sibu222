package genericUtility;

import org.testng.annotations.BeforeSuite;



public class BaseClass extends InstanceClass {
		@BeforeSuite
		public void setUpSuite() {
			fileUtility=new FileUtility();
			javaUtility=new JavaUtility();
			excelUtility=new ExcelUtility();
			webdriverUtility=new WebdriverUtility();
			jsUtility=new JsUtility();

			fileUtility.initializePropertyFile(Iconstants.propertyFilePath);
			excelUtility.initializeExcelFile(Iconstants.excelFilePath);
		}
	}