package com.instagram.pages;

import com.instagram.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends BasePage {

    @FindBy(how = How.CSS, using = "a[href*=\"kaanncinarr/followers/?next=%\"]")
    private WebElement _followers;

    @FindBy(how = How.CSS, using = "a[href*=\"kaanncinarr/following/?next=%\"]")
    private WebElement _followings;

    @FindBy(how = How.XPATH, using = "//*[local-name()='svg' and @class='x1lliihq x1n2onr6 x5n08af']")
    private WebElement _closePopUp;

    @FindBy(how = How.CSS, using = "body > div.x5ec8gl.x1jd1wzk.xntebi5.xahrfoy.x1n2onr6.xzkaem6 > div:nth-child(2) > div > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div.x1uvtmcs.x4k7w5x.x1h91t0o.x1beo9mf.xaigb6o.x12ejxvf.x3igimt.xarpa2k.xedcshv.x1lytzrv.x1t2pt76.x7ja8zs.x1n2onr6.x1qrby5j.x1jfb8zj > div > div > div > div > div.x7r02ix.xf1ldfh.x131esax.xdajt7p.xxfnqb6.xb88tzc.xw2csxc.x1odjw0f.x5fp0pe > div > div > div.xyi19xy.x1ccrb07.xtf3nb5.x1pc53ja.x1lliihq.x1iyjqo2.xs83m0k.xz65tgg.x1rife3k.x1n2onr6")
    private WebElement _slider;


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openFollowers ()
    {
        _followers.click();
    }


    public void openFollowings ()
    {
        _followings.click();
    }


    public void closePopUp ()
    {
        Actions act = new Actions(driver);
        act.moveToElement(_closePopUp).
                click().build().perform();
    }

    public void readFollowers ()
    {
        _Followers_ = new ArrayList<>();
        List<WebElement> temp = driver.findElements(By.tagName("a"));
        temp.forEach(o -> _Followers_.add(o.getAttribute("href")));
    }

    public void readFollowings()
    {
        _Followings_ = new ArrayList<>();
        List<WebElement> temp = driver.findElements(By.tagName("a"));
        temp.forEach(i -> _Followings_.add(i.getAttribute("href")));
    }

    public void scrollPage () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 11; i++)
        {
            Thread.sleep(3000);
            js.executeScript("arguments[0].scrollTo(0, 10000)",_slider);
        }
    }

    public void resultSet () {
        //List<String> diff1 = new ArrayList<>(_Followers_);
        //diff1.removeAll(_Followings_);
        List<String> diff2 = new ArrayList<>(_Followings_);
        diff2.removeAll(_Followers_);
        //System.out.println(diff1.size());
        System.out.println(diff2.size());
        //diff1.forEach(i -> System.out.println(i));
        diff2.forEach(i -> System.out.println(i));
    }
}
