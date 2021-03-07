package browserPages;


import common.GetPropertyValues;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    WebDriver driver;
   // String page="http://www.google.com";
    @FindBy(name = "q")
    WebElement searchBox;
    @FindBy(name = "btnK")
    WebElement googleSearch;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        GetPropertyValues propertyValues=new GetPropertyValues();
        try {
            String page = propertyValues.getPropValues(System.getProperty("environment"), "GoogleHomeURL");
            driver.get(page);
        }catch (Exception e){e.printStackTrace();}
        PageFactory.initElements(driver, this);
    }

    public void search(String searchKeyword) {
        searchBox.sendKeys(searchKeyword);
        searchBox.sendKeys(Keys.ENTER);
    }

    public String getHeader() {
        return driver.getTitle();
    }

}