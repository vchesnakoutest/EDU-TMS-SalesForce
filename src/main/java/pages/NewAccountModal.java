package pages;

import elements.DropDown;
import elements.Input;
import objects.Account;
import org.openqa.selenium.WebDriver;

public class NewAccountModal extends BasePage {

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void create(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Website").write(account.getWebSite());
        new DropDown(driver, "Type").select(account.getType());
    }
}
