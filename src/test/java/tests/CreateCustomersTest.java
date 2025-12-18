package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

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

        WebElement bankManagerElement = driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
        bankManagerElement.click();

        WebElement addCustomerElement = driver.findElement(By.xpath("//button[@ng-click='addCust()']"));
        addCustomerElement.click();

        List<String> firstNameValueList = Arrays.asList("Mada1", "Mada2", "Mada3");
        List<String> lastNameValueList = Arrays.asList("Chera1", "Chera2", "Chera3");
        List<String> postCodeValueList = Arrays.asList("123", "456", "789");
        String fullName = "";
        int i = 0;
        while (i<firstNameValueList.size()) {
            WebElement firstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
            firstNameElement.sendKeys(firstNameValueList.get(i));

            WebElement lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));

            lastNameElement.sendKeys(lastNameValueList.get(i));

            WebElement postCodeElement = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
            postCodeElement.sendKeys(postCodeValueList.get(i));

            WebElement submitCustomerElement = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
            submitCustomerElement.click();

            Alert customerAlert = driver.switchTo().alert();
            String customerAlertText = customerAlert.getText();
            System.out.println(customerAlertText);
            customerAlert.accept();
            fullName = firstNameValueList.get(i) + " " + lastNameValueList.get(i);
            i++;
        }
    }
}
