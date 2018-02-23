import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

class HomeScreen {

    // The method initializes the methods of HomeScreen.
    void homeScreenStart(AndroidDriver driver, ExtentTest test){
        reportHomeScreen(driver, test);
        pickCategory(driver, test);
        pickBusiness(driver, test);
        inputAmountAndPressPay(driver, test);
    }

    // The method reports the home screen.
    private void reportHomeScreen(AndroidDriver driver, ExtentTest test){
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.HOME_TAB_ID)));
        SupportingMethods.reportAndTakeScreenshot(driver, test, "Home screen.", "HomeScreen");
    }

    // The method chooses a category and reports the category screen.
    private void pickCategory(AndroidDriver driver, ExtentTest test) {
        new TouchAction(driver).tap(driver.findElementByAndroidUIAutomator(ConstantsClass.CATEGORY_TO_PICK_UI_SELECTOR)).perform();
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.CATEGORY_SCREEN_VISIBLE_ID)));
        test.log(Status.PASS, "A category was chosen successfully.");
        SupportingMethods.reportAndTakeScreenshot(driver, test, "Chosen category screen.", "ChosenCategoryScreen");
    }

    // The method chooses a business and reports the business screen.
    private void pickBusiness(AndroidDriver driver, ExtentTest test) {
        driver.findElementByAndroidUIAutomator(ConstantsClass.BUSINESS_TO_PICK_UI_SELECTOR).click();
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.GIFT_AMOUNT_FIELD_ID)));
        test.log(Status.PASS, "A business was chosen successfully.");
        SupportingMethods.reportAndTakeScreenshot(driver, test, "chosen business screen.", "ChosenBusinessScreen");
    }

    // The method input amount of gift and presses next button.
    private void inputAmountAndPressPay(AndroidDriver driver, ExtentTest test){
        driver.findElement(By.id(ConstantsClass.GIFT_AMOUNT_FIELD_ID)).click();
        driver.getKeyboard().sendKeys(SupportingMethods.readXML("amountToGift", test));
        SupportingMethods.protectedHideKeyboard(driver);
        test.log(Status.PASS, "Amount of gift upload was successful.");
        driver.findElement(By.id(ConstantsClass.PURCHASE_BUTTON_ID)).click();
    }
}
