package objects;

import objects.components.DatePicker;
import objects.components.StationEnter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class YarikBookingPage {

    private StationEnter station_from;
    
    @FindBy(id = "station_till")
    private StationEnter station_to;
    
    @FindBy(name = "search")
    private Button searchButton;
    
    private DatePicker date;
    
     
    public YarikBookingPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    public void search_from(String stationName) {
	station_from.search(stationName);
	
    }

    public void search_to(String stationName) {
	station_to.search(stationName);
    }
    
    public void clickSearch() {
	searchButton.click();
    }

}
