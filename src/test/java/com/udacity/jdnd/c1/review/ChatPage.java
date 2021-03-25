package com.udacity.jdnd.c1.review;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ChatPage {
    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //public void chat();
}
