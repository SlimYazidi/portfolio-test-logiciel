package com.slim.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoTest {
    public static void main(String[] args) {
        // Préparation du driver Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Fenêtre en plein écran + accès au site
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Connexion
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // ✅ Vérification du login (présence de la liste des produits)
        boolean loginOk = driver.findElements(By.className("inventory_list")).size() > 0;
        if (loginOk) {
            System.out.println("✅ Connexion réussie.");
        } else {
            System.out.println("❌ Connexion échouée.");
            driver.quit();
            return;
        }

        // ✅ Ajouter un produit au panier
        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart.click();

        // ✅ Vérification que le panier affiche "1"
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        String itemCount = cartBadge.getText();
        if (itemCount.equals("1")) {
            System.out.println("✅ Article ajouté au panier avec succès.");
        } else {
            System.out.println("❌ Échec de l'ajout au panier.");
        }

        // ✅ Accès au panier
        driver.findElement(By.className("shopping_cart_link")).click();

        // ✅ Vérification que l’article apparaît dans le panier
        boolean itemVisible = driver.findElements(By.className("inventory_item_name")).size() > 0;
        if (itemVisible) {
            System.out.println("✅ L’article est bien visible dans le panier.");
        } else {
            System.out.println("❌ L’article n’est pas dans le panier.");
        }

        // ✅ Retour en arrière (continuer achats)
        driver.findElement(By.id("continue-shopping")).click();

        // ✅ Déconnexion (menu → logout)
        driver.findElement(By.id("react-burger-menu-btn")).click();
        try {
            Thread.sleep(1000); // petite pause pour laisser le menu s’ouvrir
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("logout_sidebar_link")).click();

        // ✅ Vérification retour sur page de login
        boolean onLoginPage = driver.findElements(By.id("login-button")).size() > 0;
        if (onLoginPage) {
            System.out.println("✅ Déconnexion réussie.");
        } else {
            System.out.println("❌ Échec de la déconnexion.");
        }
        
        // Pause finale et fermeture
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //driver.quit();
    }
}
