package br.com.brenoacosta;

import br.com.brenoacosta.dao.ContratoDao;
import br.com.brenoacosta.dao.IContratoDao;
import br.com.brenoacosta.dao.mocks.ContratoDaoMock;
import br.com.brenoacosta.service.ContratoService;
import br.com.brenoacosta.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        service.salvar();
    }

    @Test
    public void buscarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String contrato = service.buscar(1);
        Assert.assertEquals("Contrato 1", contrato); // Esperado: "Contrato 1"
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscarContratoNaoEncontradoTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        service.buscar(99); // Esperado: Lançamento de IllegalArgumentException
    }

    @Test
    public void excluirTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        boolean sucesso = service.excluir(1);
        Assert.assertTrue(sucesso); // Esperado: sucesso = true
    }

    @Test(expected = IllegalArgumentException.class)
    public void excluirContratoNaoExistenteTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        service.excluir(99); // Esperado: Lançamento de IllegalArgumentException
    }

    @Test
    public void atualizarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        boolean sucesso = service.atualizar(1, "Novo contrato");
        Assert.assertTrue(sucesso); // Esperado: sucesso = true
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizarContratoNaoExistenteTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        service.atualizar(99, "Novo contrato"); // Esperado: Lançamento de IllegalArgumentException
    }
}
