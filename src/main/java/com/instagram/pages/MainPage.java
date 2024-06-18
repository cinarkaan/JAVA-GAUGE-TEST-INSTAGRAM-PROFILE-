package com.instagram.pages;

import com.instagram.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(how = How.CSS , using = "a[href*=\"kaanncinarr\"]")
    private WebElement _Profile;

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ProfilePage NavigateProfile ()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",_Profile);
        return new ProfilePage(driver);
    }


}
