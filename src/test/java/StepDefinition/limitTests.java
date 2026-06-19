package StepDefinition;

import utils.RandomData;
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
import static org.junit.jupiter.api.Assertions.*;


public class limitTests {

    ContactPage contactPage = new ContactPage();

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("Je voudrais envoyer un message")
    public void je_voudrais_envoyer_un_message() {
        driver.get("https://automationintesting.online/");
    }

    @When("Je remplis le formulaire avec des données valides")
    public void remplirFormulaireValide() {
        contactPage.saisirName("Chris");
        contactPage.saisirEmail("chris@abc.com");
        contactPage.saisirPhone("12345678912");
        contactPage.saisirSubject("Hello");
        contactPage.saisirMessage("Je suis le meilleur testeur du monde");
    }

    @And("Je rends le champ {string} invalide avec {int} caractères")
    public void rendreChampInvalideAvecLongueur(String field, int length) {

        switch (field) {
            case "Phone":
                contactPage.saisirPhone(RandomData.randomPhone(length));
                break;
            case "Subject":
                contactPage.saisirSubject(RandomData.randomString(length));
                break;
            case "Message":
                contactPage.saisirMessage(RandomData.randomString(length));
                break;
            default:
                throw new IllegalArgumentException("Champ non géré : " + field);
        }
    }

    @And("Je rends le champ {string} valide avec {int} caractères")
    public void rendreChampvalideAvecLongueur(String field, int length) {

        switch (field) {
            case "Phone":
                contactPage.saisirPhone(RandomData.randomPhone(length));
                break;
            case "Subject":
                contactPage.saisirSubject(RandomData.randomString(length));
                break;
            case "Message":
                contactPage.saisirMessage(RandomData.randomString(length));
                break;
            default:
                throw new IllegalArgumentException("Champ non géré : " + field);
        }
    }

    @And("J'appuie sur Submit")
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

                try { Thread.sleep(300); } catch (InterruptedException ignored) {}
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
                clicked = true;
            }
            attempts++;
        }
    }
    @Then("La phrase {string} est affichée")
    public void la_phrase_affichee(String message) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div[2]/div/section[3]/div/div/div/div/div/p[3]")));
        assertEquals(message, element.getText());
    }

    @Then("On voit {string} affiché")
    public void on_voit_affiché(String message) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div[2]/div/section[3]/div/div/div/div/div/div/p")));
        assertEquals(message, element.getText());
    }

}
