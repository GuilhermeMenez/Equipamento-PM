package com.api.bicicletario.service;

import com.api.bicicletario.enumerator.TrancaStatus;
import com.api.bicicletario.model.Totem;
import com.api.bicicletario.model.Tranca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TotemService {
    private final Map<Integer, Totem> totens;
    private final Map<Integer, Tranca> trancas;
     @Autowired
    public TotemService() {
        this.totens = new HashMap<>();
        this.trancas = new HashMap<>();

     }

    public Totem criarTotem(Totem totem) {
        int novoId = gerarNovoId();
        totem.setId(novoId);
        totens.put(novoId, totem);
        return totem;
    }

    public Totem obterTotemPorId(int id) {
        return totens.get(id);
    }

    public Totem atualizarTotem(int id, Totem totemAtualizado) {
        Totem totemExistente = totens.get(id);
        if (totemExistente != null) {
            totemAtualizado.setId(id);
            totens.put(id, totemAtualizado);
            return totemAtualizado;
        } else {
            return null;
        }
    }

    public boolean deletarTotem(int id) {
        Totem totemExistente = totens.get(id);
        if (totemExistente != null) {
            totens.remove(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Totem> listarTotens() {
        return new ArrayList<>(totens.values());
    }

    private int gerarNovoId() {
        return totens.keySet().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0) + 1;
    }


    public void incluirTrancaEmTotem(Totem totem, Tranca tranca, int funcionarioId) {
        if (tranca == null) {
            throw new IllegalArgumentException("Número da tranca inválido. Tranca não cadastrada no sistema.");
        }

        if (!tranca.getStatus().equals(TrancaStatus.EM_REPARO) && !tranca.getStatus().equals(TrancaStatus.NOVA)) {
            throw new IllegalArgumentException("A tranca não pode ser incluída. Status inválido: " + tranca.getStatus());

        }

        if (tranca.getStatus().equals(TrancaStatus.EM_REPARO) && tranca.getFuncionarioId() != funcionarioId) {
            throw new IllegalArgumentException("Funcionário inválido. A tranca está sendo devolvida por um funcionário diferente.");
        }

        totem.getTrancas().add(tranca);

        tranca.setStatus(TrancaStatus.LIVRE);
    }
    public Tranca getTrancaById(int id) {
        return trancas.get(id);
    }



}


