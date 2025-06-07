package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {

//    private static final Logger log = LoggerFactory.getLogger(LoginStepDefinitions.class);
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        System.setProperty("webdrivrer.chrome.driver","C:\\Downloaded apps\\chromedriver-win64\\chromedriver-win64");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }
    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("I should see the welcome message")
    public void i_should_see_the_welcome_message() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait for 10 seconds
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getSuccessMessageLocator()));
        String successMessage = loginPage.getSuccessMessage();
        Assert.assertEquals("Logged In Successfully", successMessage);
        System.out.println("Login successful!");
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
