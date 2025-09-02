package org.opencart.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.opencart.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageStepDef {
    private WebDriver driver;
    private LoginPage loginPage;
    private static String OPEN_CART_LOGIN_PAGE = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
    private String email = "asingh.25aug@yahoo.in";
    private String password = "test@12345";

    @Before
    public void setup() {
        WebDriverManager.chromedriver().browserVersion("139").setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        driver.get(OPEN_CART_LOGIN_PAGE);
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkLogoutLink(), true);
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String string) {
        WebElement alertMessage = driver.findElement(By.cssSelector("alert alert-danger alert-dismissible"));
        boolean isAlertMessageFound = alertMessage.isDisplayed();
        Assert.assertEquals(isAlertMessageFound,true);

    }

    @When("I click on the \"Forgotten Password\" link")
    public void i_click_on_the_link(String forgetPassword) {
        loginPage.checkForgetPasswordLink();
    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        boolean isForgettenLinkContains = loginPage.goForgetPwdPageUrl().contains("account/forgetten");
        Assert.assertTrue(isForgettenLinkContains);
    }

}
