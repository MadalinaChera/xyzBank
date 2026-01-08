package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage {
    public WebDriver driver;

    public ManagerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@ng-click='addCust()']")
    public WebElement addCustomerElement;

    public void createCustomer(){
        addCustomerElement.click();
    }
}
