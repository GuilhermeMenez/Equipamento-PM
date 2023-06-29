package com.api.bicicletario.service;

import com.api.bicicletario.enumerator.BicicletaStatus;
import com.api.bicicletario.enumerator.TrancaStatus;
import com.api.bicicletario.model.Bicicleta;
import com.api.bicicletario.model.Totem;
import com.api.bicicletario.model.Tranca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class BicicletaServiceTest {

    private BicicletaService bicicletaService  = mock(BicicletaService.class);

    private TrancaService trancaService;

    private TotemService totemService;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        List<Tranca> trancas = new ArrayList<>();
        trancas.add(new Tranca());
        trancas.add(new Tranca());
        trancas.add(new Tranca());
        trancaService = mock(TrancaService.class);
        totemService = mock(TotemService.class);
        bicicletaService = new BicicletaService(totemService, trancaService);

    }



    @Test
    void testListarBicicletas() {
        // Cenário
        Bicicleta bicicleta1 = new Bicicleta(1, "Marca 1", "Modelo 1", "2023", 123, BicicletaStatus.DISPONIVEL);
        Bicicleta bicicleta2 = new Bicicleta(2, "Marca 2", "Modelo 2", "2023", 456, BicicletaStatus.DISPONIVEL);
        bicicletaService.adicionarBicicleta(bicicleta1);
        bicicletaService.adicionarBicicleta(bicicleta2);

        // Execução
        List<Bicicleta> bicicletas = bicicletaService.listarBicicletas();

        // Verificação
        assertEquals(2, bicicletas.size());
        assertTrue(bicicletas.contains(bicicleta1));
        assertTrue(bicicletas.contains(bicicleta2));
    }

    @Test
    void testObterBicicletaPorId() {
        // Cenário
        Bicicleta bicicleta1 = new Bicicleta(1, "Marca 1", "Modelo 1", "2023", 123, BicicletaStatus.DISPONIVEL);
        Bicicleta bicicleta2 = new Bicicleta(2, "Marca 2", "Modelo 2", "2023", 456, BicicletaStatus.DISPONIVEL);
        bicicletaService.adicionarBicicleta(bicicleta1);
        bicicletaService.adicionarBicicleta(bicicleta2);

        // Execução
        Bicicleta bicicleta = bicicletaService.obterBicicletaPorId(1);

        // Verificação
        assertNotNull(bicicleta);
        assertEquals(bicicleta1, bicicleta);
    }
    @Test
    void testListarBicicletas2() {
        // Cenário
        Bicicleta bicicleta1 = new Bicicleta(1, "Marca 1", "Modelo 1", "2023", 123, BicicletaStatus.DISPONIVEL);
        Bicicleta bicicleta2 = new Bicicleta(2, "Marca 2", "Modelo 2", "2023", 456, BicicletaStatus.DISPONIVEL);
        bicicletaService.adicionarBicicleta(bicicleta1);
        bicicletaService.adicionarBicicleta(bicicleta2);

        // Execução
        List<Bicicleta> bicicletas = bicicletaService.listarBicicletas();

        // Verificação
        assertEquals(2, bicicletas.size());
        assertTrue(bicicletas.contains(bicicleta1));
        assertTrue(bicicletas.contains(bicicleta2));
    }

    @Test
    void testAtualizarBicicleta2() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.DISPONIVEL);
        bicicletaService.adicionarBicicleta(bicicleta);

        // Execução
        bicicleta.setStatus(BicicletaStatus.EM_REPARO);
        bicicletaService.atualizarBicicleta(bicicleta);
        Bicicleta bicicletaAtualizada = bicicletaService.obterBicicletaPorId(1);

        // Verificação
        assertNotNull(bicicletaAtualizada);
        assertEquals(BicicletaStatus.EM_REPARO, bicicletaAtualizada.getStatus());
    }

    @Test
    void testRemoverBicicleta2() {
        // Cenário
        Bicicleta bicicleta1 = new Bicicleta(1, "Marca 1", "Modelo 1", "2023", 123, BicicletaStatus.APOSENTADA);
        Bicicleta bicicleta2 = new Bicicleta(2, "Marca 2", "Modelo 2", "2023", 456, BicicletaStatus.DISPONIVEL);
        bicicletaService.adicionarBicicleta(bicicleta1);
        bicicletaService.adicionarBicicleta(bicicleta2);

        // Execução
        bicicletaService.removerBicicleta(1);
        List<Bicicleta> bicicletas = bicicletaService.listarBicicletas();

        // Verificação
        assertEquals(1, bicicletas.size());
        assertFalse(bicicletas.contains(bicicleta1));
        assertTrue(bicicletas.contains(bicicleta2));
    }
    @Test
    void testIntegrarNaRede() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.NOVA);
        bicicletaService.adicionarBicicleta(bicicleta);
        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.LIVRE);
        tranca.setId(1);
        Totem totem = new Totem(1,"lugar","totem");
        totem.setId(1);

        when(trancaService.getTrancaById(1)).thenReturn(tranca);
        when(totemService.obterTotemPorId(1)).thenReturn(totem);


        // Execução
        boolean integrado = bicicletaService.integrarNaRede("1", "1", 123, 1);

        // Verificação
        assertTrue(integrado);
        assertEquals(BicicletaStatus.NOVA, bicicleta.getStatus());
        assertEquals(123, tranca.getFuncionarioId());

    }

    @Test
    void testAdicionarBicicleta2() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.DISPONIVEL);
        int expectedId = 1;

        // Execução
        bicicletaService.adicionarBicicleta(bicicleta);

        // Verificação
        List<Bicicleta> bicicletas = bicicletaService.listarBicicletas();
        assertEquals(1, bicicletas.size());

        Bicicleta addedBicicleta = bicicletas.get(0);
        assertEquals(expectedId, addedBicicleta.getId());
        assertEquals("Marca", addedBicicleta.getMarca());
        assertEquals("Modelo", addedBicicleta.getModelo());

        assertEquals(BicicletaStatus.DISPONIVEL, addedBicicleta.getStatus());
    }

    @Test
    void testObterBicicletaPorId_BicicletaEncontrada() {
        // Cenário
        Bicicleta bicicleta1 = new Bicicleta(1, "Marca 1", "Modelo 1", "2023", 123, BicicletaStatus.DISPONIVEL);
        Bicicleta bicicleta2 = new Bicicleta(2, "Marca 2", "Modelo 2", "2023", 456, BicicletaStatus.DISPONIVEL);
        bicicletaService.adicionarBicicleta(bicicleta1);
        bicicletaService.adicionarBicicleta(bicicleta2);
        int bicicletaId = 2;

        // Execução
        Bicicleta result = bicicletaService.obterBicicletaPorId(bicicletaId);

        // Verificação
        assertNotNull(result);
        assertEquals(bicicletaId, result.getId());
        assertEquals("Marca 2", result.getMarca());
        assertEquals("Modelo 2", result.getModelo());

        assertEquals(BicicletaStatus.DISPONIVEL, result.getStatus());
    }

    @Test
    void testObterBicicletaPorId_BicicletaNaoEncontrada() {
        // Cenário
        int bicicletaId = 3;

        // Execução
        Bicicleta result = bicicletaService.obterBicicletaPorId(bicicletaId);

        // Verificação
        assertNull(result);
    }


    @Test
    void testAtualizarBicicleta() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.DISPONIVEL);
        bicicletaService.adicionarBicicleta(bicicleta);

        // Execução
        bicicleta.setStatus(BicicletaStatus.EM_REPARO);
        bicicletaService.atualizarBicicleta(bicicleta);
        Bicicleta bicicletaAtualizada = bicicletaService.obterBicicletaPorId(1);

        // Verificação
        assertNotNull(bicicletaAtualizada);
        assertEquals(BicicletaStatus.EM_REPARO, bicicletaAtualizada.getStatus());
    }

    @Test
    void testRemoverBicicleta() {
        // Cenário
        Bicicleta bicicleta1 = new Bicicleta(1, "Marca 1", "Modelo 1", "2023", 123, BicicletaStatus.APOSENTADA);
        Bicicleta bicicleta2 = new Bicicleta(2, "Marca 2", "Modelo 2", "2023", 456, BicicletaStatus.DISPONIVEL);
        bicicletaService.adicionarBicicleta(bicicleta1);
        bicicletaService.adicionarBicicleta(bicicleta2);

        // Execução
        bicicletaService.removerBicicleta(1);
        List<Bicicleta> bicicletasRestantes = bicicletaService.listarBicicletas();

        // Verificação
        assertEquals(1, bicicletasRestantes.size());
        assertFalse(bicicletasRestantes.contains(bicicleta1));
        assertTrue(bicicletasRestantes.contains(bicicleta2));
    }

    @Test
    void testRetirarBicicletaParaReparo_Valido() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.REPARO_SOLICITADO);
        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.OCUPADA);
        int idFuncionario = 123;
        String statusAcaoReparador = BicicletaStatus.EM_REPARO.toString();

        // Execução
        bicicletaService.retirarBicicletaParaReparo(bicicleta, tranca, idFuncionario, statusAcaoReparador);

        // Verificação
        assertEquals(BicicletaStatus.EM_REPARO, bicicleta.getStatus());
        assertEquals(idFuncionario, tranca.getFuncionarioId());
    }

    @Test
    void testRetirarBicicletaParaReparo_BicicletaNula() {
        // Cenário
        Bicicleta bicicleta = null;
        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.OCUPADA);
        int idFuncionario = 123;
        String statusAcaoReparador = "statusAcaoReparador";

        // Verificação
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaService.retirarBicicletaParaReparo(bicicleta, tranca, idFuncionario, statusAcaoReparador);
        });
    }

    @Test
    void testRetirarBicicletaParaReparo_TrancaNula() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.REPARO_SOLICITADO);
        Tranca tranca = null;
        int idFuncionario = 123;
        String statusAcaoReparador = "statusAcaoReparador";

        // Verificação
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaService.retirarBicicletaParaReparo(bicicleta, tranca, idFuncionario, statusAcaoReparador);
        });
    }

    @Test
    void testRetirarBicicletaParaReparo_BicicletaStatusInvalido() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.DISPONIVEL);
        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.OCUPADA);
        int idFuncionario = 123;
        String statusAcaoReparador = "statusAcaoReparador";

        // Verificação
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaService.retirarBicicletaParaReparo(bicicleta, tranca, idFuncionario, statusAcaoReparador);
        });
    }

    @Test
    void testRetirarBicicletaParaReparo_TrancaStatusInvalido() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.REPARO_SOLICITADO);
        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.LIVRE);
        int idFuncionario = 123;
        String statusAcaoReparador = "statusAcaoReparador";

        // Verificação
        assertThrows(IllegalArgumentException.class, () -> {
            bicicletaService.retirarBicicletaParaReparo(bicicleta, tranca, idFuncionario, statusAcaoReparador);
        });
    }

    @Test
    void testIntegrarNaRede_BicicletaNaoEncontrada() {
        // Cenário

        // Execução
        boolean integrado = bicicletaService.integrarNaRede("1", "1", 123, 1);

        // Verificação
        assertFalse(integrado);
        verify(totemService, never()).incluirTrancaEmTotem(any(), any(), anyInt());
    }

    @Test
    void testIntegrarNaRede_TrancaNaoEncontrada() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.NOVA);
        when(trancaService.getTrancaById(1)).thenReturn(null);

        // Execução
        boolean integrado = bicicletaService.integrarNaRede("1", "1", 123, 1);

        // Verificação
        assertFalse(integrado);
        verify(totemService, never()).incluirTrancaEmTotem(any(), any(), anyInt());
    }

    @Test
    void testIntegrarNaRede_BicicletaStatusInvalido() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.DISPONIVEL);
        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.LIVRE);


        when(trancaService.getTrancaById(1)).thenReturn(tranca);

        // Execução
        boolean integrado = bicicletaService.integrarNaRede("1", "1", 123, 1);

        // Verificação
        assertFalse(integrado);
        verify(totemService, never()).incluirTrancaEmTotem(any(), any(), anyInt());
    }

    @Test
    void testIntegrarNaRede_TrancaStatusInvalido() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.NOVA);
        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.OCUPADA);


        when(trancaService.getTrancaById(1)).thenReturn(tranca);

        // Execução
        boolean integrado = bicicletaService.integrarNaRede("1", "1", 123, 1);

        // Verificação
        assertFalse(integrado);
        verify(totemService, never()).incluirTrancaEmTotem(any(), any(), anyInt());
    }

    @Test
    void testIntegrarNaRede_TotemNaoEncontrado() {
        // Cenário
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.NOVA);
        Tranca tranca = new Tranca();
        tranca.setStatus(TrancaStatus.LIVRE);
        Totem totem = new Totem(1, "Lugar", "Totem");

        when(trancaService.getTrancaById(1)).thenReturn(tranca);
        when(totemService.obterTotemPorId(1)).thenReturn(null);

        // Execução
        boolean integrado = bicicletaService.integrarNaRede("1", "1", 123, 1);

        // Verificação
        assertFalse(integrado);
        verify(totemService, never()).incluirTrancaEmTotem(any(), any(), anyInt());
    }


}
