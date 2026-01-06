package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        WebElement bankManagerElement = driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
        bankManagerElement.click();

        WebElement addCustomerElement = driver.findElement(By.xpath("//button[@ng-click='addCust()']"));
        addCustomerElement.click();

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue = "Madalina";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Chera";
        lastNameElement.sendKeys(lastNameValue);

        WebElement postCodeElement = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
        String postCodeValue = "307382";
        postCodeElement.sendKeys(postCodeValue);

        WebElement submitCustomerElement = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        submitCustomerElement.click();

        Alert customerAlert = driver.switchTo().alert();
        String customerAlertText = customerAlert.getText();
        System.out.println(customerAlertText);
        customerAlert.accept();

        WebElement openAccountElement = driver.findElement(By.xpath("//button[@ng-click='openAccount()']"));
        openAccountElement.click();

        WebElement customerNameElement = driver.findElement(By.id("userSelect"));
        Select customerSelect = new Select(customerNameElement);
        String fullName = firstNameValue + " " + lastNameValue;
        customerSelect.selectByVisibleText(fullName);

        WebElement currencyElement = driver.findElement(By.id("currency"));
        Select currencySelect = new Select(currencyElement);
        String currencyValue = "Dollar";
        currencySelect.selectByVisibleText(currencyValue);

        WebElement processButton = driver.findElement(By.xpath("//button[@type='submit']"));
        processButton.click();

        Alert accountAlert = driver.switchTo().alert();
        String accountAlertText = accountAlert.getText();
        System.out.println(accountAlertText);
        String [] accountArray = accountAlertText.split(":");
        String accountNumber = accountArray[1];
        System.out.println(accountArray[1]);
        accountAlert.accept();

        WebElement customerElement = driver.findElement(By.xpath("//button[@ng-click='showCust()']"));
        customerElement.click();

        // Adaugam un wait fortat care sa ne garanteze ca cele 2 componente comunica intre ele

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//        }

        WebElement searchCustomerElement = driver.findElement(By.xpath("//input[@placeholder='Search Customer']"));
        searchCustomerElement.click();
        searchCustomerElement.sendKeys(firstNameValue);

        List<WebElement> tableRows = driver.findElements(By.xpath("//tbody/tr"));
        String customerTableRow = tableRows.get(0).getText();
        Assert.assertTrue(customerTableRow.contains(firstNameValue));
        Assert.assertTrue(customerTableRow.contains(lastNameValue));
        Assert.assertTrue(customerTableRow.contains(postCodeValue));
        Assert.assertTrue(customerTableRow.contains(accountNumber));

        WebElement deleteCustomerElement = driver.findElement(By.xpath("//button[@ng-click='deleteCust(cust)']"));
        deleteCustomerElement.click();


    }
}
