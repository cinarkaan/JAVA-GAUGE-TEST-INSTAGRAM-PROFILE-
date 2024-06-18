package com.instagram.base;

import com.instagram.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected List<String> _Followers_;
    protected List<String> _Followings_;

    protected WebDriver driver;


    @FindBy(how = How.NAME , using = "username")
    private WebElement Id;
    @FindBy(how = How.NAME , using = "password")
    private WebElement password;
    @FindBy(how = How.XPATH , using = "//*[@id=\"loginForm\"]/div/div[3]/button")
    private WebElement loginButton;

    public BasePage() {

    }

    public void setUpChrome () {
        WebDriverManager.chromedriver().browserVersion("126.0.6478.62 ").setup();
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
        this.driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        this.driver.manage().deleteAllCookies();
        this.driver.get("https://www.instagram.com/");
        PageFactory.initElements(this.driver,this);
    }

    public void setUpEdge () {
        WebDriverManager.edgedriver().browserVersion("125.0.2535.92 ").setup();
        EdgeOptions options = new EdgeOptions();
        this.driver = new EdgeDriver(options);
        this.driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        this.driver.manage().deleteAllCookies();
        this.driver.get("https://www.instagram.com/");
        PageFactory.initElements(this.driver,this);
    }

    public void setId (String id) {
        this.Id.sendKeys(id);
    }

    public void setPassword (String password) {
        this.password.sendKeys(password);
    }

    public MainPage login () {
        loginButton.click();
        return new MainPage(this.driver);
    }

    public String getUrl () {
        return driver.getCurrentUrl();
    }


}
