package com.api.bicicletario.controller;
import com.api.bicicletario.enumerator.BicicletaStatus;
import com.api.bicicletario.model.Bicicleta;
import com.api.bicicletario.service.BicicletaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BicicletaControllerTest {
    @InjectMocks
    private BicicletaController bicicletaController;



    @Mock
    private BicicletaService bicicletaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarBicicletas() {
        Bicicleta bicicleta1 = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.APOSENTADA);
        Bicicleta bicicleta2 = new Bicicleta(2, "Marca2", "Modelo2", "2022", 456, BicicletaStatus.NOVA);

        List<Bicicleta> bicicletas = Arrays.asList(bicicleta1, bicicleta2);

        when(bicicletaService.listarBicicletas()).thenReturn(bicicletas);

        List<Bicicleta> result = bicicletaController.listarBicicletas();

        assertEquals(2, result.size());
        assertEquals(bicicleta1, result.get(0));
        assertEquals(bicicleta2, result.get(1));

        verify(bicicletaService, times(1)).listarBicicletas();
    }

    @Test
    void testObterBicicletaPorId() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.APOSENTADA);

        when(bicicletaService.obterBicicletaPorId(1)).thenReturn(bicicleta);

        Bicicleta result = bicicletaController.obterBicicletaPorId(1);

        assertEquals(bicicleta, result);

        verify(bicicletaService, times(1)).obterBicicletaPorId(1);
    }

    @Test
    void testAdicionarBicicleta() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.NOVA);

        bicicletaController.adicionarBicicleta(bicicleta);

        verify(bicicletaService, times(1)).adicionarBicicleta(bicicleta);
    }

    @Test
    void testAtualizarBicicleta() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.NOVA);

        bicicletaController.atualizarBicicleta(1, bicicleta);

        verify(bicicletaService, times(1)).atualizarBicicleta(bicicleta);
        assertEquals(1, bicicleta.getId());
    }

    @Test
    void testRemoverBicicleta() {
        bicicletaController.removerBicicleta(1);

        verify(bicicletaService, times(1)).removerBicicleta(1);
    }



}

