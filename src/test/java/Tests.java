import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.CalculatorPage;
import utils.MobileFactory;

public class Tests {
    
    private AndroidDriver driver;
    private CalculatorPage calculatorPage;
    
    @BeforeEach
    public void setUp() {
        driver = MobileFactory.getAndroidDriver();
        calculatorPage = new CalculatorPage(driver);
    }
    
    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test
    public void testCalculatorAddition() {
        calculatorPage.pressDigit(2);
        calculatorPage.pressOperator("add");
        calculatorPage.pressDigit(3);
        calculatorPage.pressEquals();
        
        WebElement result = calculatorPage.getResult();
        
        Assertions.assertEquals("5", result.getText(), "Ожидаемый результат операции: 5");
    }
    
    @Test
    public void testCalculatorSubtraction() {
        calculatorPage.pressDigit(8);
        calculatorPage.pressOperator("sub");
        calculatorPage.pressDigit(4);
        calculatorPage.pressEquals();
        
        WebElement result = calculatorPage.getResult();
        
        Assertions.assertEquals("4", result.getText(), "Ожидаемый результат операции: 4");
    }
    
    @Test
    public void testCalculatorDivision() {
        calculatorPage.pressDigit(2);
        calculatorPage.pressDigit(0);
        calculatorPage.pressOperator("div");
        calculatorPage.pressDigit(1);
        calculatorPage.pressDigit(0);
        calculatorPage.pressEquals();
        
        WebElement result = calculatorPage.getResult();
        
        Assertions.assertEquals("2", result.getText(), "Ожидаемый результат операции: 2");
    }
    
    @Test
    public void testCalculatorMultiplication() {
        calculatorPage.pressDigit(6);
        calculatorPage.pressDigit(7);
        calculatorPage.pressOperator("mul");
        calculatorPage.pressDigit(9);
        calculatorPage.pressEquals();
        
        WebElement result = calculatorPage.getResult();
        
        Assertions.assertEquals("603", result.getText(), "Ожидаемый результат операции: 603");
    }
    
    @Test
    public void testCalculatorDivisionByZero() {
        calculatorPage.pressDigit(2);
        calculatorPage.pressOperator("div");
        calculatorPage.pressDigit(0);
        calculatorPage.pressEquals();
        
        WebElement result = calculatorPage.getResultError();
        
        Assertions.assertEquals("Can't divide by 0", result.getText(), "Ожидаемый результат операции: Can't divide by 0");
    }
}
