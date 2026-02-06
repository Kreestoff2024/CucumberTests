package StepDefinition;


import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static StepDefinition.Hook.driver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class sendMessageWrongEmail {

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("Je veux envoyer un message")
    public void je_veux_envoyer_un_message() { driver.get("https://automationintesting.online/"); }

    @When("Je saisis {string} dans Name")
    public void je_saisis_nom_dans_name(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(name);
    }

    @And("Je saisis {string} dans Email")
    public void je_saisis_email_dans_email(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
    }

    @And("Je saisis {string} dans Phone")
    public void je_saisis_numero_dans_phone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys(phone);
    }

    @And("Je saisis {string} dans Subject")
    public void je_saisis_sujet_dans_subject(String subject) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject"))).sendKeys(subject);
    }

    @And("Je saisis {string} dans Message")
    public void je_saisis_message_dans_message(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys(message);
    }

    @And("Je clique sur Submit")
    public void je_clique_sur_submit() {
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
                // Pause courte puis JS click en dernier recours
                try { Thread.sleep(300); } catch (InterruptedException ignored) {}
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
                clicked = true;
            }
            attempts++;
        }
    }

    @Then("On peut voir {string} sur la page")
    public void on_peut_voir_sur_la_page(String message) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div[2]/div/section[3]/div/div/div/div/div/div")));
        assertEquals(message, element.getText());
    }
}
