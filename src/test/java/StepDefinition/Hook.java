package StepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hook {

    public static WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}





