package com.api.bicicletario.service;

import com.api.bicicletario.enumerator.TrancaStatus;
import com.api.bicicletario.model.Totem;
import com.api.bicicletario.model.Tranca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TotemServiceTest {

    private TotemService totemService;
    private Totem totem;
    private Tranca trancaNova;
    private Tranca trancaEmReparo;
    private int funcionarioId = 1;

    @BeforeEach
    public void setup() {
        totemService = new TotemService();
        totem = new Totem(1, "Localização do Totem", "Descrição do Totem");
        trancaNova = new Tranca(1, "Bicicleta 1", 1234, "Localização A", "2022", "Modelo X", TrancaStatus.NOVA);
        trancaEmReparo = new Tranca(2, "Bicicleta 2", 5678, "Localização B", "2021", "Modelo Y", TrancaStatus.EM_REPARO);
        trancaEmReparo.setFuncionarioId(funcionarioId);
    }

    @Test
    public void incluirTrancaEmTotem_TrancaNova_SuccessfullyIncluded() {
        // Act
        totemService.incluirTrancaEmTotem(totem, trancaNova, funcionarioId);

        // Assert
        Assertions.assertEquals(1, totem.getTrancas().size());
        Assertions.assertEquals(trancaNova, totem.getTrancas().get(0));
        Assertions.assertEquals(TrancaStatus.LIVRE, trancaNova.getStatus());
    }

    @Test
    public void incluirTrancaEmTotem_TrancaEmReparo_SuccessfullyIncluded() {
        // Act
        totemService.incluirTrancaEmTotem(totem, trancaEmReparo, funcionarioId);

        // Assert
        Assertions.assertEquals(1, totem.getTrancas().size());
        Assertions.assertEquals(trancaEmReparo, totem.getTrancas().get(0));
        Assertions.assertEquals(TrancaStatus.LIVRE, trancaEmReparo.getStatus());
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
        // Arrange
        Tranca trancaInvalida = new Tranca(3, "Bicicleta 3", 9876, "Localização C", "2023", "Modelo Z", TrancaStatus.APOSENTADA);

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
}
