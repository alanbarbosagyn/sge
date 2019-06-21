package br.com.abce.sge.resource.impl;

import br.com.abce.sge.dto.ProdutoDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.ProdutoResource;
import br.com.abce.sge.resource.config.RestApplication;
import br.com.abce.sge.servico.ProdutoService;

import javax.ejb.EJB;
import java.util.List;

public class ProdutoResourceImpl extends RestApplication implements ProdutoResource {

    @EJB
    private ProdutoService produtoService;

    @Override
    public List<ProdutoDto> listarProdutos() throws RecursoNaoEncontradoException {

        final List<ProdutoDto> listaProdutoDto = produtoService.listar();

        if (listaProdutoDto.isEmpty())

            throw new RecursoNaoEncontradoException("Produto não cadastrado.");

        return listaProdutoDto;
    }

    @Override
    public List<ProdutoDto> listarProdutos(Long idEstabelecimento) throws RecursoNaoEncontradoException, ValidacaoException {

        final List<ProdutoDto> listaProdutoDto = produtoService.listar(idEstabelecimento);

        if (listaProdutoDto.isEmpty())

            throw new RecursoNaoEncontradoException("Produto não cadastrado.");

        return listaProdutoDto;
    }

    public ProdutoDto getProduto(final Long idProduto) throws ValidacaoException, RecursoNaoEncontradoException {

        final ProdutoDto produtoDto = produtoService.buscar(idProduto);

        if (produtoDto == null)

            throw new RecursoNaoEncontradoException("Produto não cadastrado.");

        return produtoDto;
    }

    @Override
    public void removeProduto(final Long idProduto) throws ValidacaoException, RecursoNaoEncontradoException {

        ProdutoDto produtoDto = produtoService.buscar(idProduto);

        if (produtoDto == null)

            throw new RecursoNaoEncontradoException("Produto não cadastrado.");

        produtoService.remover(produtoDto);

    }

    @Override
    public void inserirProduto(ProdutoDto produtoDto) throws ValidacaoException {

        produtoService.salvar(produtoDto);
    }
}
