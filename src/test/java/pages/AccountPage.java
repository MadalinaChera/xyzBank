package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {
    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userSelect")
    public WebElement customerNameElement;

    @FindBy(id = "currency")
    public WebElement currencyElement;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement processButton;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    public WebElement customerElement;

    public void createAccountProcess(String fullName, String currencyValue){
        Select customerSelect = new Select(customerNameElement);
        customerSelect.selectByVisibleText(fullName);

        Select currencySelect = new Select(currencyElement);
        currencySelect.selectByVisibleText(currencyValue);

        processButton.click();

        Alert accountAlert = driver.switchTo().alert();
        String accountAlertText = accountAlert.getText();
        System.out.println(accountAlertText);
        String [] accountArray = accountAlertText.split(":");
        String accountNumber = accountArray[1];
        System.out.println(accountArray[1]);
        accountAlert.accept();

    }

    public void openCustomerspage(){
        customerElement.click();
    }


}
