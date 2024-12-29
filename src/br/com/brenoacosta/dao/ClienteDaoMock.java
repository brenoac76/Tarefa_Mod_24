package br.com.brenoacosta.dao;

import java.util.HashMap;
import java.util.Map;

public class ClienteDaoMock implements IClienteDao {

    private Map<Integer, String> clientes = new HashMap<>();

    public ClienteDaoMock() {
        // Dados fictícios para simulação
        clientes.put(1, "Cliente Mock 1");
        clientes.put(2, "Cliente Mock 2");
    }

    @Override
    public String salvar() {
        return null; // Não implementa a lógica de salvar no mock
    }

    @Override
    public String buscar(int id) {
        return clientes.get(id); // Retorna o nome do cliente ou null se não encontrado
    }

    @Override
    public boolean excluir(int id) {
        return clientes.remove(id) != null; // Retorna true se o cliente foi removido
    }

    @Override
    public boolean atualizar(int id, String novoCliente) {
        if (clientes.containsKey(id)) {
            clientes.put(id, novoCliente); // Atualiza o cliente se ele existir
            return true;
        }
        return false; // Retorna false se o cliente não existir
    }
}
