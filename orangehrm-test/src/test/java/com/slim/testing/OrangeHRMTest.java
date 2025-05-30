package com.slim.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class OrangeHRMTest {
    public static void main(String[] args) {

        // Setup du driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Fenêtre maximisée
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Attente du champ username
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameField.sendKeys("Admin");

        // Saisie mot de passe
        driver.findElement(By.name("password")).sendKeys("admin123");

        // Clic sur le bouton login
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Vérification de la page dashboard
        boolean dashboardVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-topbar-header-title"))).isDisplayed();
        if (dashboardVisible) {
            System.out.println("Connexion réussie. Tableau de bord visible.");
        } else {
            System.out.println("Échec de la connexion.");
        }

        // Déconnexion
        driver.findElement(By.className("oxd-userdropdown-name")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Logout"))).click();

        // Vérification retour sur login
        boolean loginBtnVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).isDisplayed();
        if (loginBtnVisible) {
            System.out.println("Déconnexion réussie.");
        } else {
            System.out.println("Échec de la déconnexion.");
        }

        // Pause pour voir le résultat
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fermeture du navigateur
        driver.quit();
    }
}
