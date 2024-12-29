package br.com.brenoacosta.dao;

public interface IContratoDao {
    void salvar();

    String buscar(int id); // Buscar contrato por ID
    boolean excluir(int id); // Excluir contrato por ID
    boolean atualizar(int id, String novoContrato); // Atualizar contrato por ID


    //TODO
    //Fazer métodos de buscar, excluir e atualizar
}
