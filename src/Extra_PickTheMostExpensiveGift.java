import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.time.Duration.ofSeconds;

class Extra_PickTheMostExpensiveGift {

   // The method chooses the most expensive gift on the page and returns to homeScreen;
   void chooseMostExpensiveGift(AndroidDriver driver, ExtentTest test) {
        String priceOfGiftToChoose = findHighestPriceOfGift(driver);
        searchForElementOfPrice(driver, priceOfGiftToChoose, test);
        driver.findElement(By.id(ConstantsClass.PURCHASE_BUTTON_ID)).click();
        goBackToHomeScreen(driver);
    }

    // The method finds the price string for the highest price gift element.
    private String findHighestPriceOfGift(AndroidDriver driver){
        String priceOfGiftToChoose = null;
        int highestPrice = 0;
        String priceString;
        int priceOfElement;
        for (int i = 0; i < 10; i++) {
            List<WebElement> listOfPriceElements = driver.findElements(By.id(ConstantsClass.PRICE_ELEMENTS_ID));
            for (WebElement priceElement : listOfPriceElements) {
                priceString = priceElement.getText();
                priceOfElement = Integer.parseInt(priceString.replaceAll("\\D+", ""));
                if (priceOfElement > highestPrice) {
                    highestPrice = priceOfElement;
                    priceOfGiftToChoose = priceString;
                }
            }
            new TouchAction(driver).press(500, 1000).waitAction(ofSeconds(1)).moveTo(500, 500).release().perform();
        }
        return priceOfGiftToChoose;
    }

    // The methods finds and clicks on the highest price element.
    private void searchForElementOfPrice(AndroidDriver driver, String priceOfGiftToChoose, ExtentTest test){
        for (int i = 0; i < 10; i++) {
            List<WebElement> listOfPriceElements = driver.findElements(By.id(ConstantsClass.PRICE_ELEMENTS_ID));
            for (WebElement priceElement : listOfPriceElements) {
                if (priceOfGiftToChoose.equals(priceElement.getText())) {
                    priceElement.click();
                    ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.PURCHASE_BUTTON_ID)));
                    test.log(Status.PASS, "Most expensive Gift found successfully.");
                    SupportingMethods.reportAndTakeScreenshot(driver, test, "Most expensive gift Screen", "MostExpensiveGifrScreen");
                    return;
                }
            }
            new TouchAction(driver).press(500, 500).waitAction(ofSeconds(1)).moveTo(500, 1000).release().perform();
        }
    }

    // The method returns to the home screen
    private void goBackToHomeScreen(AndroidDriver driver){
        for (int i=0; i<3; i++) {
            driver.findElementByAndroidUIAutomator(ConstantsClass.BACK_BUTTON_UI_SELECTOR).click();
        }
        driver.findElement(By.id(ConstantsClass.HOME_TAB_ID)).click();
    }
}
