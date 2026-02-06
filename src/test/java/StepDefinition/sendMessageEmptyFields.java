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


public class sendMessageEmptyFields {

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("Je suis sur la page du site")
    public void je_suis_sur_la_page_du_site() { driver.get("https://automationintesting.online/"); }

    @When("Je rentre {string} dans le champ Name")
    public void je_rentre_nom_dans_le_champ_name(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(name);
    }

    @And("Je rentre {string} dans le champ Email")
    public void je_rentre_email_dans_le_champ_email(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
    }

    @And("Je rentre {string} dans le champ Phone")
    public void je_rentre_numéro_dans_le_champ_phone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys(phone);
    }

    @And("Je rentre {string} dans le champ Subject")
    public void je_rentre_sujet_dans_le_champ_subject(String subject) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject"))).sendKeys(subject);
    }

    @And("Je rentre {string} dans Message")
    public void je_rentre_message_dans_message(String message) {
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
                // Pause courte puis JS click en dernier recours
                try { Thread.sleep(300); } catch (InterruptedException ignored) {}
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
                clicked = true;
            }
            attempts++;
        }
    }

    @Then("On voit {string} sur la page")
    public void on_voit_sur_la_page(String message) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div[2]/div/section[3]/div/div/div/div/div/div/p")));
        assertEquals(message, element.getText());
    }
    }

