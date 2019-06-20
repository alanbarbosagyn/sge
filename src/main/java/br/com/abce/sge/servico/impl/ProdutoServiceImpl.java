package br.com.abce.sge.servico.impl;

import br.com.abce.sge.dto.ProdutoDto;
import br.com.abce.sge.entity.ProdutoEntity;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.repository.ProdutoRepository;
import br.com.abce.sge.servico.ProdutoService;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class ProdutoServiceImpl implements ProdutoService {

    @EJB
    private ProdutoRepository produtoRepository;

    @Override
    public List<ProdutoDto> listar() {

        List<ProdutoDto> listaDto = new ArrayList<>();

        final List<ProdutoEntity> lista = produtoRepository.listar();

        for (ProdutoEntity produto : lista) {

            ProdutoDto produtoDto = new ProdutoDto();
            produtoDto.setDescricao(produto.getDetalhe());
            produtoDto.setId(produto.getId());
            produtoDto.setNome(produto.getNome());
            produtoDto.setValor(produto.getValor());

            listaDto.add(produtoDto);
        }

        return listaDto;
    }

    @Override
    public ProdutoDto buscar(Long idProduto) throws ValidacaoException {

        if (idProduto == null || idProduto == 0L)

            throw new ValidacaoException("Id do Produto não informado.");

        ProdutoDto produtoDto = null;

        ProdutoEntity produto = produtoRepository.buscar(idProduto);

        if (produto != null) {

            produtoDto = new ProdutoDto();
            produtoDto.setDescricao(produto.getDetalhe());
            produtoDto.setId(produto.getId());
            produtoDto.setNome(produto.getNome());
            produtoDto.setValor(produto.getValor());
        }

        return produtoDto;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void cadastrar(ProdutoDto produtoDto) throws ValidacaoException {



        if (StringUtils.isBlank(produtoDto.getDescricao()))
            throw new ValidacaoException("Descrição do produto obrigatório.");

        if (StringUtils.isBlank(produtoDto.getNome()))
            throw new ValidacaoException("Nome do produto obrigatório.");

        if (produtoDto.getValor() == null || produtoDto.getValor().intValue() == 0)
            throw new ValidacaoException("Valor do produto obrigatório.");


        ProdutoEntity produto = new ProdutoEntity();
        produto.setDetalhe(produtoDto.getDescricao());
        produto.setId(produtoDto.getId());
        produto.setNome(produtoDto.getNome());
        produto.setValor(produtoDto.getValor());

        produtoRepository.salvar(produto);

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(ProdutoDto produtoDto) throws ValidacaoException {

        if (produtoDto == null)
            throw new ValidacaoException("Produto não informado.");

        produtoRepository.remover(produtoDto.getId());

    }
}
