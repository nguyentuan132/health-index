package com.guriani.health_index.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Classe de test pour le service de diagnostic.
 * Vérifie que la logique de diagnostic fonctionne comme prévu.
 */
public class DiagnosticServiceTest {

    private final IDiagnosticService diagnosticService = new DiagnosticService();

    /**
     * Test pour vérifier le diagnostic d'un problème cardiaque.
     * Un index de santé de 33 doit retourner "Cardiologie".
     */
    @Test
    void testCardiologie() {
        String result = diagnosticService.diagnostiquer(33);
        assertEquals("Cardiologie", result);
    }

    /**
     * Test pour vérifier le diagnostic d'une fracture.
     * Un index de santé de 55 doit retourner "Traumatologie".
     */
    @Test
    void testTraumatologie() {
        String result = diagnosticService.diagnostiquer(55);
        assertEquals("Traumatologie", result);
    }

    /**
     * Test pour vérifier le diagnostic de plusieurs pathologies.
     * Un index de santé de 15 doit retourner "Cardiologie, Traumatologie".
     */
    @Test
    void testMultiplePathologies() {
        String result = diagnosticService.diagnostiquer(15);
        assertEquals("Cardiologie, Traumatologie", result);
    }

    /**
     * Test pour vérifier qu'aucune pathologie n'est détectée.
     * Un index de santé de 7 doit retourner "Aucune pathologie détectée".
     */
    @Test
    void testAucunePathologie() {
        String result = diagnosticService.diagnostiquer(7);
        assertEquals("Aucune pathologie détectée", result);
    }
}
