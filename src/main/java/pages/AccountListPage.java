package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountListPage extends BasePage{

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    String URL = "https://epamsystemsinc-a.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    By newButton = By.cssSelector("[title=New]");

    public void openPage() {
        driver.get(URL);
    }

    public void clickNewButton() {
        driver.findElement(newButton).click();
    }
}
