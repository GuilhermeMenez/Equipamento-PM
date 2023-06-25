package com.api.bicicletario.service;

import com.api.bicicletario.enumerator.BicicletaStatus;
import com.api.bicicletario.model.Bicicleta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BicicletaServiceTest {
    private BicicletaService bicicletaService;

    @BeforeEach
    public void setUp() {
        bicicletaService = new BicicletaService();
    }

    @Test
    public void testListarBicicletas() {
        // Adiciona algumas bicicletas para teste
        Bicicleta bicicleta1 = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.NOVA);
        Bicicleta bicicleta2 = new Bicicleta(2, "Marca2", "Modelo2", "2022", 456, BicicletaStatus.EM_USO);
        bicicletaService.adicionarBicicleta(bicicleta1);
        bicicletaService.adicionarBicicleta(bicicleta2);

        List<Bicicleta> bicicletas = bicicletaService.listarBicicletas();

        assertEquals(2, bicicletas.size());
        assertTrue(bicicletas.contains(bicicleta1));
        assertTrue(bicicletas.contains(bicicleta2));
    }

    @Test
    public void testObterBicicletaPorId() {
        // Adiciona uma bicicleta para teste
        Bicicleta bicicleta = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.NOVA);
        bicicletaService.adicionarBicicleta(bicicleta);

        Bicicleta bicicletaObtida = bicicletaService.obterBicicletaPorId(1);

        assertNotNull(bicicletaObtida);
        assertEquals(bicicleta, bicicletaObtida);
    }

    @Test
    public void testObterBicicletaPorId_BicicletaNaoEncontrada() {
        Bicicleta bicicleta = bicicletaService.obterBicicletaPorId(1);

        assertNull(bicicleta);
    }

    @Test
    public void testAdicionarBicicleta() {
        Bicicleta bicicleta = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.NOVA);

        bicicletaService.adicionarBicicleta(bicicleta);

        List<Bicicleta> bicicletas = bicicletaService.listarBicicletas();
        assertEquals(1, bicicletas.size());
        assertTrue(bicicletas.contains(bicicleta));
    }

    @Test
    public void testAtualizarBicicleta() {
        // Adiciona uma bicicleta para teste
        Bicicleta bicicleta = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.NOVA);
        bicicletaService.adicionarBicicleta(bicicleta);

        // Atualiza a bicicleta
        bicicleta.setStatus(BicicletaStatus.EM_USO);
        bicicletaService.atualizarBicicleta(bicicleta);

        Bicicleta bicicletaAtualizada = bicicletaService.obterBicicletaPorId(1);
        assertEquals(BicicletaStatus.EM_USO, bicicletaAtualizada.getStatus());
    }

    @Test
    public void testRemoverBicicleta() {
        // Adiciona uma bicicleta para teste
        Bicicleta bicicleta = new Bicicleta(1, "Marca1", "Modelo1", "2021", 123, BicicletaStatus.APOSENTADA);
        bicicletaService.adicionarBicicleta(bicicleta);

        bicicletaService.removerBicicleta(1);

        List<Bicicleta> bicicletas = bicicletaService.listarBicicletas();
        assertEquals(0, bicicletas.size());
    }



}
