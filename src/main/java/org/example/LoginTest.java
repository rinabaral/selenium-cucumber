package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
// Set the path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\Downloaded apps\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
// Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
// Open the website
        driver.get("https://practicetestautomation.com/practice-test-login/");
// Maximize browser window
        driver.manage().window().maximize();
// Enter username
        driver.findElement(By.id("username")).sendKeys("student");
// Enter password
        driver.findElement(By.id("password")).sendKeys("Password123");
// Click on Login button
        driver.findElement(By.id("submit")).click();
// Verify if login is successful
        String successMessage = driver.findElement(By.className("post-title")).getText();
        if(successMessage.equals("Logged In Successfully")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
// Close the browser
        driver.quit();
    }

}
