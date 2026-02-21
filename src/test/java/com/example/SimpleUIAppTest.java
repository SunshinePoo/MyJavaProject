package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SimpleUIAppTest {

    private WebDriver driver;
    private static final String BASE_URL = "http://localhost:8080";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(description = "Test Page Load")
    public void testPageLoads() {
        driver.navigate().to(BASE_URL);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Simple UI Program", "Page title does not match");
    }

    @Test(description = "Test Display Button with Valid Text")
    public void testDisplayButtonWithValidText() {
        driver.navigate().to(BASE_URL);
        
        WebElement textInput = driver.findElement(By.id("textInput"));
        WebElement displayBtn = driver.findElement(By.id("displayBtn"));
        WebElement outputLabel = driver.findElement(By.id("outputLabel"));
        
        String testText = "Hello World";
        textInput.sendKeys(testText);
        displayBtn.click();
        
        String outputText = outputLabel.getText();
        Assert.assertEquals(outputText, "You typed: " + testText, "Output text does not match expected value");
        Assert.assertTrue(outputLabel.getAttribute("class").contains("output-success"), "Output should have success styling");
    }

    @Test(description = "Test Display Button with Empty Text")
    public void testDisplayButtonWithEmptyText() {
        driver.navigate().to(BASE_URL);
        
        WebElement textInput = driver.findElement(By.id("textInput"));
        WebElement displayBtn = driver.findElement(By.id("displayBtn"));
        WebElement outputLabel = driver.findElement(By.id("outputLabel"));
        
        // Leave text input empty
        displayBtn.click();
        
        String outputText = outputLabel.getText();
        Assert.assertEquals(outputText, "Please enter some text!", "Error message does not match");
        Assert.assertTrue(outputLabel.getAttribute("class").contains("output-error"), "Output should have error styling");
    }

    @Test(description = "Test Display Button with Whitespace Only")
    public void testDisplayButtonWithWhitespaceOnly() {
        driver.navigate().to(BASE_URL);
        
        WebElement textInput = driver.findElement(By.id("textInput"));
        WebElement displayBtn = driver.findElement(By.id("displayBtn"));
        WebElement outputLabel = driver.findElement(By.id("outputLabel"));
        
        textInput.sendKeys("   ");
        displayBtn.click();
        
        String outputText = outputLabel.getText();
        Assert.assertEquals(outputText, "Please enter some text!", "Error message should appear for whitespace");
        Assert.assertTrue(outputLabel.getAttribute("class").contains("output-error"), "Output should have error styling");
    }

    @Test(description = "Test Display Button with Special Characters")
    public void testDisplayButtonWithSpecialCharacters() {
        driver.navigate().to(BASE_URL);
        
        WebElement textInput = driver.findElement(By.id("textInput"));
        WebElement displayBtn = driver.findElement(By.id("displayBtn"));
        WebElement outputLabel = driver.findElement(By.id("outputLabel"));
        
        String specialText = "Test@123!#$%";
        textInput.sendKeys(specialText);
        displayBtn.click();
        
        String outputText = outputLabel.getText();
        Assert.assertEquals(outputText, "You typed: " + specialText, "Output should handle special characters");
    }

    @Test(description = "Test Input Field Clears After Submission and New Input")
    public void testMultipleInputs() {
        driver.navigate().to(BASE_URL);
        
        WebElement textInput = driver.findElement(By.id("textInput"));
        WebElement displayBtn = driver.findElement(By.id("displayBtn"));
        WebElement outputLabel = driver.findElement(By.id("outputLabel"));
        
        // First input
        String firstText = "First Input";
        textInput.sendKeys(firstText);
        displayBtn.click();
        Assert.assertEquals(outputLabel.getText(), "You typed: " + firstText);
        
        // Clear and second input
        textInput.clear();
        String secondText = "Second Input";
        textInput.sendKeys(secondText);
        displayBtn.click();
        Assert.assertEquals(outputLabel.getText(), "You typed: " + secondText);
    }

    @Test(description = "Test Form Submission via Enter Key")
    public void testFormSubmissionViaEnterKey() {
        driver.navigate().to(BASE_URL);
        
        WebElement textInput = driver.findElement(By.id("textInput"));
        WebElement outputLabel = driver.findElement(By.id("outputLabel"));
        
        String testText = "Enter Key Test";
        textInput.sendKeys(testText);
        textInput.submit();
        
        String outputText = outputLabel.getText();
        Assert.assertEquals(outputText, "You typed: " + testText, "Form submission via Enter key should work");
    }

    @Test(description = "Test Long Text Input")
    public void testLongTextInput() {
        driver.navigate().to(BASE_URL);
        
        WebElement textInput = driver.findElement(By.id("textInput"));
        WebElement displayBtn = driver.findElement(By.id("displayBtn"));
        WebElement outputLabel = driver.findElement(By.id("outputLabel"));
        
        String longText = "This is a long text input. It contains multiple words and should be displayed correctly in the output label without any issues.";
        textInput.sendKeys(longText);
        displayBtn.click();
        
        String outputText = outputLabel.getText();
        Assert.assertEquals(outputText, "You typed: " + longText, "Long text should be handled correctly");
    }

    @Test(description = "Test Initial State of Page")
    public void testInitialPageState() {
        driver.navigate().to(BASE_URL);
        
        WebElement textInput = driver.findElement(By.id("textInput"));
        WebElement outputLabel = driver.findElement(By.id("outputLabel"));
        
        Assert.assertEquals(textInput.getAttribute("value"), "", "Text input should be empty initially");
        Assert.assertTrue(outputLabel.getAttribute("class").contains("output-default"), "Output label should have default styling initially");
        Assert.assertEquals(outputLabel.getText(), "Output will appear here", "Output label should show default message initially");
    }
}
