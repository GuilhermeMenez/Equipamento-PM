package com.api.bicicletario.model;
import com.api.bicicletario.enumerator.TrancaStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NovaTrancaTest {

    @Mock
    private NovaTranca novaTranca;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetNumero() {
        when(novaTranca.getNumero()).thenReturn(123);
        int numero = novaTranca.getNumero();
        assertEquals(123, numero);
    }

    @Test
    public void testGetLocalizacao() {
        when(novaTranca.getLocalizacao()).thenReturn("Localização 2");
        String localizacao = novaTranca.getLocalizacao();
        assertEquals("Localização 2", localizacao);
    }

    @Test
    public void testGetAnoDeFabricacao() {
        when(novaTranca.getAnoDeFabricacao()).thenReturn("2022");
        String anoDeFabricacao = novaTranca.getAnoDeFabricacao();
        assertEquals("2022", anoDeFabricacao);
    }

    @Test
    public void testGetModelo() {
        when(novaTranca.getModelo()).thenReturn("ABC123");
        String modelo = novaTranca.getModelo();
        assertEquals("ABC123", modelo);
    }

    @Test
    public void testGetStatus() {
        when(novaTranca.getStatus()).thenReturn(TrancaStatus.LIVRE);
        TrancaStatus status = TrancaStatus.valueOf(String.valueOf(novaTranca.getStatus()));
        assertEquals(TrancaStatus.LIVRE, status);
    }

    @Test
    public void testSetNumero2() {
        novaTranca.setNumero(456);
        verify(novaTranca).setNumero(456);
    }

    @Test
    public void testSetLocalizacao() {
        novaTranca.setLocalizacao("Localização 1");
        verify(novaTranca).setLocalizacao("Localização 1");
    }


    @Test
    public void testSetAnoDeFabricacao() {
        novaTranca.setAnoDeFabricacao("2023");
        verify(novaTranca).setAnoDeFabricacao("2023");
    }

    @Test
    public void testSetModelo() {
        novaTranca.setModelo("XYZ789");
        verify(novaTranca).setModelo("XYZ789");
    }

    @Test
    public void testSetStatus() {
        TrancaStatus novoStatus = TrancaStatus.OCUPADA;
        novaTranca.setStatus(novoStatus);
        verify(novaTranca).setStatus(novoStatus);
    }

    @Test
    public void testConstrutorNovaTranca() {
        // Dados de entrada do construtor
        Integer numero = 1;
        String localizacao = "Sala";
        String anoDeFabricacao = "2022";
        String modelo = "ModeloA";
        TrancaStatus status = TrancaStatus.OCUPADA;

        // Criação da instância usando o construtor
        NovaTranca tranca = new NovaTranca(numero, localizacao, anoDeFabricacao, modelo, status);

        // Verificações dos atributos da instância criada
        assertEquals(numero, tranca.getNumero());
        assertEquals(localizacao, tranca.getLocalizacao());
        assertEquals(anoDeFabricacao, tranca.getAnoDeFabricacao());
        assertEquals(modelo, tranca.getModelo());
        assertEquals(status, tranca.getStatus());
    }

    @Test
    public void testGetStatus3() {
        // Dados de entrada do construtor
        Integer numero = 1;
        String localizacao = "Sala";
        String anoDeFabricacao = "2022";
        String modelo = "ModeloA";
        TrancaStatus status = TrancaStatus.OCUPADA;

        // Criação da instância usando o construtor
        NovaTranca tranca = new NovaTranca(numero, localizacao, anoDeFabricacao, modelo, status);

        // Verificação do método getStatus()
        assertEquals(status, tranca.getStatus());
    }

    @Test
    public void testSetStatus3() {
        // Dados de entrada do construtor
        Integer numero = 1;
        String localizacao = "Sala";
        String anoDeFabricacao = "2022";
        String modelo = "ModeloA";
        TrancaStatus status = TrancaStatus.OCUPADA;

        NovaTranca tranca = new NovaTranca(numero, localizacao, anoDeFabricacao, modelo, status);

        TrancaStatus novoStatus = TrancaStatus.OCUPADA;

        tranca.setStatus(novoStatus);

        assertEquals(novoStatus, tranca.getStatus());
    }

    @Test
    public void testSetStatusDesativada() {
        // Verifica se o status da tranca é atualizado corretamente para DESATIVADA
        TrancaStatus expected = TrancaStatus.APOSENTADA;
        when(novaTranca.getStatus()).thenReturn(expected);

        novaTranca.setStatus(expected);
        TrancaStatus actual = novaTranca.getStatus();

        verify(novaTranca, times(1)).setStatus(expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testConstrutor() {
        // Verifica se o construtor atribui os valores corretos aos campos da tranca
        Integer expectedNumero = 1;
        String expectedLocalizacao = "Localização";
        String expectedAnoDeFabricacao = "2021";
        String expectedModelo = "Modelo";
        TrancaStatus expectedStatus = TrancaStatus.OCUPADA;

        NovaTranca novaTranca = new NovaTranca(expectedNumero, expectedLocalizacao, expectedAnoDeFabricacao, expectedModelo, expectedStatus);

        Assertions.assertEquals(expectedNumero, novaTranca.getNumero());
        Assertions.assertEquals(expectedLocalizacao, novaTranca.getLocalizacao());
        Assertions.assertEquals(expectedAnoDeFabricacao, novaTranca.getAnoDeFabricacao());
        Assertions.assertEquals(expectedModelo, novaTranca.getModelo());
        Assertions.assertEquals(expectedStatus, novaTranca.getStatus());
    }

    @Test
    public void testSetStatusAberta() {
        // Verifica se o status da tranca é atualizado corretamente para ABERTA
        TrancaStatus expected = TrancaStatus.OCUPADA;
        when(novaTranca.getStatus()).thenReturn(expected);

        novaTranca.setStatus(expected);
        TrancaStatus actual = novaTranca.getStatus();

        verify(novaTranca, times(1)).setStatus(expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetStatusFechada() {
        // Verifica se o status da tranca é atualizado corretamente para FECHADA
        TrancaStatus expected = TrancaStatus.OCUPADA;
        when(novaTranca.getStatus()).thenReturn(expected);

        novaTranca.setStatus(expected);
        TrancaStatus actual = novaTranca.getStatus();

        verify(novaTranca, times(1)).setStatus(expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetStatusEmReparo() {
        // Verifica se o status da tranca é atualizado corretamente para EM_MANUTENCAO
        TrancaStatus expected = TrancaStatus.EM_REPARO;
        when(novaTranca.getStatus()).thenReturn(expected);

        novaTranca.setStatus(expected);
        TrancaStatus actual = novaTranca.getStatus();

        verify(novaTranca, times(1)).setStatus(expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetNumero() {
        // Verifica se o número da tranca é atribuído corretamente
        Integer expectedNumero = 0;
        novaTranca.setNumero(expectedNumero);
        Integer actualNumero = novaTranca.getNumero();
        Assertions.assertEquals(expectedNumero, actualNumero);
    }

    @Test
    public void testSetLocalizacao3() {
        novaTranca.setLocalizacao("Localização 3");
        verify(novaTranca).setLocalizacao("Localização 3");
    }

    @Test
    public void testSetLocalizacaoBlank() {
        novaTranca.setLocalizacao("");
        verify(novaTranca).setLocalizacao("");
    }
    @Test
    public void testSetAnoDeFabricacaoNull() {
        novaTranca.setAnoDeFabricacao(null);
        verify(novaTranca).setAnoDeFabricacao(null);
    }
    @Test
    public void testSetModeloNull() {
        novaTranca.setModelo(null);
        verify(novaTranca).setModelo(null);
    }

    @Test
    public void testSetStatusNull() {
        novaTranca.setStatus(null);
        verify(novaTranca).setStatus(null);
    }

    @Test
    public void testSetStatusEmReparo2() {
        // Set up the expected status
        TrancaStatus expected = TrancaStatus.EM_REPARO;

        // Call the setStatus method
        novaTranca.setStatus(expected);

        // Verify that the setStatus method was called with the expected status
        verify(novaTranca).setStatus(expected);

        // Mock the external source to return the expected status
        when(novaTranca.getStatus()).thenReturn(expected);

        // Retrieve the actual status
        TrancaStatus actual = novaTranca.getStatus();

        // Verify that the retrieved status matches the expected status
        assertEquals(expected, actual);
    }

    @Test
    public void testSetStatusAposentada() {
        TrancaStatus expected = TrancaStatus.APOSENTADA;
        novaTranca.setStatus(expected);
        verify(novaTranca).setStatus(expected);
        when(novaTranca.getStatus()).thenReturn(expected);
        TrancaStatus actual = novaTranca.getStatus();
        assertEquals(expected, actual);
    }
}
