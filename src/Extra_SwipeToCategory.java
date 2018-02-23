import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

class Extra_SwipeToCategory {

    // The method chooses the SPA category using swipe
    void swipeToPickACategory(AndroidDriver driver, ExtentTest test) {
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.HOME_TAB_ID)));
        horizontalSwipe(driver);
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.CATEGORY_SCREEN_VISIBLE_ID)));
        test.log(Status.PASS, "Category was chosen using swipe action successfully.");
        SupportingMethods.reportAndTakeScreenshot(driver, test, "Chosen with swipe category screen.", "ChosenWithSwipeCategoryScreen");
        driver.findElementByAndroidUIAutomator(ConstantsClass.BUSINESS_TO_PICK_UI_SELECTOR).click();
    }

    // The method performs swipe to the right gesture to the desired category
    private void horizontalSwipe(AndroidDriver driver){
        TouchAction action = new TouchAction(driver);
        Duration oneSecondsDuration = Duration.ofSeconds(1);
        for (int i = 0; i < 5; i++) {
            action.longPress(100, 700, oneSecondsDuration).moveTo(1100, 700).release().perform();
            action.waitAction(Duration.ofMillis(200)).perform();
        }
    }
}

