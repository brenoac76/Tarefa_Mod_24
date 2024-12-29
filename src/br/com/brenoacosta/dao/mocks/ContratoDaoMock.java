package br.com.brenoacosta.dao.mocks;

import br.com.brenoacosta.dao.IContratoDao;
import java.util.HashMap;
import java.util.Map;

public class ContratoDaoMock implements IContratoDao {

    private Map<Integer, String> contratos = new HashMap<>();

    public ContratoDaoMock() {
        // Dados fictícios para simulação
        contratos.put(1, "Contrato 1");
        contratos.put(2, "Contrato 2");
    }

    @Override
    public void salvar() {
        // Simulação para salvar, mas não faz nada no mock
    }

    @Override
    public String buscar(int id) {
        return contratos.get(id); // Retorna o contrato ou null se não encontrado
    }

    @Override
    public boolean excluir(int id) {
        return contratos.remove(id) != null; // Retorna true se o contrato foi removido
    }

    @Override
    public boolean atualizar(int id, String novoContrato) {
        if (contratos.containsKey(id)) {
            contratos.put(id, novoContrato); // Atualiza o contrato se ele existir
            return true;
        }
        return false; // Retorna false se o contrato não existir
    }
}

