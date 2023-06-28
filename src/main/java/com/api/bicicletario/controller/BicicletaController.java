package com.api.bicicletario.controller;

import com.api.bicicletario.model.Bicicleta;
import com.api.bicicletario.model.Tranca;
import com.api.bicicletario.service.BicicletaService;
import com.api.bicicletario.service.TrancaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bicicleta")
public class BicicletaController {
    private final BicicletaService bicicletaService;
    private final TrancaService trancaService;

    public BicicletaController(BicicletaService bicicletaService, TrancaService trancaService) {
        this.bicicletaService = bicicletaService;
        this.trancaService = trancaService;
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


    @PostMapping("/integrarNaRede")
    public ResponseEntity<Void> integrarNaRede(@RequestParam("idBicicleta") String idBicicleta,
                                               @RequestParam("idTranca") String idTranca,
                                               @RequestParam("idFuncionario") int idFuncionario,
                                               @RequestParam("idTotem") int idTotem) {
        boolean integrado = bicicletaService.integrarNaRede(idBicicleta, idTranca, idFuncionario, idTotem);
        if (integrado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }




    @PostMapping("/bicicleta/retirarDaRede")
    public ResponseEntity<String> retirarBicicletaParaReparo(@RequestParam("idBicicleta") int idBicicleta,
                                                             @RequestParam("idTranca") int idTranca,
                                                             @RequestParam("idFuncionario") int idFuncionario,
                                                             @RequestParam("statusAcaoReparador") String statusAcaoReparador) {

        Bicicleta bicicleta = bicicletaService.obterBicicletaPorId(idBicicleta);
        Tranca tranca = trancaService.getTrancaById(idTranca);

        try {
            bicicletaService.retirarBicicletaParaReparo(bicicleta, tranca, idFuncionario, statusAcaoReparador);
            return ResponseEntity.ok("Bicicleta retirada com sucesso para reparo.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
