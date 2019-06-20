package br.com.abce.sge.servico;

import br.com.abce.sge.dto.ProdutoDto;
import br.com.abce.sge.exceptions.ValidacaoException;

import java.util.List;

public interface ProdutoService {

    ProdutoDto buscar( final Long idProduto) throws ValidacaoException;

    void cadastrar(final ProdutoDto produto) throws ValidacaoException;

    void remover( final ProdutoDto produtoDto) throws ValidacaoException;

    List<ProdutoDto> listar();
}
