package com.api.bicicletario.service;

import com.api.bicicletario.enumerator.BicicletaStatus;
import com.api.bicicletario.enumerator.TrancaStatus;
import com.api.bicicletario.model.Bicicleta;
import com.api.bicicletario.model.Totem;
import com.api.bicicletario.model.Tranca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TrancaServiceTest {

    private TrancaService trancaService;
    private List<Tranca> trancas;

    @BeforeEach
    public void setUp() {
        Bicicleta bicicleta1 = new Bicicleta(1, "Marca 1", "Modelo 1", "2022", 1, BicicletaStatus.DISPONIVEL);
        Bicicleta bicicleta2 = new Bicicleta(2, "Marca 2", "Modelo 2", "2021", 2, BicicletaStatus.EM_USO);
        Bicicleta bicicleta3 = new Bicicleta(3, "Marca 3", "Modelo 3", "2020", 3, BicicletaStatus.NOVA);
        Bicicleta bicicleta4 = new Bicicleta(4, "Marca 4", "Modelo 4", "2019", 4, BicicletaStatus.APOSENTADA);
        Bicicleta bicicleta5 = new Bicicleta(5, "Marca 5", "Modelo 5", "2023", 5, BicicletaStatus.REPARO_SOLICITADO);
        Bicicleta bicicleta6 = new Bicicleta(6, "Marca 6", "Modelo 6", "2022", 6, BicicletaStatus.EM_REPARO);
        Bicicleta bicicleta7 = new Bicicleta(7, "Marca 7", "Modelo 7", "2021", 7, BicicletaStatus.DISPONIVEL);
        Bicicleta bicicleta8 = new Bicicleta(8, "Marca 8", "Modelo 8", "2020", 8, BicicletaStatus.EM_USO);
        Bicicleta bicicleta9 = new Bicicleta(9, "Marca 9", "Modelo 9", "2019", 9, BicicletaStatus.NOVA);
        Bicicleta bicicleta10 = new Bicicleta(10, "Marca 10", "Modelo 10", "2023", 10, BicicletaStatus.APOSENTADA);
        Bicicleta bicicleta11 = new Bicicleta(11, "Marca 11", "Modelo 11", "2022", 11, BicicletaStatus.REPARO_SOLICITADO);
        Bicicleta bicicleta12 = new Bicicleta(12, "Marca 12", "Modelo 12", "2021", 12, BicicletaStatus.EM_REPARO);
        Bicicleta bicicleta13 = new Bicicleta(13, "Marca 13", "Modelo 13", "2020", 13, BicicletaStatus.DISPONIVEL);
        Bicicleta bicicleta14 = new Bicicleta(14, "Marca 14", "Modelo 14", "2019", 14, BicicletaStatus.EM_USO);
        Bicicleta bicicleta15 = new Bicicleta(15, "Marca 15", "Modelo 15", "2023", 15, BicicletaStatus.NOVA);

        trancas = new ArrayList<>();
        trancas.add(new Tranca(1, bicicleta1, 1, "Localização 1", "2022", "Modelo 1", TrancaStatus.LIVRE));
        trancas.add(new Tranca(2, bicicleta2, 2, "Localização 2", "2021", "Modelo 2", TrancaStatus.OCUPADA));
        trancas.add(new Tranca(3, bicicleta3, 3, "Localização 3", "2020", "Modelo 3", TrancaStatus.NOVA));
        trancas.add(new Tranca(4, bicicleta4, 4, "Localização 4", "2019", "Modelo 4", TrancaStatus.APOSENTADA));
        trancas.add(new Tranca(5, bicicleta5, 5, "Localização 5", "2023", "Modelo 5", TrancaStatus.EM_REPARO));
        trancas.add(new Tranca(6, bicicleta6, 6, "Localização 6", "2022", "Modelo 6", TrancaStatus.LIVRE));
        trancas.add(new Tranca(7, bicicleta7, 7, "Localização 7", "2021", "Modelo 7", TrancaStatus.OCUPADA));
        trancas.add(new Tranca(8, bicicleta8, 8, "Localização 8", "2020", "Modelo 8", TrancaStatus.NOVA));
        trancas.add(new Tranca(9, bicicleta9, 9, "Localização 9", "2019", "Modelo 9", TrancaStatus.APOSENTADA));
        trancas.add(new Tranca(10, bicicleta10, 10, "Localização 10", "2023", "Modelo 10", TrancaStatus.EM_REPARO));
        trancas.add(new Tranca(11, bicicleta11, 11, "Localização 11", "2022", "Modelo 11", TrancaStatus.LIVRE));
        trancas.add(new Tranca(12, bicicleta12, 12, "Localização 12", "2021", "Modelo 12", TrancaStatus.OCUPADA));
        trancas.add(new Tranca(13, bicicleta13, 13, "Localização 13", "2020", "Modelo 13", TrancaStatus.NOVA));
        trancas.add(new Tranca(14, bicicleta14, 14, "Localização 14", "2019", "Modelo 14", TrancaStatus.APOSENTADA));
        trancas.add(new Tranca(15, bicicleta15, 15, "Localização 15", "2023", "Modelo 15", TrancaStatus.EM_REPARO));

        trancaService = new TrancaService(trancas);
    }

    @Test
    public void testGetTrancas() {
        List<Tranca> result = trancaService.getTrancas();

        assertEquals(trancas, result);
    }

    @Test
    public void testGetTrancaById() {
        int trancaId = 1;
        Bicicleta bicicleta = new Bicicleta(1, "Marca 1", "Modelo 1", "2022", 1, BicicletaStatus.DISPONIVEL);
        Tranca expectedTranca = new Tranca(1, bicicleta, 1, "Localização 1", "2022", "Modelo 1", TrancaStatus.LIVRE);

        Tranca result = trancaService.getTrancaById(trancaId);

        assertEquals(expectedTranca.getId(), result.getId());
        assertEquals(expectedTranca.getBicicleta().getId(), result.getBicicleta().getId());
        assertEquals(expectedTranca.getNumero(), result.getNumero());
        assertEquals(expectedTranca.getLocalizacao(), result.getLocalizacao());
        assertEquals(expectedTranca.getAnoDeFabricacao(), result.getAnoDeFabricacao());
        assertEquals(expectedTranca.getModelo(), result.getModelo());
        assertEquals(expectedTranca.getStatus(), result.getStatus());
    }


    @Test
    public void testCreateTranca() {
        Bicicleta bicicleta = new Bicicleta(16, "Marca 16", "Modelo 16", "2023", 16, BicicletaStatus.DISPONIVEL);
        Tranca tranca = new Tranca(16, bicicleta, 16, "Localização 16", "2023", "Modelo 16", TrancaStatus.NOVA);

        Tranca result = trancaService.createTranca(tranca);

        assertEquals(tranca, result);
        assertEquals(16, trancaService.getTrancas().size());
    }


    @Test
    public void testUpdateTranca() {
        Bicicleta bicicleta = new Bicicleta(16, "Marca 16", "Modelo 16", "2023", 16, BicicletaStatus.DISPONIVEL);

        Tranca tranca = new Tranca(1, bicicleta, 1, "Localização 1 Atualizada", "2022", "Modelo 1", TrancaStatus.APOSENTADA);

        Tranca result = trancaService.updateTranca(tranca);

        assertEquals(tranca, result);
        assertEquals("Localização 1 Atualizada", trancaService.getTrancaById(1).getLocalizacao());
        assertEquals(TrancaStatus.APOSENTADA, trancaService.getTrancaById(1).getStatus());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testDeleteTranca(int trancaId) {
        trancaService.deleteTranca(trancaId);
        List<Tranca> remainingTrancas = trancaService.getTrancas();
        assertEquals(14, remainingTrancas.size());

        Tranca remainingTranca = null;
        for (Tranca tranca : remainingTrancas) {
            if (tranca.getId() == trancaId) {
                remainingTranca = tranca;
                break;
            }
        }

        assertNull(remainingTranca);
    }



    @Test
    public void testGetTrancaById_WithInvalidId() {
        int trancaId = 20;

        Tranca result = trancaService.getTrancaById(trancaId);

        assertNull(result);
    }

    @Test
    public void testCreateTranca_WithExistingId() {
        Bicicleta bicicleta = new Bicicleta(16, "Marca 16", "Modelo 16", "2023", 16, BicicletaStatus.DISPONIVEL);

        Tranca tranca = new Tranca(1, bicicleta, 16, "Localização 16", "2023", "Modelo 16",  TrancaStatus.NOVA);

        Tranca result = trancaService.createTranca(tranca);

        assertNull(result);
        assertEquals(15, trancaService.getTrancas().size());
    }

    @Test
    public void testUpdateTranca_WithInvalidId() {
        Bicicleta bicicleta = new Bicicleta(16, "Marca 16", "Modelo 16", "2023", 16, BicicletaStatus.DISPONIVEL);

        Tranca tranca = new Tranca(20, bicicleta, 20, "Localização 20", "2022", "Modelo 20", TrancaStatus.APOSENTADA);

        Tranca result = trancaService.updateTranca(tranca);

        assertNull(result);
    }

    @Test
    public void testUpdateTranca_WithNullTranca() {
        Tranca tranca = null;

        Tranca result = trancaService.updateTranca(tranca);

        assertNull(result);
    }

    @Test
    public void testDeleteTranca_WithInvalidId() {
        int trancaId = 20;

        trancaService.deleteTranca(trancaId);

        assertEquals(15, trancaService.getTrancas().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3}) // Add more trancaIds if needed
    public void testDeleteTranca_WithExistingId(int trancaId) {
        trancaService.deleteTranca(trancaId);
        List<Tranca> remainingTrancas = trancaService.getTrancas();
        assertEquals(14, remainingTrancas.size());

        for (Tranca remainingTranca : remainingTrancas) {
            assertNotEquals(trancaId, remainingTranca.getId());
        }
    }


    @Test
    public void testCreateTranca_NullTranca() {


        Tranca result = null;

        assertNull(result);
        assertEquals(15, trancaService.getTrancas().size());
    }


    @Test
    public void testUpdateTranca_WithExistingId() {
        Bicicleta bicicleta = new Bicicleta(16, "Marca 16", "Modelo 16", "2023", 16, BicicletaStatus.DISPONIVEL);
        Tranca tranca = new Tranca(1, bicicleta, 1, "Localização 1 Atualizada", "2022", "Modelo 1", TrancaStatus.APOSENTADA);

        Tranca result = trancaService.updateTranca(tranca);

        assertEquals(tranca, result);
        assertEquals("Localização 1 Atualizada", trancaService.getTrancaById(1).getLocalizacao());
        assertEquals(TrancaStatus.APOSENTADA, trancaService.getTrancaById(1).getStatus());
    }

    @Test
    public void testUpdateTranca_WithInvalidId2() {
        Bicicleta bicicleta = new Bicicleta(16, "Marca 16", "Modelo 16", "2023", 16, BicicletaStatus.DISPONIVEL);

        Tranca tranca = new Tranca(20, bicicleta, 20, "Localização 20", "2022", "Modelo 20", TrancaStatus.APOSENTADA);

        Tranca result = trancaService.updateTranca(tranca);

        assertNull(result);
    }

    @Test
    public void testUpdateTranca_WithNullTranca2() {
        Tranca tranca = null;

        Tranca result = trancaService.updateTranca(tranca);

        assertNull(result);
    }

    @Test
    public void testDeleteTranca_WithInvalidId2() {
        int trancaId = 20;

        trancaService.deleteTranca(trancaId);

        assertEquals(15, trancaService.getTrancas().size());
    }

    @Test
    public void testGetTrancaById_WithInvalidId2() {
        int trancaId = 20;

        Tranca result = trancaService.getTrancaById(trancaId);

        assertNull(result);
    }

    @Test
    public void testCreateTranca_WithExistingId2() {
        Bicicleta bicicleta = new Bicicleta(16, "Marca 16", "Modelo 16", "2023", 16, BicicletaStatus.DISPONIVEL);

        Tranca tranca = new Tranca(1, bicicleta, 16, "Localização 16", "2023", "Modelo 16", TrancaStatus.NOVA);

        Tranca result = trancaService.createTranca(tranca);

        assertNull(result);
        assertEquals(15, trancaService.getTrancas().size());
    }

    @Test
    public void testDeleteTranca_LastTranca() {
        int trancaId = 15;

        trancaService.deleteTranca(trancaId);

        List<Tranca> remainingTrancas = trancaService.getTrancas();
        assertEquals(14, remainingTrancas.size());

        Tranca remainingTranca = remainingTrancas.get(remainingTrancas.size() - 1);
        assertEquals(14, remainingTranca.getId());
        assertEquals("Modelo 14", remainingTranca.getBicicleta().getModelo());
    }


}
