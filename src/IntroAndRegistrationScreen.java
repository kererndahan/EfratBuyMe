import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

class IntroAndRegistrationScreen {

    // The method initializes the methods of IntroAndRegistrationScreen.
    void introAndRegistrationScreenStart(AndroidDriver driver, ExtentTest test){
        startRegistration(driver, test);
        chooseHowToRegister(driver, test);
        chooseGoogleAccount(driver, test);
    }

    // The method reports the intro screen and presses the registration button.
    private void startRegistration(AndroidDriver driver, ExtentTest test){
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.TO_REGISTER_BUTTON_ID)));
        SupportingMethods.reportAndTakeScreenshot(driver, test, "App opening screen.", "OpeningScreen");
        driver.findElement(By.id(ConstantsClass.TO_REGISTER_BUTTON_ID)).click();
    }

    // The method reports the choose how to register screen and chooses how to register.
    private void chooseHowToRegister(AndroidDriver driver, ExtentTest test){
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.REGISTER_WITH_GOOGLE_BUTTON_ID)));
        SupportingMethods.reportAndTakeScreenshot(driver, test, "Choose how to register screen.", "ChooseHowToRegisterScreen");
        driver.findElement(By.id(ConstantsClass.REGISTER_WITH_GOOGLE_BUTTON_ID)).click();
    }

    // The method reports the choose google account screen and chooses a google account.
    private void chooseGoogleAccount(AndroidDriver driver, ExtentTest test){
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.GOOGLE_PROFILE_VISIBLE_ID)));
        SupportingMethods.reportAndTakeScreenshot(driver, test, "Choose google account screen.", "ChooseGoogleAccountScreen");
        driver.findElementByAndroidUIAutomator(ConstantsClass.GOOGLE_ACCOUNT_UI_SELECTOR).click();
        test.log(Status.PASS, "Registration to the app through google account was successful.");
    }
}
