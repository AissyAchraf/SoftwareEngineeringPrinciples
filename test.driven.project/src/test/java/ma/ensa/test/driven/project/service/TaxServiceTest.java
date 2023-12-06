package ma.ensa.test.driven.project.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.Assert.*;

@SpringBootTest
public class TaxServiceTest {

    @Autowired
    private TaxService service;

    // === Tests pour la fonctionnalité calcule Tax ===

    /**
     * Teste la fonctionnalité calcule d'imposition avec des données de test spécifiques.
     *
     * Cas de test : Test 1 : revenu moins de 0€
     * Données de test : revenu = -1€
     * Résultat attendu : tax = null (rejection de revenu)
     */
    @Test
    public void testCalculateTaxCas1() {
        Double income = -1D;
        Double result = service.calculateTax(income);
        assertTrue(result == null);
    }

    /**
     * Teste la fonctionnalité calcule d'imposition avec des données de test spécifiques.
     *
     * Cas de test : Test 2 : revenu entre 0€ et 10k€
     * Données de test : revenu = 5€
     * Résultat attendu : tax = 0 (imposable)
     */
    @Test
    public void testCalculateTaxCas2() {
        Double income = 5D;
        Double result = service.calculateTax(income);
        assertTrue(result == 0D);
    }

    /**
     * Teste la fonctionnalité calcule d'imposition avec des données de test spécifiques.
     *
     * Cas de test : Test 3 : revenu entre 10K€ et 100k€
     * Données de test : revenu = 50K€
     * Résultat attendu : tax = 20
     */
    @Test
    public void testCalculateTaxCas3() {
        Double income = 50000D;
        Double result = service.calculateTax(income);
        assertTrue(result == 20D);
    }

    /**
     * Teste la fonctionnalité calcule d'imposition avec des données de test spécifiques.
     *
     * Cas de test : Test 4 : revenu plus que 100k€
     * Données de test : revenu = 1000K€
     * Résultat attendu : tax = null (rejection de revenu)
     */
    @Test
    public void testCalculateTaxCas4() {
        Double income = 1000000D;
        Double result = service.calculateTax(income);
        assertTrue(result == null);
    }

    /**
     * Teste la fonctionnalité calcule d'imposition avec des données de test limite.
     *
     * Cas de test : Test 5 : revenu égale à 0€
     * Données de test : revenu = 0€
     * Résultat attendu : tax = 0 (imposable)
     */
    @Test
    public void testCalculateTaxCas5() {
        Double income = 0D;
        Double result = service.calculateTax(income);
        assertTrue(result == 0D);
    }

    /**
     * Teste la fonctionnalité calcule d'imposition avec des données de test limite.
     *
     * Cas de test : Test 6 : revenu égale à 10K€
     * Données de test : revenu = 10K€
     * Résultat attendu : tax = 20
     */
    @Test
    public void testCalculateTaxCas6() {
        Double income = 10000D;
        Double result = service.calculateTax(income);
        assertTrue(result == 20D);
    }

    /**
     * Teste la fonctionnalité calcule d'imposition avec des données de test limite.
     *
     * Cas de test : Test 7 : revenu égale à 10K€
     * Données de test : revenu = 100K€
     * Résultat attendu : tax = 20
     */
    @Test
    public void testCalculateTaxCas7() {
        Double income = 100000D;
        Double result = service.calculateTax(income);
        assertTrue(result == 20D);
    }

    // === Tests pour la fonctionnalité calcule Reduction ===

    /**
     * Teste la fonctionnalité calcule de réduction avec des données de test spécifiques.
     *
     * Cas de test : Test 1 : nombre d'enfants scolarisés moins de 0
     * Données de test : nombre d'enfants = -1
     * Résultat attendu : réduction = null (rejection du nombre d'enfants)
     */
    @Test
    public void testCalculateReductionCas1() {
        int children = -1;
        Double result = service.calculateReduction(children);
        assertTrue(result == null);
    }

    /**
     * Teste la fonctionnalité calcule de réduction avec des données de test spécifiques.
     *
     * Cas de test : Test 2 : nombre d'enfants scolarisé entre 0 et 2
     * Données de test : nombre d'enfants = 1
     * Résultat attendu : réduction = null (rejection du nombre d'enfants)
     */
    @Test
    public void testCalculateReductionCas2() {
        int children = 1;
        Double result = service.calculateReduction(children);
        assertTrue(result == null);
    }

    /**
     * Teste la fonctionnalité calcule de réduction avec des données de test spécifiques.
     *
     * Cas de test : Test 3 : nombre d'enfants scolarisé entre 2 et 10
     * Données de test : nombre d'enfants = 3
     * Résultat attendu : réduction = 15 (réduction de 15%)
     */
    @Test
    public void testCalculateReductionCas3() {
        int children = 3;
        Double result = service.calculateReduction(children);
        assertTrue(result == 15D);
    }

    /**
     * Teste la fonctionnalité calcule de réduction avec des données de test spécifiques.
     *
     * Cas de test : Test 4 : nombre d'enfants scolarisé plus que 10
     * Données de test : nombre d'enfants = 13
     * Résultat attendu : réduction = null (rejection du nombre d'enfants)
     */
    @Test
    public void testCalculateReductionCas4() {
        int children = 13;
        Double result = service.calculateReduction(children);
        assertTrue(result == null);
    }

    /**
     * Teste la fonctionnalité calcule de réduction avec des données de test limites.
     *
     * Cas de test : Test 5 : nombre d'enfants scolarisé est 0
     * Données de test : nombre d'enfants = 0
     * Résultat attendu : réduction = null (rejection du nombre d'enfants)
     */
    @Test
    public void testCalculateReductionCas5() {
        int children = 0;
        Double result = service.calculateReduction(children);
        assertTrue(result == null);
    }

    /**
     * Teste la fonctionnalité calcule de réduction avec des données de test limites.
     *
     * Cas de test : Test 6 : nombre d'enfants scolarisé est 2
     * Données de test : nombre d'enfants = 2
     * Résultat attendu : réduction = 15 (réduction de 15%)
     */
    @Test
    public void testCalculateReductionCas6() {
        int children = 2;
        Double result = service.calculateReduction(children);
        assertTrue(result == 15D);
    }

    /**
     * Teste la fonctionnalité calcule de réduction avec des données de test limites.
     *
     * Cas de test : Test 7 : nombre d'enfants scolarisé est 10
     * Données de test : nombre d'enfants = 10
     * Résultat attendu : réduction = 15 (réduction de 15%)
     */
    @Test
    public void testCalculateReductionCas7() {
        int children = 10;
        Double result = service.calculateReduction(children);
        assertTrue(result == 15D);
    }
}
