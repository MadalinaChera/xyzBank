package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;
import pages.ManagerPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CreateCustomersTest {
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

        List<String> firstNameValueList = Arrays.asList("Mada1", "Mada2", "Mada3");
        List<String> lastNameValueList = Arrays.asList("Chera1", "Chera2", "Chera3");
        List<String> postCodeValueList = Arrays.asList("123", "456", "789");

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.createCustomersProcess(firstNameValueList, lastNameValueList, postCodeValueList);

    }
}
