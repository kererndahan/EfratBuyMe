import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.time.Duration.ofSeconds;

class SenderAndReceiverInformationScreen {

    // The method initializes the methods of SenderAndReceiverInformationScreen.
    void senderAndReceiverInformationScreenStart(AndroidDriver driver, ExtentTest test){
        reportSenderAndReceiverInformationScreen(driver, test);
        enterDetails(driver, test);
        swipeDownAndPressNextButton(driver);
    }

    // The method reports the sender and receiver information screen.
    private void reportSenderAndReceiverInformationScreen (AndroidDriver driver, ExtentTest test) {
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.RECEIVER_NAME_FIELD_ID)));
        SupportingMethods.reportAndTakeScreenshot(driver, test, "Sender and receiver information screen.", "SenderAndReceiverInformationScreen");
    }

    // The method uploads the sender and receiver information.
    private void enterDetails(AndroidDriver driver, ExtentTest test) {
        driver.findElement(By.id(ConstantsClass.RECEIVER_NAME_FIELD_ID)).click();
        driver.getKeyboard().sendKeys(SupportingMethods.readXML("receiverName", test));
        SupportingMethods.protectedHideKeyboard(driver);
        driver.findElement(By.id(ConstantsClass.BLESS_FIELD_ID)).click();
        driver.getKeyboard().sendKeys(SupportingMethods.readXML("bless", test));
        SupportingMethods.protectedHideKeyboard(driver);
        driver.findElement(By.id(ConstantsClass.SENDER_FIELD_ID)).click();
        driver.findElement(By.id(ConstantsClass.SENDER_FIELD_ID)).clear();
        driver.getKeyboard().sendKeys(SupportingMethods.readXML("senderName", test));
        SupportingMethods.protectedHideKeyboard(driver);
        test.log(Status.PASS, "Sender and receiver details uploaded successfully.");
    }

    // The method swipes down and clicks next button.
    private void swipeDownAndPressNextButton(AndroidDriver driver) {
        new TouchAction(driver).press(115, 650).waitAction(ofSeconds(1)).moveTo(115, 350).release().perform();
        driver.findElement(By.id(ConstantsClass.NEXT_BUTTON_ID)).click();
    }
}
