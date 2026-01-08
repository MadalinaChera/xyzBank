package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CustomersPage {
    public WebDriver driver;

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    public WebElement searchCustomerElement;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    public WebElement deleteCustomerElement;

    public void searchCustomer(String firstNameValue){
        searchCustomerElement.click();
        searchCustomerElement.sendKeys(firstNameValue);
    }

    public void validateCustomer(String firstNameValue, String lastNameValue, String postCodeValue){
        String customerTableRow = tableRows.get(0).getText();
        Assert.assertTrue(customerTableRow.contains(firstNameValue));
        Assert.assertTrue(customerTableRow.contains(lastNameValue));
        Assert.assertTrue(customerTableRow.contains(postCodeValue));
//        Assert.assertTrue(customerTableRow.contains(accountNumber));
    }

    public void deleteCustomer(){
        deleteCustomerElement.click();
    }
}
