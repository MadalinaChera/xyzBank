package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import java.util.List;

public class CreateCustomerTest {
    public WebDriver driver;

    @Test

    public void automationTest(){
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginBankManager();

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.createCustomer();

        String firstNameValue = "Madalina";
        String lastNameValue = "Chera";
        String postCodeValue = "307382";

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.createCustomerProcess(firstNameValue, lastNameValue, postCodeValue);
        customerPage.openAccount();

        String fullName = firstNameValue + " " + lastNameValue;
        String currencyValue = "Dollar";

        AccountPage accountPage = new AccountPage(driver);
        accountPage.createAccountProcess(fullName, currencyValue);

        accountPage.openCustomerspage();

        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.searchCustomer(firstNameValue);
        customersPage.validateCustomer(firstNameValue, lastNameValue, postCodeValue);
        customersPage.deleteCustomer();

    }
}
