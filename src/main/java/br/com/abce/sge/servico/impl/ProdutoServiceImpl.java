package br.com.abce.sge.servico.impl;

import br.com.abce.sge.dto.ProdutoDto;
import br.com.abce.sge.entity.EstabelecimentoEntity;
import br.com.abce.sge.entity.ProdutoEntity;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.repository.EstabelecimentoRepository;
import br.com.abce.sge.repository.ProdutoRepository;
import br.com.abce.sge.servico.ProdutoService;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class ProdutoServiceImpl implements ProdutoService {

    public static final int SIT_PRODUTO_ATIVO = 1;
    @EJB
    private ProdutoRepository produtoRepository;

    @EJB
    private EstabelecimentoRepository estabelecimentoRepository;

    @Override
    public List<ProdutoDto> listar(final Long idEstabelecimento) throws ValidacaoException {

        if (idEstabelecimento == null || idEstabelecimento == 0L)

            throw new ValidacaoException("Id do estabelecimento não informado.");

        final List<ProdutoEntity> lista = produtoRepository.listar(idEstabelecimento);

        final List<ProdutoDto> listaDto = getListaProdutoDto(lista);

        return listaDto;
    }

    @Override
    public List<ProdutoDto> listar() {

        final List<ProdutoEntity> lista = produtoRepository.listar();

        final List<ProdutoDto> listaDto  = getListaProdutoDto(lista);

        return listaDto;
    }

    @Override
    public ProdutoDto buscar(final Long idProduto) throws ValidacaoException {

        if (idProduto == null || idProduto == 0L)

            throw new ValidacaoException("Id do Produto não informado.");

        ProdutoDto produtoDto = null;

        ProdutoEntity produto = produtoRepository.buscar(idProduto);

        if (produto != null) {

            produtoDto = new ProdutoDto();
            produtoDto.setDescricao(produto.getDescricao());
            produtoDto.setId(produto.getId());
            produtoDto.setNome(produto.getNome());
            produtoDto.setValor(produto.getValor());
        }

        return produtoDto;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(final ProdutoDto produtoDto) throws ValidacaoException {

        if (StringUtils.isBlank(produtoDto.getDescricao()))
            throw new ValidacaoException("Descrição do produto não informado.");

        if (StringUtils.isBlank(produtoDto.getNome()))
            throw new ValidacaoException("Nome do produto não informado.");

        if (produtoDto.getValor() == null || produtoDto.getValor().intValue() == 0)
            throw new ValidacaoException("Valor do produto não informado.");

        if (produtoDto.getIdEstabelecimento() == null
                || produtoDto.getIdEstabelecimento() == 0L)
            throw new ValidacaoException("Id do estabelecimento não informado.");

        final EstabelecimentoEntity estabelecimento = estabelecimentoRepository
                .buscar(produtoDto.getIdEstabelecimento());

        if (estabelecimento == null)
            throw new ValidacaoException("Estabelecimento não encontrado.");

        ProdutoEntity produto = new ProdutoEntity();
        produto.setDescricao(produtoDto.getDescricao());
        produto.setId(produtoDto.getId());
        produto.setNome(produtoDto.getNome());
        produto.setValor(produtoDto.getValor());
        produto.setDescricao(produto.getDescricao());
        produto.setSituacao(SIT_PRODUTO_ATIVO);
        produto.setEstabelecimentoByEstabelecimentoId(estabelecimento);

        produtoRepository.salvar(produto);

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(final ProdutoDto produtoDto) throws ValidacaoException {

        if (produtoDto == null)
            throw new ValidacaoException("Produto não informado.");

        produtoRepository.remover(produtoDto.getId());

    }

    private List<ProdutoDto> getListaProdutoDto(final List<ProdutoEntity> lista) {

        List<ProdutoDto> listaDto = new ArrayList<>();

        for (ProdutoEntity produto : lista) {

            ProdutoDto produtoDto = new ProdutoDto();
            produtoDto.setDescricao(produto.getDescricao());
            produtoDto.setId(produto.getId());
            produtoDto.setNome(produto.getNome());
            produtoDto.setValor(produto.getValor());
            produtoDto.setIdEstabelecimento(produto.getEstabelecimentoByEstabelecimentoId().getId());

            listaDto.add(produtoDto);
        }

        return listaDto;
    }
}
