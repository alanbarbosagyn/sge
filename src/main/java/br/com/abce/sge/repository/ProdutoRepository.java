package br.com.abce.sge.repository;

import br.com.abce.sge.entity.Produto;

import java.util.List;

public interface ProdutoRepository {
    

    Produto buscar(final Long idProduto);

    void salvar(final Produto produto);

    void remover(final Produto produto);

    List<Produto> listar();
}
