package br.com.abce.sge.servico.impl;

import br.com.abce.sge.dto.ProdutoDto;
import br.com.abce.sge.entity.Produto;
import br.com.abce.sge.repository.ProdutoRepository;
import br.com.abce.sge.servico.ProdutoService;
import com.sun.jersey.api.NotFoundException;

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

        final List<Produto> lista = produtoRepository.listar();

        for (Produto produto : lista) {

            ProdutoDto produtoDto = new ProdutoDto(produto);

            listaDto.add(produtoDto);
        }

        return listaDto;
    }

    @Override
    public ProdutoDto buscar(Long idProduto) {

        Produto produto = produtoRepository.buscar(idProduto);

        if (produto == null)

            throw new NotFoundException("Produto não cadastrado.");

        ProdutoDto produtoDto = new ProdutoDto(produto);

        return produtoDto;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void cadastrar(ProdutoDto produtoDto) {


        Produto produto = new Produto();
        produto.setDescricao(produtoDto.getDescricao());
        produto.setId(produtoDto.getId());
        produto.setNome(produtoDto.getNome());

        produtoRepository.salvar(produto);

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(Long idProduto) {

        Produto produto = produtoRepository.buscar(idProduto);

        if (produto == null)

            throw new NotFoundException("Produto não cadastrado.");

        produtoRepository.remover(produto);

    }
}
