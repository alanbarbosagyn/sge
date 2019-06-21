package br.com.abce.sge.repository;

import br.com.abce.sge.entity.ProdutoEntity;

import java.util.List;

public interface ProdutoRepository {

    ProdutoEntity buscar(final Long idProduto);

    void salvar(final ProdutoEntity produto);

    void remover(final Long idProduto);

    List<ProdutoEntity> listar();

    List<ProdutoEntity> listar(final Long idEstabelecimento);
}
