package com.api.bicicletario.model;

import com.api.bicicletario.enumerator.BicicletaStatus;
import com.api.bicicletario.enumerator.TrancaStatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrancaTest {

    @Mock
    private Tranca mockTranca;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetId() {
        when(mockTranca.getId()).thenReturn(1);
        assertEquals(1, mockTranca.getId());
    }

    @Test
    void testSetId() {
        mockTranca.setId(1);
        verify(mockTranca).setId(1);
    }

    @Test
    void testGetBicicleta() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2022", 123, BicicletaStatus.DISPONIVEL);
        when(mockTranca.getBicicleta()).thenReturn(bicicleta);
        assertEquals(bicicleta, mockTranca.getBicicleta());
    }

    @Test
    void testSetBicicleta() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2022", 123, BicicletaStatus.DISPONIVEL);
        mockTranca.setBicicleta(bicicleta);
        verify(mockTranca).setBicicleta(bicicleta);
    }

    @Test
    void testGetNumero() {
        when(mockTranca.getNumero()).thenReturn(123);
        assertEquals(123, mockTranca.getNumero());
    }

    @Test
    void testSetNumero() {
        mockTranca.setNumero(123);
        verify(mockTranca).setNumero(123);
    }

    @Test
    void testGetLocalizacao() {
        when(mockTranca.getLocalizacao()).thenReturn("Location");
        assertEquals("Location", mockTranca.getLocalizacao());
    }

    @Test
    void testSetLocalizacao() {
        mockTranca.setLocalizacao("Location");
        verify(mockTranca).setLocalizacao("Location");
    }

    @Test
    void testGetAnoDeFabricacao() {
        when(mockTranca.getAnoDeFabricacao()).thenReturn("2022");
        assertEquals("2022", mockTranca.getAnoDeFabricacao());
    }

    @Test
    void testSetAnoDeFabricacao() {
        mockTranca.setAnoDeFabricacao("2022");
        verify(mockTranca).setAnoDeFabricacao("2022");
    }

    @Test
    void testGetModelo() {
        when(mockTranca.getModelo()).thenReturn("Model");
        assertEquals("Model", mockTranca.getModelo());
    }

    @Test
    void testSetModelo() {
        mockTranca.setModelo("Model");
        verify(mockTranca).setModelo("Model");
    }

    @Test
    void testGetStatus() {
        when(mockTranca.getStatus()).thenReturn(TrancaStatus.LIVRE);
        assertEquals(TrancaStatus.LIVRE, mockTranca.getStatus());
    }

    @Test
    void testSetStatus() {
        mockTranca.setStatus(TrancaStatus.LIVRE);
        verify(mockTranca).setStatus(TrancaStatus.LIVRE);
    }

    @Test
    void testEquals() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2022", 123,BicicletaStatus.DISPONIVEL);
        Tranca tranca1 = new Tranca(1, bicicleta, 123, "Location", "2022", "Model", TrancaStatus.LIVRE);
        Tranca tranca2 = new Tranca(1, bicicleta, 123, "Location", "2022", "Model", TrancaStatus.LIVRE);
        assertEquals(tranca1, tranca2);
    }

    @Test
    void testHashCode() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2022", 123, BicicletaStatus.DISPONIVEL);
        Tranca tranca1 = new Tranca(1, bicicleta, 123, "Location", "2022", "Model", TrancaStatus.LIVRE);
        Tranca tranca2 = new Tranca(1, bicicleta, 123, "Location", "2022", "Model", TrancaStatus.LIVRE);
        assertEquals(tranca1.hashCode(), tranca2.hashCode());
    }
}
