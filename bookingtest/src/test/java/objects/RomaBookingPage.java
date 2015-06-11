package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class RomaBookingPage {
	
	WebDriver driver;

	@FindBy (xpath="//input[@name='station_from']")
	private WebElement station_from;
	
	@FindBy (xpath="//input[@name='station_till']")
	private WebElement station_till;
	
	@FindBy (name="date_dep")
	private WebElement date_dep;
	
	@FindBy (name="search")
	private WebElement search;
	
	@FindBy (xpath="//*[@id='ts_res_tbl']")
	public WebElement tTable;
	
	 public RomaBookingPage(WebDriver driver) 
	 {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	 }

	public void enterStationFrom(String value) throws InterruptedException
	{	
		station_from.sendKeys(value);
		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='stations_from']")));
		driver.findElement(By.xpath(".//*[@id='stations_from']/div[1]")).click();;
		
	}
	
	public void enterStationTill(String value) throws InterruptedException
	{
		station_till.sendKeys(value);
	    WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='stations_till']")));
		driver.findElement(By.xpath(".//*[@id='stations_till']/div[1]")).click();;
	}
	
	public void trainsTable()
	{
		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ts_res']")));
		
		
	}
	
	public void enterDate(String value)
	{
		date_dep.clear();
		date_dep.sendKeys(value);
	}
	
	public void submitbuttonSearch()
	{
	     search.click();
	}
	
	public void cleanUpAll()
	{
		station_from.clear();
		station_till.clear();
		date_dep.clear();
		
	}
	
}
