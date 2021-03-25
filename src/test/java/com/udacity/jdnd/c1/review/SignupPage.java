package com.udacity.jdnd.c1.review;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    @FindBy(id="inputUsername")
    private WebElement inputUsernameField;
    @FindBy(id="password")
    private WebElement passwordField;
    @FindBy(id="surname")
    private WebElement surnameField;
    @FindBy(id="lastname")
    private WebElement lastnameField;
    @FindBy(type="submit")
    private WebElement submitButton;

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void signup(String inputUsername, String password, String surname, String lastname) {
        this.inputUsernameField.sendKeys(inputUsername);
        this.passwordField.sendKeys(password);
        this.surnameField.sendKeys(surname);
        this.lastnameField.sendKeys(lastname);
        this.submitButton.click();
    }

}
