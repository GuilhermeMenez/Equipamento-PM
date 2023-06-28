package com.api.bicicletario.controller;


import com.api.bicicletario.model.Totem;
import com.api.bicicletario.service.TotemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TotemControllerTest {
    @Mock
    private TotemService totemService;

    @InjectMocks
    private TotemController totemController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarTotem_DeveRetornarNovoTotemCriado() {
        // Dados de entrada
        Totem totem = new Totem(1, "Localização do Totem", "Descrição do Totem");

        totem.setId(1);
        when(totemService.criarTotem(totem)).thenReturn(totem);

        // Executar a ação
        ResponseEntity<Totem> response = totemController.criarTotem(totem);

        // Verificar o resultado
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(totem, response.getBody());
        verify(totemService, times(1)).criarTotem(totem);
    }

    @Test
    void obterTotemPorId_Existente_DeveRetornarTotem() {
        // Dados de entrada
        int id = 1;
        Totem totem = new Totem(1, "Localização do Totem", "Descrição do Totem");
        totem.setId(id);
        when(totemService.obterTotemPorId(id)).thenReturn(totem);

        // Executar a ação
        ResponseEntity<Totem> response = totemController.obterTotemPorId(id);

        // Verificar o resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(totem, response.getBody());
        verify(totemService, times(1)).obterTotemPorId(id);
    }

    @Test
    void obterTotemPorId_Inexistente_DeveRetornarNotFound() {
        // Dados de entrada
        int id = 1;
        when(totemService.obterTotemPorId(id)).thenReturn(null);

        // Executar a ação
        ResponseEntity<Totem> response = totemController.obterTotemPorId(id);

        // Verificar o resultado
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(totemService, times(1)).obterTotemPorId(id);
    }

    @Test
    void atualizarTotem_Existente_DeveRetornarTotemAtualizado() {
        // Dados de entrada
        int id = 1;
        Totem totem = new Totem(1, "Localização do Totem", "Descrição do Totem");
        totem.setId(id);
        when(totemService.atualizarTotem(id, totem)).thenReturn(totem);

        // Executar a ação
        ResponseEntity<Totem> response = totemController.atualizarTotem(id, totem);

        // Verificar o resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(totem, response.getBody());
        verify(totemService, times(1)).atualizarTotem(id, totem);
    }

    @Test
    void atualizarTotem_Inexistente_DeveRetornarNotFound() {
        // Dados de entrada
        int id = 1;
        Totem totem = new Totem(1, "Localização do Totem", "Descrição do Totem");
        totem.setId(id);
        when(totemService.atualizarTotem(id, totem)).thenReturn(null);

        // Executar a ação
        ResponseEntity<Totem> response = totemController.atualizarTotem(id, totem);

        // Verificar o resultado
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(totemService, times(1)).atualizarTotem(id, totem);
    }

    @Test
    void deletarTotem_Existente_DeveRetornarNoContent() {
        // Dados de entrada
        int id = 1;
        when(totemService.deletarTotem(id)).thenReturn(true);

        // Executar a ação
        ResponseEntity<Void> response = totemController.deletarTotem(id);

        // Verificar o resultado
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(totemService, times(1)).deletarTotem(id);
    }

    @Test
    void deletarTotem_Inexistente_DeveRetornarNotFound() {
        // Dados de entrada
        int id = 1;
        when(totemService.deletarTotem(id)).thenReturn(false);

        // Executar a ação
        ResponseEntity<Void> response = totemController.deletarTotem(id);

        // Verificar o resultado
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(totemService, times(1)).deletarTotem(id);
    }

    @Test
    void listarTotens_DeveRetornarListaDeTotens() {
        // Dados de entrada
        Totem totem1 = new Totem(1, "Localização do Totem", "Descrição do Totem");
        totem1.setId(1);
        Totem totem2 = new Totem(2, "Localização do Totem", "Descrição do Totem");
        totem2.setId(2);
        List<Totem> totens = Arrays.asList(totem1, totem2);
        when(totemService.listarTotens()).thenReturn(totens);

        // Executar a ação
        ResponseEntity<List<Totem>> response = totemController.listarTotens();

        // Verificar o resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(totens, response.getBody());
        verify(totemService, times(1)).listarTotens();
    }

    @Test
    void construtor_DeveAtribuirValoresCorretosAosAtributos() {
        // Dados de entrada
        int id = 1;
        String localizacao = "Localização do Totem";
        String descricao = "Descrição do Totem";

        // Executar a ação
        Totem totem = new Totem(id, localizacao, descricao);

        // Verificar o resultado
        assertEquals(id, totem.getId());
        assertEquals(localizacao, totem.getLocalizacao());
        assertEquals(descricao, totem.getDescricao());
        assertNotNull(totem.getTrancas()); // Verifica se a lista de trancas não é nula
    }
    @Test
    void deletarTotem_Sucesso_DeveRetornarNoContent() {
        // Dados de entrada
        int id = 1;
        when(totemService.deletarTotem(id)).thenReturn(true);

        // Executar a ação
        ResponseEntity<Void> response = totemController.deletarTotem(id);

        // Verificar o resultado
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(totemService, times(1)).deletarTotem(id);
    }

    @Test
    void listarTotens_SemTotensCadastrados_DeveRetornarListaVazia() {
        // Simular lista vazia de totens
        when(totemService.listarTotens()).thenReturn(Collections.emptyList());

        // Executar a ação
        ResponseEntity<List<Totem>> response = totemController.listarTotens();

        // Verificar o resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isEmpty());
        verify(totemService, times(1)).listarTotens();
    }

    @Test
    void listarTotens_TotensCadastrados_DeveRetornarListaDeTotens() {
        // Dados de entrada
        Totem totem1 = new Totem(1, "Localização do Totem", "Descrição do Totem");
        totem1.setId(1);
        Totem totem2 = new Totem(1, "Localização do Totem", "Descrição do Totem");
        totem2.setId(2);
        List<Totem> totens = Arrays.asList(totem1, totem2);
        when(totemService.listarTotens()).thenReturn(totens);

        // Executar a ação
        ResponseEntity<List<Totem>> response = totemController.listarTotens();

        // Verificar o resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(totens, response.getBody());
        verify(totemService, times(1)).listarTotens();
    }

    @Test
    void criarTotem_DadosCorretos_DeveChamarServicoComArgumentosCorretos() {
        // Dados de entrada
        Totem totem = new Totem(1, "Localização do Totem", "Descrição do Totem");
        totem.setId(1);
        totem.setLocalizacao("Localização do Totem");
        totem.setDescricao("Descrição do Totem");

        // Executar a ação
        totemController.criarTotem(totem);

        // Capturar o argumento passado para o serviço
        ArgumentCaptor<Totem> totemCaptor = ArgumentCaptor.forClass(Totem.class);
        verify(totemService, times(1)).criarTotem(totemCaptor.capture());

        // Verificar o argumento capturado
        Totem argumentoCapturado = totemCaptor.getValue();
        assertEquals(totem.getId(), argumentoCapturado.getId());
        assertEquals(totem.getLocalizacao(), argumentoCapturado.getLocalizacao());
        assertEquals(totem.getDescricao(), argumentoCapturado.getDescricao());
    }

}
