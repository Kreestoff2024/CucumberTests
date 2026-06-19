package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static StepDefinition.Hook.driver;

public class ContactPage {

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private void saisirChamp(By locator, String value) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        field.clear();
        field.sendKeys(value);
    }

    public void saisirName(String name) {
        saisirChamp(By.id("name"), name);
    }

    public void saisirEmail(String email) {
        saisirChamp(By.id("email"), email);
    }

    public void saisirPhone(String phone) {
        saisirChamp(By.id("phone"), phone);
    }

    public void saisirSubject(String subject) {
        saisirChamp(By.id("subject"), subject);
    }

    public void saisirMessage(String message) {
        saisirChamp(By.id("description"), message);
    }
}


