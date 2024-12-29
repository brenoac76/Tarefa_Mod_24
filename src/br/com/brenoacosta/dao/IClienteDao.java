package br.com.brenoacosta.dao;

public interface IClienteDao {

    public String salvar();

    String buscar(int id); // Buscar cliente por ID
    boolean excluir(int id); // Excluir cliente por ID
    boolean atualizar(int id, String novoCliente); // Atualizar cliente por ID
}

