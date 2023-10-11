package pom.signin;

import core.helpers.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage {

    WaitHelpers waitHelpers = new WaitHelpers();

    public By usernameField(){
        return By.id("user-name");
    }
    public By passwordField(){
        return By.id("password");
    }
    public By loginButton(){
        return By.id("login-button");
    }
    public By errorMessageLabel(){
        return By.xpath("//h3[@data-test='error']");
    }

    //h3[@data-test="error"]

    public void login(WebDriver driver, String username, String password){

        waitHelpers.waitClickeable(driver, usernameField());
        driver.findElement(usernameField()).sendKeys(username);
        driver.findElement(passwordField()).sendKeys(password);
        driver.findElement(loginButton()).click();
    }
}
