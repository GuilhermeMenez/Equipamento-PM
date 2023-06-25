package com.api.bicicletario.service;

import com.api.bicicletario.enumerator.BicicletaStatus;
import com.api.bicicletario.model.Bicicleta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BicicletaService {
     private List<Bicicleta> bicicletas = new ArrayList<>();
    private int nextId = 1;

    public List<Bicicleta> listarBicicletas() {
        return bicicletas;
    }

    public Bicicleta obterBicicletaPorId(int id) {
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getId() == id) {
                return bicicleta;
            }
        }
        return null;
    }

    public void adicionarBicicleta(Bicicleta bicicleta) {
        bicicleta.setId(nextId++);
        bicicleta.setStatus(BicicletaStatus.APOSENTADA); // Atualiza o status para "APOSENTADA"
        bicicletas.add(bicicleta);
    }

    public void atualizarBicicleta(Bicicleta bicicleta) {
        for (int i = 0; i < bicicletas.size(); i++) {
            if (bicicletas.get(i).getId() == bicicleta.getId()) {
                bicicletas.set(i, bicicleta);
                break;
            }
        }
    }

    public void removerBicicleta(int id) {
        bicicletas.removeIf(bicicleta -> bicicleta.getId() == id && bicicleta.getStatus() == BicicletaStatus.APOSENTADA);
    }
}
