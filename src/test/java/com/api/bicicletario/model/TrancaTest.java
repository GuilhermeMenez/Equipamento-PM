package com.api.bicicletario.model;

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
        when(mockTranca.getBicicleta()).thenReturn("Bike");
        assertEquals("Bike", mockTranca.getBicicleta());
    }

    @Test
    void testSetBicicleta() {
        mockTranca.setBicicleta("Bike");
        verify(mockTranca).setBicicleta("Bike");
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
        Tranca tranca1 = new Tranca(1, "Bike", 123, "Location", "2022", "Model", TrancaStatus.LIVRE);
        Tranca tranca2 = new Tranca(1, "Bike", 123, "Location", "2022", "Model", TrancaStatus.LIVRE);
        assertEquals(tranca1, tranca2);
    }

    @Test
    void testHashCode() {
        Tranca tranca1 = new Tranca(1, "Bike", 123, "Location", "2022", "Model", TrancaStatus.LIVRE);
        Tranca tranca2 = new Tranca(1, "Bike", 123, "Location", "2022", "Model", TrancaStatus.LIVRE);
        assertEquals(tranca1.hashCode(), tranca2.hashCode());
    }
}
