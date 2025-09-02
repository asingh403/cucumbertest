package org.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By emailInputLocator = By.xpath("//input[name='email']");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//input[@type='submit']");
    private By forgetPasswordLinkLocator = By.linkText("Forgotten Password");
    private By logoutLinkLocator = By.linkText("logout");

    /**
     * Created Constructor
     */

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public boolean checkForgetPasswordLink() {
        WebElement isLinkFound = driver.findElement(forgetPasswordLinkLocator);
        return isLinkFound.isDisplayed();
    }

    public boolean checkLogoutLink() {
        WebElement isLogoutLinkFound = driver.findElement(logoutLinkLocator);
        return isLogoutLinkFound.isDisplayed();
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void login(String username, String password) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        WebElement passwordInput = driver.findElement(passwordInputLocator);

        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        clickLoginButton();
    }

    public String getForgetPasswordLink() {
        WebElement forgetPassword = driver.findElement(forgetPasswordLinkLocator);
        return forgetPassword.getText();
    }

    public String goForgetPwdPageUrl(){
        String forgetPwdUrl=driver.getCurrentUrl();
        return forgetPwdUrl;
    }
}
