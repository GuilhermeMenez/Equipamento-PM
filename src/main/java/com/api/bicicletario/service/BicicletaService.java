package com.api.bicicletario.service;

import com.api.bicicletario.enumerator.BicicletaStatus;
import com.api.bicicletario.enumerator.TrancaStatus;
import com.api.bicicletario.model.Bicicleta;
import com.api.bicicletario.model.Reparo;
import com.api.bicicletario.model.Totem;
import com.api.bicicletario.model.Tranca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BicicletaService {
    private List<Bicicleta> bicicletas = new ArrayList<>();
    private int nextId = 1;

    private final TotemService totemService;
    private final TrancaService trancaService ;


    @Autowired
    public BicicletaService(TotemService totemService, TrancaService trancaService) {
        this.totemService = totemService;
        this.trancaService = trancaService;
    }

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



    public boolean integrarNaRede(String idBicicleta, String idTranca, int idFuncionario, int idTotem) {
        Bicicleta bicicleta = obterBicicletaPorId(Integer.parseInt(idBicicleta));
        Tranca tranca = trancaService.getTrancaById(Integer.parseInt(idTranca));

        if (bicicleta == null || tranca == null) {
            return false;
        }

        if (bicicleta.getStatus() != BicicletaStatus.NOVA && bicicleta.getStatus() != BicicletaStatus.EM_REPARO) {
            return false;
        }

        if (tranca.getStatus() != TrancaStatus.LIVRE) {
            return false;
        }

        tranca.setFuncionarioId(idFuncionario);

        Totem totem = totemService.obterTotemPorId(idTotem);

        if (totem == null) {
            return false;
        }

        totemService.incluirTrancaEmTotem(totem, tranca, idFuncionario);

        return true;
    }




    public Totem obterTotemParaInclusaoTranca() {
        for (Totem totem : totemService.listarTotens()) {
            for (Tranca tranca : totem.getTrancas()) {
                if (tranca.getStatus() == TrancaStatus.LIVRE) {
                    return totem;
                }
            }
        }
        return null;
    }
    public void retirarBicicletaParaReparo(Bicicleta bicicleta, Tranca tranca, int idFuncionario, String statusAcaoReparador) {
        if (bicicleta == null || tranca == null) {
            throw new IllegalArgumentException("Bicicleta ou tranca inválida.");
        }

        if (!bicicleta.getStatus().equals(BicicletaStatus.REPARO_SOLICITADO)) {
            throw new IllegalArgumentException("A bicicleta não está com reparo solicitado.");
        }

        if (!tranca.getStatus().equals(TrancaStatus.OCUPADA)) {
            throw new IllegalArgumentException("A tranca não está presa.");
        }

        bicicleta.setStatus(BicicletaStatus.valueOf(statusAcaoReparador));
        tranca.setFuncionarioId(idFuncionario);
    }

}
