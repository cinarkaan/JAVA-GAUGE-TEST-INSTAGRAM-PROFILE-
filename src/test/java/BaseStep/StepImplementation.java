package BaseStep;

import com.instagram.base.BasePage;
import com.instagram.pages.MainPage;
import com.instagram.pages.ProfilePage;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.testng.Assert;

public class StepImplementation {

    BasePage basePage;
    MainPage mainPage;
    ProfilePage profilePage;

    public StepImplementation () {
        basePage = new BasePage();
    }



    @Step("Go to instagram website using by chrome explorer")
    public void launchWithChrome () {
        basePage.setUpChrome();
        Gauge.captureScreenshot();
    }

    @Step("Go to instagram website using by edge explorer")
    public void launchWithEdge () {
        basePage.setUpEdge();
        Gauge.captureScreenshot();
    }

    @Step("Enter <id> and <password> and then click login button")
    public void login (String id, String password) {
        basePage.setId(id);
        basePage.setPassword(password);
        mainPage = basePage.login();
        Gauge.captureScreenshot();
    }

    @Step("Click profile button navigate bar from left side of the screen")
    public void openProfile () throws InterruptedException {
        Thread.sleep(3000);
        profilePage = mainPage.NavigateProfile();
        Gauge.captureScreenshot();
    }

    @Step("Validate <name> profile whether is correct or not")
    public void validateProfile (String name) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(basePage.getUrl().contains(name));
        Gauge.captureScreenshot();
    }

    @Step("Open your followers and take them into list then close pop up")
    public void getFollowers () throws InterruptedException {
        Thread.sleep(3000);
        profilePage.openFollowers();
        Thread.sleep(3000);
        profilePage.scrollPage();
        profilePage.readFollowers();
        profilePage.closePopUp();
        Gauge.captureScreenshot();
    }

    @Step("Open your followings and take them into list then close pop up")
    public void getFollowings () throws InterruptedException {
        Thread.sleep(3000);
        profilePage.openFollowings();
        Thread.sleep(3000);
        profilePage.scrollPage();
        profilePage.readFollowings();
        profilePage.closePopUp();
        Gauge.captureScreenshot();
    }

    @Step("Compare them and then extract difference between")
    public void compare () {

        profilePage.resultSet();

        Gauge.captureScreenshot();
    }


}
