package com.api.bicicletario.controller;
import com.api.bicicletario.enumerator.TrancaStatus;
import com.api.bicicletario.model.RetirarTranca;
import com.api.bicicletario.model.Tranca;
import com.api.bicicletario.service.TrancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tranca")
public class TrancaController {
    //private final TrancaService trancaService;
    @Autowired
    private TrancaService trancaService;
    public TrancaController(TrancaService trancaService) {
        this.trancaService = trancaService;
    }

    @GetMapping
    public List<Tranca> getTrancas() {
        return trancaService.getTrancas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tranca> getTrancaById(@PathVariable Long id) {
        Tranca tranca = trancaService.getTrancaById(Math.toIntExact(id));
        if (tranca != null) {
            return ResponseEntity.ok(tranca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Tranca> createTranca(@RequestBody Tranca tranca) {
        Tranca createdTranca = trancaService.createTranca(tranca);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTranca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tranca> updateTranca(@PathVariable Long id, @RequestBody Tranca tranca) {
        tranca.setId(Math.toIntExact(id));
        Tranca updatedTranca = trancaService.updateTranca(tranca);
        if (updatedTranca != null) {
            return ResponseEntity.ok(updatedTranca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranca(@PathVariable Long id) {
        trancaService.deleteTranca(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/retirarDaRede")
    public ResponseEntity<String> retirarTrancaDaRede(@RequestBody RetirarTranca request) {
        Tranca tranca = getTrancaById(request.getIdTranca()).getBody();

        if (tranca == null) {
            return ResponseEntity.badRequest().body("ID de tranca inválido.");
        }

        if (tranca.getStatus() != TrancaStatus.EM_REPARO) {
            return ResponseEntity.badRequest().body("A tranca não está com o status 'em reparo'.");
        }

        if (request.getStatusacaoReparador().equals("reparo")) {
            tranca.setStatus(TrancaStatus.OCUPADA);
        } else if (request.getStatusacaoReparador().equals("aposentadoria")) {
            tranca.setStatus(TrancaStatus.APOSENTADA);
        } else {
            return ResponseEntity.badRequest().body("Opção inválida.");
        }

        trancaService.updateTranca(tranca);

        return ResponseEntity.ok("Tranca retirada com sucesso da rede.");
    }


}
