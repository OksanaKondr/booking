package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlexVPageObject {
	
	private WebDriver driver;

	@FindBy(xpath = ".//*[@id='station_from']/input")
	private WebElement stationFrom;

	@FindBy(xpath = ".//*[@id='station_till']/input")
	private WebElement stationTo;

	@FindBy(id = "date_dep")
	private WebElement dateFrom;

	@FindBy(xpath = ".//*[@id='content']/form/p/button")
	private WebElement searchButton;

	/*@FindBy(xpath = "//div[@title='Kyiv']")
	private WebElement kyivCity;*/
	
	@FindBy (xpath="//*[@id='ts_res_tbl']")
	public WebElement trainTable;
	
	
	 public AlexVPageObject(WebDriver driver) 
	 {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	 }

	public void stationFromKeys(String value) throws InterruptedException
	{	
		stationFrom.sendKeys(value);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='station_from']/input")));
		driver.findElement(By.xpath(".//*[@id='stations_from']/div[1]")).click();;
	
	}
	
	public void StationToKeys(String value) throws InterruptedException
	{
		stationTo.sendKeys(value);
	    WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='station_till']/input")));
		driver.findElement(By.xpath(".//*[@id='stations_till']/div[1]")).click();;
	
	}
	
	
	public void trainsList()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ts_res_tbl']")));
		
		
	}
	
	public void enterDate(String value)
	{
		dateFrom.clear();
		dateFrom.sendKeys(value);
	}
	
	public void searchButtonClick()
	{
	     searchButton.click();
	}
	
	public void cleanAll()
	{
		stationFrom.clear();
		stationTo.clear();
		dateFrom.clear();
			}
	
	
	public void refresh()
	{
		driver.get("http://booking.uz.gov.ua/en/");
	}
	
	/////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
