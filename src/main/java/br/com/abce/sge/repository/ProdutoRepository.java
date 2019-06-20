package br.com.abce.sge.repository;

import br.com.abce.sge.entity.ProdutoEntity;

import java.util.List;

public interface ProdutoRepository {
    

    ProdutoEntity buscar(final Long idProduto);

    void salvar(final ProdutoEntity produto);

    void remover(final ProdutoEntity produto);

    List<ProdutoEntity> listar();
}
