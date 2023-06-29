package com.api.bicicletario.model;
import com.api.bicicletario.enumerator.BicicletaStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BicicletaTest {
    private Bicicleta bicicleta;

    @Before
    public void setUp() {
        bicicleta = new Bicicleta(1, "Marca", "Modelo", "2023", 123, BicicletaStatus.DISPONIVEL);
    }

    @Test
    public void testGetMarca() {
        String marca = bicicleta.getMarca();
        Assert.assertEquals("Marca", marca);
    }

    @Test
    public void testGetId() {
        int id = bicicleta.getId();
        Assert.assertEquals(1, id);
    }

    @Test
    public void testSetId() {
        bicicleta.setId(2);
        int novoId = bicicleta.getId();
        Assert.assertEquals(2, novoId);
    }
    @Test
    public void testSetModelo() {
        bicicleta.setModelo("Novo Modelo");
        String novoModelo = bicicleta.getModelo();
        Assert.assertEquals("Novo Modelo", novoModelo);
    }
    @Test
    public void testGetStatus() {
        BicicletaStatus status = bicicleta.getStatus();
        Assert.assertEquals(BicicletaStatus.DISPONIVEL, status);
    }
    @Test
    public void testGetModelo() {
        String modelo = bicicleta.getModelo();
        Assert.assertEquals("Modelo", modelo);
    }
    @Test
    public void testSetStatus() {
        bicicleta.setStatus(BicicletaStatus.APOSENTADA);
        BicicletaStatus novoStatus = bicicleta.getStatus();
        Assert.assertEquals(BicicletaStatus.APOSENTADA, novoStatus);
    }
    @Test
    public void testGetAno() {
        String ano = bicicleta.getAno();
        Assert.assertEquals("2023", ano);
    }

    @Test
    public void testSetAno() {
        bicicleta.setAno("2024");
        String novoAno = bicicleta.getAno();
        Assert.assertEquals("2024", novoAno);
    }

    @Test
    public void testGetNumero() {
        int numero = bicicleta.getNumero();
        Assert.assertEquals(123, numero);
    }

    @Test
    public void testSetNumero() {
        bicicleta.setNumero(456);
        int novoNumero = bicicleta.getNumero();
        Assert.assertEquals(456, novoNumero);
    }

    @Test
    public void testSetStatus2() {
        BicicletaStatus novoStatus = BicicletaStatus.REPARO_SOLICITADO;

        bicicleta.setStatus(novoStatus);

        Assert.assertEquals(novoStatus, bicicleta.getStatus());
    }
}
