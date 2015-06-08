package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RomaBookingPage {
	

	@FindBy (name="station_from")
	private WebElement station_from;
	
	@FindBy (name="station_till")
	private WebElement station_till;
	
	@FindBy (name="date_dep")
	private WebElement date_dep;
	
	@FindBy (name="search")
	private WebElement search;
	

}
