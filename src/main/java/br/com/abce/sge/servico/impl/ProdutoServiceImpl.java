package br.com.abce.sge.servico.impl;

import br.com.abce.sge.dto.ProdutoDto;
import br.com.abce.sge.entity.ProdutoEntity;
import br.com.abce.sge.repository.ProdutoRepository;
import br.com.abce.sge.servico.ProdutoService;
import com.sun.jersey.api.NotFoundException;

import javax.ejb.*;
import java.math.BigDecimal;
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
    public ProdutoDto buscar(Long idProduto) {

        ProdutoEntity produto = produtoRepository.buscar(idProduto);

        if (produto == null)

            throw new NotFoundException("Produto não cadastrado.");

        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setDescricao(produto.getDetalhe());
        produtoDto.setId(produto.getId());
        produtoDto.setNome(produto.getNome());
        produtoDto.setValor(produto.getValor());

        return produtoDto;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void cadastrar(ProdutoDto produtoDto) {


        ProdutoEntity produto = new ProdutoEntity();
        produto.setDetalhe(produtoDto.getDescricao());
        produto.setId(produtoDto.getId());
        produto.setNome(produtoDto.getNome());
        produto.setValor(produtoDto.getValor());

        produtoRepository.salvar(produto);

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(Long idProduto) {

        ProdutoEntity produto = produtoRepository.buscar(idProduto);

        if (produto == null)

            throw new NotFoundException("Produto não cadastrado.");

        produtoRepository.remover(produto);

    }
}
