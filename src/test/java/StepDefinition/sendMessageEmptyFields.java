package StepDefinition;

import pages.ContactPage;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static StepDefinition.Hook.driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomData;
import static org.junit.jupiter.api.Assertions.*;


public class sendMessageEmptyFields {

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("Je suis sur la page du site")
    public void je_suis_sur_la_page_du_site() { driver.get("https://automationintesting.online/"); }

    @When("Je rentre {string} dans le champ Name")
    public void rentrer_nom(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(name);
    }

    @And("Je rentre {string} dans le champ Email")
    public void rentrer_email(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
    }

    @And("Je rentre {string} dans le champ Phone")
    public void rentrer_telephone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys(phone);
    }

    @And("Je rentre {string} dans le champ Subject")
    public void rentrer_sujet(String sujet) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject"))).sendKeys(sujet);
    }

    @And("Je rentre {string} dans Message")
    public void rentrer_message(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys(message);
    }

    @And("J'appuie sur le bouton Submit")
    public void je_appuie_sur_le_bouton_submit() {
        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div/section[3]/div/div/div/div/div/form/div[6]/button"));
        wait.until(ExpectedConditions.visibilityOf(button));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', behavior:'smooth'});", button);
        int attempts = 0;
        boolean clicked = false;
        while (attempts < 3 && !clicked) {
            try {
                button.click();
                clicked = true;
            } catch (ElementClickInterceptedException e) {

                try { Thread.sleep(300); } catch (InterruptedException ignored) {}
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
                clicked = true;
            }
            attempts++;
        }
    }

    @Then("On voit {string} sur la page")
    public void le_champ_est_invalide(String message) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div[2]/div/section[3]/div/div/div/div/div/div/p")));
        assertEquals(message, element.getText());
    }

}

