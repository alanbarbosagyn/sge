package br.com.abce.sge.servico;

import br.com.abce.sge.dto.ProdutoDto;

import java.util.List;

public interface ProdutoService {

    ProdutoDto buscar( final Long idProduto);

    void cadastrar(final ProdutoDto produto);

    void remover( final Long idProduto);

    List<ProdutoDto> listar();
}
