import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

class SupportingMethods {

    // The method implements the hideKeyBoard() method in a protected way.
    static void protectedHideKeyboard(AndroidDriver driver){
        try {
            driver.hideKeyboard();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // The methods reads content of xml files and returns String.
    static String readXML(String keyName, ExtentTest test){
        File fXmlFile = new File(ConstantsClass.PATHWAY_TO_AUXILIARY_FILES+"/MobileProject.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            test.log(Status.FAIL, "Problem with external file." + e.getMessage());
        }
        Document doc = null;
        try {
            doc = dBuilder.parse(fXmlFile);
        } catch (SAXException | IOException e) {
            test.log(Status.FAIL, "Problem with external file." + e.getMessage());
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    // The method implements the internalTakeScreenshot method into the extent report.
    static void reportAndTakeScreenshot(AndroidDriver driver, ExtentTest test, String details, String pictureName){
        try {
            test.log(Status.INFO, details, MediaEntityBuilder.createScreenCaptureFromPath(SupportingMethods.internalTakeScreenShot(ConstantsClass.PATHWAY_TO_AUXILIARY_FILES + "/" + pictureName, driver)).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // The method takes screen shots.
    private static String internalTakeScreenShot(String ImagesPath, WebDriver driver) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
}