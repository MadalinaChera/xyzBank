package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomerPage {
    public WebDriver driver;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameElement;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameElement;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postCodeElement;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    public WebElement submitCustomerElement;

    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    public WebElement openAccountElement;

    public void createCustomerProcess(String firstNameValue, String lastNameValue, String postCodeValue){
        firstNameElement.sendKeys(firstNameValue);

        lastNameElement.sendKeys(lastNameValue);

        postCodeElement.sendKeys(postCodeValue);

        submitCustomerElement.click();

        Alert customerAlert = driver.switchTo().alert();
        String customerAlertText = customerAlert.getText();
        System.out.println(customerAlertText);
        customerAlert.accept();
    }

    public void createCustomersProcess(List<String> firstNameValueList, List<String> lastNameValueList, List<String> postCodeValueList){
        int i = 0;
        while (i<firstNameValueList.size()) {
            firstNameElement.sendKeys(firstNameValueList.get(i));

            lastNameElement.sendKeys(lastNameValueList.get(i));

            postCodeElement.sendKeys(postCodeValueList.get(i));

            submitCustomerElement.click();

            Alert customerAlert = driver.switchTo().alert();
            String customerAlertText = customerAlert.getText();
            System.out.println(customerAlertText);
            customerAlert.accept();
            i++;
        }

    }

    public void openAccount(){
        openAccountElement.click();
    }

}
