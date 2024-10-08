package com.guriani.health_index.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DiagnosticServiceTest {

    private final IDiagnosticService diagnosticService = new DiagnosticService();

    @Test
    void testCardiologie() {
        String result = diagnosticService.diagnostiquer(33);
        assertEquals("Cardiologie", result);
    }

    @Test
    void testTraumatologie() {
        String result = diagnosticService.diagnostiquer(55);
        assertEquals("Traumatologie", result);
    }

    @Test
    void testMultiplePathologies() {
        String result = diagnosticService.diagnostiquer(15);
        assertEquals("Cardiologie, Traumatologie", result);
    }

    @Test
    void testAucunePathologie() {
        String result = diagnosticService.diagnostiquer(7);
        assertEquals("Aucune pathologie détectée", result);
    }
}
