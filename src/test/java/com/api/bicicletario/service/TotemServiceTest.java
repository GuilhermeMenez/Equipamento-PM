package com.api.bicicletario.service;

import com.api.bicicletario.enumerator.BicicletaStatus;
import com.api.bicicletario.enumerator.TrancaStatus;
import com.api.bicicletario.model.Bicicleta;
import com.api.bicicletario.model.Totem;
import com.api.bicicletario.model.Tranca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TotemServiceTest {

    private TotemService totemService;
    private Totem totem;
    private Tranca trancaNova;
    private Tranca trancaEmReparo;
    private int funcionarioId = 1;

    @BeforeEach
    public void setup() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.EM_REPARO);
        Bicicleta bicicleta2 = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.EM_REPARO);

        totemService = new TotemService();
        totem = new Totem(1, "Localização do Totem", "Descrição do Totem");
        trancaNova = new Tranca(1, bicicleta, 1234, "Localização A", "2022", "Modelo X", TrancaStatus.NOVA);
        trancaEmReparo = new Tranca(2, bicicleta2, 5678, "Localização B", "2021", "Modelo Y", TrancaStatus.EM_REPARO);
        trancaEmReparo.setFuncionarioId(funcionarioId);
    }

    @Test
    public void incluirTrancaEmTotem_TrancaNova_SuccessfullyIncluded() {
        // Act
        totemService.incluirTrancaEmTotem(totem, trancaNova, funcionarioId);

        // Assert
        assertEquals(1, totem.getTrancas().size());
        assertEquals(trancaNova, totem.getTrancas().get(0));
        assertEquals(TrancaStatus.LIVRE, trancaNova.getStatus());
    }

    @Test
    public void incluirTrancaEmTotem_TrancaEmReparo_SuccessfullyIncluded() {
        // Act
        totemService.incluirTrancaEmTotem(totem, trancaEmReparo, funcionarioId);

        // Assert
        assertEquals(1, totem.getTrancas().size());
        assertEquals(trancaEmReparo, totem.getTrancas().get(0));
        assertEquals(TrancaStatus.LIVRE, trancaEmReparo.getStatus());
    }

    @Test
    public void incluirTrancaEmTotem_NullTranca_ThrowsIllegalArgumentException() {
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            totemService.incluirTrancaEmTotem(totem, null, funcionarioId);
        });
    }

    @Test
    public void incluirTrancaEmTotem_InvalidStatus_ThrowsIllegalArgumentException() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.EM_REPARO);

        // Arrange
        Tranca trancaInvalida = new Tranca(3, bicicleta, 9876, "Localização C", "2023", "Modelo Z", TrancaStatus.APOSENTADA);

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            totemService.incluirTrancaEmTotem(totem, trancaInvalida, funcionarioId);
        });
    }

    @Test
    public void incluirTrancaEmTotem_DifferentEmployeeIdForRepairedLock_ThrowsIllegalArgumentException() {
        // Arrange
        int invalidFuncionarioId = 2;

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            totemService.incluirTrancaEmTotem(totem, trancaEmReparo, invalidFuncionarioId);
        });
    }

    @Test
    void testAtualizarTotem_TotemExistente() {
        // Cenário
        int id = 1;
        Totem totemExistente = new Totem(id, "Lugar", "Totem");
        Totem totemAtualizado = new Totem(id, "Novo Lugar", "Novo Totem");

        totemService.criarTotem(totemExistente);
        Totem resultado = totemService.atualizarTotem(id, totemAtualizado);

        // Verificação
        assertNotNull(resultado);
        assertEquals(totemAtualizado, resultado);

    }

    @Test
    void testAtualizarTotem_TotemNaoExistente() {
        // Cenário
        int id = 1;
        Totem totemAtualizado = new Totem(id, "Novo Lugar", "Novo Totem");

        Totem resultado = totemService.atualizarTotem(id, totemAtualizado);

        // Verificação
        assertNull(resultado);

    }
}
