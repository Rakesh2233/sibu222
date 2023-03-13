package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public String getCurrentDate(String strategy) {
		return new SimpleDateFormat(strategy).format(new Date());
	}
	/**
	 * To generate randomNumber
	 * @return
	 */
	
	public int getRandomNumber() {
		return new Random().nextInt(100);
	}
}
