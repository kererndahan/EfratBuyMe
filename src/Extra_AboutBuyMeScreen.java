import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

class Extra_AboutBuyMeScreen {

    // The method initializes the methods of Extra_AboutBuyMeScreen.
    void startExtraAboutBuyMeScreenClass(AndroidDriver driver, ExtentTest test){
        enterSettingScreen(driver, test);
        enterAboutBuyMeScreen(driver, test);
        getAboutBuyMeText(driver, test);
        returnToHomePage(driver, test);
    }

    // The method enters settings screen and reports it.
    private void enterSettingScreen(AndroidDriver driver, ExtentTest test) {
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.HOME_TAB_ID)));
        driver.findElement(By.id(ConstantsClass.SETTINGS_ICON_ID)).click();
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.SETTING_SCREEN_VISIBLE_ID)));
        SupportingMethods.reportAndTakeScreenshot(driver, test, "Settings screen.", "SettingsScreen");
    }

    // The method enters about BuyMe screen and reports it.
    private void enterAboutBuyMeScreen(AndroidDriver driver, ExtentTest test) {
        List<WebElement> listOfSettingOptions = driver.findElements(By.id(ConstantsClass.SETTING_OPTIONS_ID));
        listOfSettingOptions.get(1).click();
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.ABOUT_TITLE_ID)));
        SupportingMethods.reportAndTakeScreenshot(driver, test, "About buyMe Screen.", "AboutBuyMeScreen");
    }

    // The method retrives the text from the page and prints it to screen.
    private void getAboutBuyMeText(AndroidDriver driver, ExtentTest test) {
        String titleText = driver.findElement(By.id(ConstantsClass.ABOUT_TITLE_ID)).getText();
        String bodyText = driver.findElement(By.id(ConstantsClass.ABOUT_BODY_ID)).getText();
        System.out.println(titleText);
        System.out.println(bodyText);
        test.log(Status.PASS, "About BuyMe text was retrieved and printed to screen successfully.");
    }

    // The methods returns from about BuyMe screen to home screen.
    private void returnToHomePage(AndroidDriver driver, ExtentTest test){
        driver.findElementByAndroidUIAutomator(ConstantsClass.BACK_BUTTON_UI_SELECTOR).click();
        driver.findElement(By.id(ConstantsClass.HOME_TAB_ID)).click();
    }
}
