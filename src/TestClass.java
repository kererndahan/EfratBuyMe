import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass {

    private static AndroidDriver<MobileElement> driver;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeClass
    public static void setUpTest(){
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ConstantsClass.PATHWAY_TO_AUXILIARY_FILES+"/extent.html");
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Mobile Project BuyMe - Efrat Baruch", "Report of Mobile Project");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability("appPackage", SupportingMethods.readXML("appPackage", test));
        capabilities.setCapability("appActivity", SupportingMethods.readXML("appActivity", test));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET,false);

        boolean driverSetUp = false;
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
            driverSetUp = true;
        } catch (MalformedURLException e) {
            test.log(Status.FATAL, "Driver set-up failed."+e.getMessage());
        }finally {
            if (driverSetUp){
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                ConstantsClass.WAIT = new WebDriverWait(driver, 10);
                test.log(Status.PASS, "Driver initialized successfully. Test begins.");
            }
        }
    }

    @Test
    public void test_01_Intro_And_Registration_Screen(){
        test.log(Status.INFO, "Test 01_Intro_And_Registration_Screen started.");
        boolean testSuccess = false;
        try {
            IntroAndRegistrationScreen register = new IntroAndRegistrationScreen();
            register.introAndRegistrationScreenStart(driver, test);
            testSuccess = true;
        } finally {
            if (testSuccess){
                test.log(Status.PASS, "Test 01_Intro_And_Registration_Screen passed.");
            }else {
                test.log(Status.FAIL, "Test 01_Intro_And_Registration_Screen failed.");
            }
        }
    }

    @Test
    public void test_02_Extra_About_BuyMe_Screen(){
        test.log(Status.INFO, "Test 02_Extra_About_BuyMe_Screen started.");
        boolean testSuccess = false;
        try {
            Extra_AboutBuyMeScreen aboutBuyMeScreen = new Extra_AboutBuyMeScreen();
            aboutBuyMeScreen.startExtraAboutBuyMeScreenClass(driver, test);
            testSuccess = true;
        }finally {
            if (testSuccess){
                test.log(Status.PASS, "Test 02_Extra_About_BuyMe_Screen passed.");
            }else {
                test.log(Status.FAIL, "Test 02_Extra_About_BuyMe_Screen failed.");
            }
        }
    }

    @Test
    public void test_03_Extra_Swipe_To_Category(){
        test.log(Status.INFO, "Test 03_Extra_Swipe_To_Category started.");
        boolean testSuccess = false;
        try {
            Extra_SwipeToCategory swipeToCategory = new Extra_SwipeToCategory();
            swipeToCategory.swipeToPickACategory(driver, test);
            testSuccess = true;
        }finally {
            if (testSuccess){
                test.log(Status.PASS, "Test 03_Extra_Swipe_To_Category passed.");
            }else {
                test.log(Status.FAIL, "Test 03_Extra_Swipe_To_Category failed.");
            }
        }
    }

    @Test
    public void test_04_Extra_Pick_The_Most_Expensive_Gift(){
        test.log(Status.INFO, "Test 04_Extra_Pick_The_Most_Expensive_Gift started.");
        boolean testSuccess = false;
        try {
            Extra_PickTheMostExpensiveGift pickTheMostExpensiveGift = new Extra_PickTheMostExpensiveGift();
            pickTheMostExpensiveGift.chooseMostExpensiveGift(driver, test);
            testSuccess = true;
        }finally {
            if (testSuccess){
                test.log(Status.PASS, "Test 04_Extra_Pick_The_Most_Expensive_Gift passed.");
            }else {
                test.log(Status.FAIL, "Test 04_Extra_Pick_The_Most_Expensive_Gift failed.");
            }
        }
    }

    @Test
    public void test_05_Home_Screen(){
        test.log(Status.INFO, "Test 05_Home_Screen started.");
        boolean testSuccess = false;
        try {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.homeScreenStart(driver, test);
            testSuccess = true;
        }finally {
            if (testSuccess){
                test.log(Status.PASS, "Test 05_Home_Screen passed.");
            }else {
                test.log(Status.FAIL, "Test 05_Home_Screen failed.");
            }
        }
    }

    @Test
    public void test_06_Sender_And_Receiver_Information_Screen(){
        test.log(Status.INFO, "Test 06_Sender_And_Receiver_Information_Screen started.");
        boolean testSuccess = false;
        try {
            SenderAndReceiverInformationScreen send = new SenderAndReceiverInformationScreen();
            send.senderAndReceiverInformationScreenStart(driver, test);
            testSuccess = true;
        }finally {
            if (testSuccess){
                test.log(Status.PASS, "Test 06_Sender_And_Receiver_Information_Screen passed.");
            }else {
                test.log(Status.FAIL, "Test 06_Sender_And_Receiver_Information_Screen failed.");
            }
        }
    }

    @Test
    public void test_07_How_To_Send_Screen(){
        test.log(Status.INFO, "Test 07_How_To_Send_Screen started.");
        boolean testSuccess = false;
        try {
            HowToSendScreen howToSendScreen = new HowToSendScreen();
            howToSendScreen.howToSendScreenStart(driver, test);
            testSuccess = true;
        }finally {
            if (testSuccess){
                test.log(Status.PASS, "Test 07_How_To_Send_Screen passed.");
            }else {
                test.log(Status.FAIL, "Test 07_How_To_Send_Screen failed.");
            }
        }
    }

    @AfterClass
    public static void closeTest(){
        ConstantsClass.WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsClass.PAYMENT_TITLE_ID)));
        SupportingMethods.reportAndTakeScreenshot(driver, test, "Test completed. Final screen.", "FinalScreen");
        test.log(Status.INFO, "Link test video:"+"<a href='file:///"+ConstantsClass.PATHWAY_TO_AUXILIARY_FILES+"/TestVideo.mp4'>linky</a>");
        driver.quit();
        extent.flush(); //some remark
    }
}
