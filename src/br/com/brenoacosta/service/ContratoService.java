package br.com.brenoacosta.service;

import br.com.brenoacosta.dao.IContratoDao;

public class ContratoService implements IContratoService {
    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar(int id) {
        String contrato = contratoDao.buscar(id);
        if (contrato == null) {
            throw new IllegalArgumentException("Contrato não encontrado");
        }
        return contrato;
    }

    @Override
    public boolean excluir(int id) {
        boolean sucesso = contratoDao.excluir(id);
        if (!sucesso) {
            throw new IllegalArgumentException("Contrato não encontrado para exclusão");
        }
        return sucesso;
    }

    @Override
    public boolean atualizar(int id, String novoContrato) {
        boolean sucesso = contratoDao.atualizar(id, novoContrato);
        if (!sucesso) {
            throw new IllegalArgumentException("Contrato não encontrado para atualização");
        }
        return sucesso;
    }
}
