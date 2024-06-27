package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AutoApprovalTool {

    public static void main(String[] args) {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "https://developer.chrome.com/docs/chromedriver/downloads?hl=vi#chromedriver_1140573590");

        // Initialize the Chrome driver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open the main page
            driver.get("http://localhost/index.html");

            // Get the list of approval buttons
            List<WebElement> approveButtons = driver.findElements(By.cssSelector(".approve-button"));
            List<String> itemIds = new ArrayList<>();

            for (WebElement button : approveButtons) {
                itemIds.add(button.getAttribute("data-item-id"));
            }

            // Process each item
            for (String itemId : itemIds) {
                approveItem(driver, itemId);
            }

        } finally {
            // Close the driver
            driver.quit();
        }
    }

    private static void approveItem(WebDriver driver, String itemId) {
        // Navigate to the approval page
        driver.get("http://localhost/approval.html?item=" + itemId);

        // Wait for the Confirm Approval button and click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm-button")));
        confirmButton.click();

        // Wait for the modal to appear and click the OK button
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("ok-button")));
        okButton.click();

        // Wait for the alert and accept it
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        // Log the approval
        System.out.println("Item " + itemId + " approved successfully!");
    }
}
