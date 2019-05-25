package br.com.abce.sge.resource.impl;

import br.com.abce.sge.dto.ProdutoDto;
import br.com.abce.sge.resource.ProdutoResource;
import br.com.abce.sge.resource.config.RestApplication;
import br.com.abce.sge.servico.ProdutoService;

import javax.ejb.EJB;
import java.util.List;

public class ProdutoResourceImpl extends RestApplication implements ProdutoResource {

    @EJB
    private ProdutoService produtoService;

    @Override
    public List<ProdutoDto> listarProdutos() {

        final List<ProdutoDto> listaProdutoDto = produtoService.listar();

        return listaProdutoDto;
    }

    public ProdutoDto getProduto(final String idProduto){

        final ProdutoDto produtoDto = produtoService.buscar(Long.valueOf(idProduto));

        return produtoDto;
    }

    @Override
    public void removeProduto(String idProduto) {

        produtoService.remover(Long.valueOf(idProduto));

    }

    @Override
    public void inserirProduto(ProdutoDto produtoDto) {

        produtoService.cadastrar(produtoDto);
    }
}
