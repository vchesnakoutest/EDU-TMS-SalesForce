package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pages.AccountListPage;
import pages.NewAccountModal;

import java.util.concurrent.TimeUnit;

public class AccountTest {

    String URL = "https://login.salesforce.com/";
    String USERNAME = "vchesn-l0rm@force.com";
    String PASSWORD = "!@#$%^&1q";
    Account account = new Account("Test User", "www.test.by","Analyst");

    @Test
    public void createContactTest() {
        //driver settings
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //login
        driver.get(URL);
        driver.findElement(By.id("username")).sendKeys(USERNAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("Login")).click();
        //account page
        AccountListPage accountListPage = new AccountListPage(driver);
        accountListPage.openPage();
        accountListPage.clickNewButton();
        //new modal page
        NewAccountModal newAccountModal = new NewAccountModal(driver);
        newAccountModal.create(account);
        //driver close
        driver.quit();
    }
}
