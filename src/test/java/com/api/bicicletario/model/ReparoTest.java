package com.api.bicicletario.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ReparoTest {

    @Mock
    private Bicicleta mockBicicleta;

    @Mock
    private Tranca mockTranca;

    private Reparo reparo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        reparo = new Reparo(mockBicicleta, mockTranca, "Pending");
    }

    @Test
    public void testSetStatusAcaoReparador() {
        String newStatus = "em andamento";

        reparo.setStatusAcaoReparador(newStatus);

        // Verify that the status has been set
        assertSame(newStatus, reparo.statusAcaoReparador);
    }
}
