package com.api.bicicletario.controller;

import com.api.bicicletario.model.Totem;
import com.api.bicicletario.service.TotemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/toten")
public class TotemController {
    private final TotemService totemService;

    @Autowired
    public TotemController(TotemService totemService) {
        this.totemService = totemService;
    }

    @PostMapping
    public ResponseEntity<Totem> criarTotem(@RequestBody Totem totem) {
        Totem novoTotem = totemService.criarTotem(totem);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTotem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Totem> obterTotemPorId(@PathVariable int id) {
        Totem totem = totemService.obterTotemPorId(id);
        if (totem != null) {
            return ResponseEntity.ok(totem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Totem> atualizarTotem(@PathVariable int id, @RequestBody Totem totem) {
        Totem totemAtualizado = totemService.atualizarTotem(id, totem);
        if (totemAtualizado != null) {
            return ResponseEntity.ok(totemAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTotem(@PathVariable int id) {
        boolean deletado = totemService.deletarTotem(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Totem>> listarTotens() {
        List<Totem> totens = totemService.listarTotens();
        return ResponseEntity.ok(totens);
    }
}
