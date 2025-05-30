package com.slim.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHRMTestNG {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    @Test
    public void testLoginLogout() {
        // Attendre le champ username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        // Connexion
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Vérifier la présence du tableau de bord
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        System.out.println("Connexion réussie. Tableau de bord visible.");

        // Déconnexion
        driver.findElement(By.className("oxd-userdropdown-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
        driver.findElement(By.linkText("Logout")).click();

        // Vérifier retour sur page de login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        System.out.println("Déconnexion réussie.");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
