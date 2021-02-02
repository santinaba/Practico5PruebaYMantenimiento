package com.com470.boleto.app.controller;



import com.com470.boleto.app.entities.Boleto;
import com.com470.boleto.app.service.BoletoService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.hamcrest.Matchers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BoletoControllerTest {

    private Boleto boleto;
    private BoletoService service;

    @Before
    public void setUp() {
        boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Pipo");
        boleto.setEmail("pipo@gmail.com");

        service = mock(BoletoService.class);
    }

    @Test
    public void testCreateBoleto() {
        when(service.createBoleto(boleto)).thenReturn(boleto);
        assertThat(service.createBoleto(boleto), Matchers.isA(Boleto.class));
    }

    @Test
    public void testGetBoletoById() {
        when(service.getBoletoById(1)).thenReturn(boleto);
        assertEquals(boleto, service.getBoletoById(1));
    }

    @Test
    public void testGetAllBoletos() {
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(boleto);
        boletos.add(boleto);

        when(service.getAllBoletos()).thenReturn(boletos);
        assertEquals(boletos, service.getAllBoletos());
    }

    @Test
    public void testUpdateBoleto() {
        Boleto boletoEsperado = new Boleto();
        boletoEsperado.setBoletoId(1);
        boletoEsperado.setNombreDelPasajero("Pipo");
        boletoEsperado.setEmail("pipo@outlook.com");

        String email = "pipo@outlook.com";

        when(service.updateBoleto(1, email)).thenReturn(boletoEsperado);
        assertThat(service.updateBoleto(1, email), Matchers.equalTo(boletoEsperado));
    }
}
