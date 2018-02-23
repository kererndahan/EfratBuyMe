import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

class HowToSendScreen {

    // The method initializes the methods of HowToSendScreen.
    void howToSendScreenStart(AndroidDriver driver, ExtentTest test){
        reportHowToSendScreen(driver, test);
        chooseHowToSend(driver, test);
        uploadReceiverEmailAndPressNext(driver, test);
    }

    // The method reports the how to send screen.
    private void reportHowToSendScreen(AndroidDriver driver, ExtentTest test) {
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.SEND_NOW_RADIO_BUTTON_ID)));
        SupportingMethods.reportAndTakeScreenshot(driver, test, "How to send screen.", "HowToSendScreen");
    }

    // The method chooses an option of a how to send.
    private void chooseHowToSend(AndroidDriver driver, ExtentTest test) {
        driver.findElement(By.id(ConstantsClass.SEND_NOW_RADIO_BUTTON_ID)).click();
        List<MobileElement> checkboxOptions = driver.findElements(By.id(ConstantsClass.CHECKBOX_OPTIONS_ID));
        checkboxOptions.get(1).click();
        test.log(Status.PASS, "Method of sending gift chosen successfully.");
    }

    // The method uploads receiver email and clicks next button.
    private void uploadReceiverEmailAndPressNext(AndroidDriver driver, ExtentTest test){
        driver.findElement(By.id(ConstantsClass.RECEIVER_EMAIL_FIELD_ID)).click();
        driver.getKeyboard().sendKeys(SupportingMethods.readXML("receiverEmail", test));
        SupportingMethods.protectedHideKeyboard(driver);
        test.log(Status.PASS, "Receiver email uploaded successfully.");
        driver.findElement(By.id(ConstantsClass.NEXT_BUTTON_ID)).click();
    }
}
