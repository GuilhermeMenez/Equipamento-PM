package com.api.bicicletario.service;

import com.api.bicicletario.enumerator.BicicletaStatus;
import com.api.bicicletario.enumerator.TrancaStatus;
import com.api.bicicletario.model.Bicicleta;
import com.api.bicicletario.model.Tranca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
class BicicletaServiceTest {
    @Mock
    private BicicletaService bicicletaService  = mock(BicicletaService.class);




    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void testListarBicicletas() {
        // Cria uma lista de bicicletas para simular os dados
        List<Bicicleta> bicicletas = new ArrayList<>();
        bicicletas.add(new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.APOSENTADA));
        bicicletas.add(new Bicicleta(2, "Marca2", "Modelo2", "2022", 456, BicicletaStatus.APOSENTADA));

        // Define o comportamento do mock para retornar a lista de bicicletas
        when(bicicletaService.listarBicicletas()).thenReturn(bicicletas);

        // Chama o método que será testado
        List<Bicicleta> result = bicicletaService.listarBicicletas();

        // Verifica o resultado
        assertEquals(bicicletas, result);

        // Verifica se o método do mock foi chamado corretamente
        verify(bicicletaService, times(1)).listarBicicletas();
    }

    @Test
    void testObterBicicletaPorId_BicicletaEncontrada() {
        // Cria uma bicicleta para simular os dados
        Bicicleta bicicleta = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.APOSENTADA);

        // Define o comportamento do mock para retornar a bicicleta
        when(bicicletaService.obterBicicletaPorId(1)).thenReturn(bicicleta);

        // Chama o método que será testado
        Bicicleta result = bicicletaService.obterBicicletaPorId(1);

        // Verifica o resultado
        assertEquals(bicicleta, result);

        // Verifica se o método do mock foi chamado corretamente
        verify(bicicletaService, times(1)).obterBicicletaPorId(1);
    }

    @Test
    void testObterBicicletaPorId_BicicletaNaoEncontrada() {
        // Define o comportamento do mock para retornar null
        when(bicicletaService.obterBicicletaPorId(1)).thenReturn(null);

        // Chama o método que será testado
        Bicicleta result = bicicletaService.obterBicicletaPorId(1);

        // Verifica o resultado
        assertNull(result);

        // Verifica se o método do mock foi chamado corretamente
        verify(bicicletaService, times(1)).obterBicicletaPorId(1);
    }

    @Test
    void testAdicionarBicicleta() {
        // Cria uma bicicleta para simular os dados
        Bicicleta bicicleta = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.APOSENTADA);

        // Chama o método que será testado
        bicicletaService.adicionarBicicleta(bicicleta);

        // Verifica se a bicicleta foi adicionada corretamente
        List<Bicicleta> bicicletas = new ArrayList<>();
        bicicletas.add(bicicleta);
        when(bicicletaService.listarBicicletas()).thenReturn(bicicletas);

        List<Bicicleta> result = bicicletaService.listarBicicletas();
        assertEquals(1, result.size());
        assertTrue(result.contains(bicicleta));

        // Verifica se o método do mock foi chamado corretamente
        verify(bicicletaService, times(1)).adicionarBicicleta(bicicleta);
        verify(bicicletaService, times(1)).listarBicicletas();
    }


    @Test
    void testAtualizarBicicleta() {
        // Cria uma bicicleta para simular os dados
        Bicicleta bicicleta = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.APOSENTADA);

        // Define o comportamento do mock para retornar a bicicleta
        when(bicicletaService.obterBicicletaPorId(1)).thenReturn(bicicleta);

        // Chama o método que será testado
        bicicletaService.atualizarBicicleta(bicicleta);

        // Verifica se a bicicleta foi atualizada corretamente
        Bicicleta bicicletaAtualizada = bicicletaService.obterBicicletaPorId(1);
        assertNotNull(bicicletaAtualizada);
        assertEquals(bicicleta, bicicletaAtualizada);

        // Verifica se o método do mock foi chamado corretamente
        verify(bicicletaService, times(1)).atualizarBicicleta(bicicleta);
    }

    @Test
    void testRemoverBicicleta() {
        // Cria uma bicicleta para simular os dados
        Bicicleta bicicleta = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.APOSENTADA);

        // Adiciona a bicicleta à lista
        bicicletaService.adicionarBicicleta(bicicleta);

        // Chama o método que será testado
        bicicletaService.removerBicicleta(1);

        // Verifica se a bicicleta foi removida corretamente
        List<Bicicleta> bicicletas = bicicletaService.listarBicicletas();
        assertEquals(0, bicicletas.size());

        // Verifica se o método do mock foi chamado corretamente
        verify(bicicletaService, times(1)).removerBicicleta(1);
    }

    @Test
    public void testRetirarBicicletaParaReparo_Success2() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.EM_REPARO);

        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.OCUPADA);

        int idFuncionario = 0;
        String statusAcaoReparador = "statusAcaoReparador";

        bicicletaService.retirarBicicletaParaReparo(bicicleta, tranca, idFuncionario, statusAcaoReparador);

        assertEquals(BicicletaStatus.EM_REPARO, bicicleta.getStatus());
        assertEquals(idFuncionario, tranca.getFuncionarioId());
    }
    @Test
    void testRetirarBicicletaParaReparo_Success() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.DISPONIVEL);

        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.OCUPADA);

        int idFuncionario = 0;
        String statusAcaoReparador = "statusAcaoReparador";

        bicicletaService.retirarBicicletaParaReparo(bicicleta, tranca, idFuncionario, statusAcaoReparador);

        assertEquals(BicicletaStatus.DISPONIVEL, bicicleta.getStatus());
        assertEquals(idFuncionario, tranca.getFuncionarioId());
    }

    @Test
    void testRetirarBicicletaParaReparo_Failure_BicicletaEmUso() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.EM_USO);

        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.OCUPADA);

        int idFuncionario = 0;
        String statusAcaoReparador = "statusAcaoReparador";

        assertThrows(IllegalArgumentException.class, () -> {
            if (bicicleta.getStatus() == BicicletaStatus.EM_USO) {
                throw new IllegalArgumentException("Bicicleta está em uso");
            }
            bicicletaService.retirarBicicletaParaReparo(bicicleta, tranca, idFuncionario, statusAcaoReparador);
        });

        verify(bicicletaService, never()).atualizarBicicleta(any(Bicicleta.class));
    }

    @Test
    void testRetirarBicicletaParaReparo_Failure_TrancaNaoOcupada() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.DISPONIVEL);

        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.LIVRE);

        int idFuncionario = 0;
        String statusAcaoReparador = "statusAcaoReparador";

        assertThrows(IllegalArgumentException.class, () -> {
            if (tranca.getStatus() != TrancaStatus.OCUPADA) {
                throw new IllegalArgumentException("A tranca não está ocupada");
            }
            bicicletaService.retirarBicicletaParaReparo(bicicleta, tranca, idFuncionario, statusAcaoReparador);
        });

        verify(bicicletaService, never()).atualizarBicicleta(any(Bicicleta.class));
    }



}
