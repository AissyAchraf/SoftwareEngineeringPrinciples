package ma.ensa.test.driven.project.service;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumTaxCalculateTest {

    @LocalServerPort
    private int port;

    /**
     * Teste la fonctionnalité calcule de réduction avec Selenium.
     *
     * Cas de test : Test 1
     * Données de test : revenu = -10000 et nombre d'enfants = -10
     * Résultat attendu : Tax = "Rejet du revenu" (Error) et reduction = "Rejet du nombre d'enfants" (Error)
     */
    @Ignore
    public void testTaxCalculateSeleniumCas1() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\session\\Desktop\\test.driven.project\\src\\main\\resources\\static\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("http://localhost:" + port + "/tax");
        driver.manage().window().maximize();

        driver.findElement(By.id("income")).clear();
        driver.findElement(By.id("income")).sendKeys("-1000");
        driver.findElement(By.id("children")).clear();
        driver.findElement(By.id("children")).sendKeys("-10");
        driver.findElement(By.tagName("button")).click();

        assertEquals("Calcule d'imposition", driver.getTitle());
        assertEquals("Rejet du revenu", driver.findElement(By.id("errorMessageIncome")).getText());
        assertEquals("Rejet du nombre d'enfants", driver.findElement(By.id("errorMessageChildren")).getText());

        driver.quit();
    }

    /**
     * Teste la fonctionnalité calcule de réduction avec Selenium.
     *
     * Cas de test : Test 2
     * Données de test : revenu = 5 et nombre d'enfants = 1
     * Résultat attendu : Tax = "Taux d'imposition de 0%" et reduction = "Rejet du nombre d'enfants" (Error)
     */
    @Ignore
    public void testTaxCalculateSeleniumCas2() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\session\\Desktop\\test.driven.project\\src\\main\\resources\\static\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("http://localhost:" + port + "/tax");
        driver.manage().window().maximize();

        driver.findElement(By.id("income")).clear();
        driver.findElement(By.id("income")).sendKeys("5");
        driver.findElement(By.id("children")).clear();
        driver.findElement(By.id("children")).sendKeys("1");
        driver.findElement(By.tagName("button")).click();

        assertEquals("Rejet du nombre d'enfants", driver.findElement(By.id("errorMessageChildren")).getText());
        assertEquals("Taux d'imposition de 0,00%", driver.findElement(By.id("successMessageTax")).getText());

        driver.quit();
    }

    /**
     * Teste la fonctionnalité calcule de réduction avec Selenium.
     *
     * Cas de test : Test 3
     * Données de test : revenu = 50000 et nombre d'enfants = 6
     * Résultat attendu : Tax = "Taux d'imposition de 20%" et reduction = "Taux de réduction de 15%"
     */
    @Ignore
    public void testTaxCalculateSeleniumCas3() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\session\\Desktop\\test.driven.project\\src\\main\\resources\\static\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("http://localhost:" + port + "/tax");
        driver.manage().window().maximize();

        driver.findElement(By.id("income")).clear();
        driver.findElement(By.id("income")).sendKeys("50000");
        driver.findElement(By.id("children")).clear();
        driver.findElement(By.id("children")).sendKeys("6");
        driver.findElement(By.tagName("button")).click();

        assertEquals("Taux d'imposition de 20,00%", driver.findElement(By.id("successMessageTax")).getText());
        assertEquals("Taux de réduction de 15,00%", driver.findElement(By.id("successMessageReduction")).getText());

        driver.quit();
    }

    /**
     * Teste la fonctionnalité calcule de réduction avec Selenium.
     *
     * Cas de test : Test 4
     * Données de test : revenu = 150000 et nombre d'enfants = 11
     * Résultat attendu : Tax = "Rejet du revenu" (Error) et reduction = "Rejet du nombre d'enfants" (Error)
     */
    @Ignore
    public void testTaxCalculateSeleniumCas4() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\session\\Desktop\\test.driven.project\\src\\main\\resources\\static\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("http://127.0.0.1:" + port + "/tax");
        driver.manage().window().maximize();

        driver.findElement(By.id("income")).clear();
        driver.findElement(By.id("income")).sendKeys("150000");
        driver.findElement(By.id("children")).clear();
        driver.findElement(By.id("children")).sendKeys("11");
        driver.findElement(By.tagName("button")).click();

        assertEquals("Calcule d'imposition", driver.getTitle());
        assertEquals("Rejet du revenu", driver.findElement(By.id("errorMessageIncome")).getText());
        assertEquals("Rejet du nombre d'enfants", driver.findElement(By.id("errorMessageChildren")).getText());

        driver.quit();
    }
}

