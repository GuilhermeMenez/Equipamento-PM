package com.api.bicicletario.controller;

import com.api.bicicletario.model.Bicicleta;
import com.api.bicicletario.service.BicicletaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bicicleta")
public class BicicletaController {
    private final BicicletaService bicicletaService;

    public BicicletaController(BicicletaService bicicletaService) {
        this.bicicletaService = bicicletaService;
    }

    @GetMapping
    public List<Bicicleta> listarBicicletas() {
        return bicicletaService.listarBicicletas();
    }

    @GetMapping("/{id}")
    public Bicicleta obterBicicletaPorId(@PathVariable int id) {
        return bicicletaService.obterBicicletaPorId(id);
    }

    @PostMapping
    public void adicionarBicicleta(@RequestBody Bicicleta bicicleta) {
        bicicletaService.adicionarBicicleta(bicicleta);
    }

    @PutMapping("/{id}")
    public void atualizarBicicleta(@PathVariable int id, @RequestBody Bicicleta bicicleta) {
        bicicleta.setId(id);
        bicicletaService.atualizarBicicleta(bicicleta);
    }

    @DeleteMapping("/{id}")
    public void removerBicicleta(@PathVariable int id) {
        bicicletaService.removerBicicleta(id);
    }
}
