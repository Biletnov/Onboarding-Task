package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {
    
    private AndroidDriver driver;
    
    public CalculatorPage(AndroidDriver driver) {
        this.driver = driver;
    }
    
    public void pressDigit(int digitId) {
        WebElement button = driver.findElementById("com.google.android.calculator:id/digit_" + digitId);
        button.click();
    }
    
    public void pressOperator(String operatorId) {
        WebElement button = driver.findElementById("com.google.android.calculator:id/op_" + operatorId);
        button.click();
    }
    
    public void pressEquals() {
        WebElement button = driver.findElementById("com.google.android.calculator:id/eq");
        button.click();
    }
    
    public WebElement getResult() {
        return driver.findElementById("com.google.android.calculator:id/result_final");
    }
    
    public WebElement getResultError() {
        return driver.findElementById("com.google.android.calculator:id/result_preview");
    }
}

