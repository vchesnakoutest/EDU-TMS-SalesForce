package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    WebDriver driver;
    String label;
    String locator = "//*[contains(text(),'%s')]/ancestor::div[contains(@class,'uiInput')]//input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.println(String.format("Writing text: '%s' with label: '%s'", text, label));
        driver.findElement(By.xpath(String.format(locator, label))).sendKeys(text);
    }
}
