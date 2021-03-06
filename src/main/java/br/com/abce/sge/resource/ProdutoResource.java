package br.com.abce.sge.resource;

import br.com.abce.sge.dto.ProdutoDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.config.HTTPCodeRestDefinition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/produto")
@Produces(value = MediaType.APPLICATION_JSON)
@Api(value = "/v1/produto", produces = MediaType.APPLICATION_JSON,
        tags = "Serviços de Consulta e Operação de Produtos")
public interface ProdutoResource extends HTTPCodeRestDefinition {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Listar produtos", tags = "Listar produtos cadastrados.")
    List<ProdutoDto> listarProdutos() throws RecursoNaoEncontradoException;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Listar produtos do estabelecimento", tags = "Listar produtos cadastrados no estabelecimento.")
    List<ProdutoDto> listarProdutos(@QueryParam("idEstabelecimento") final Long idEstabelecimento) throws RecursoNaoEncontradoException, ValidacaoException;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Consulta de produto", tags = "Consulta de produto pelo seu ID.")
    ProdutoDto getProduto(@PathParam("id") @ApiParam(value = "O código de identificação do produto.") final Long idProduto) throws ValidacaoException, RecursoNaoEncontradoException;

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Remover o produto", tags = "Remover o produto pelo seu ID.")
    void removeProduto(@PathParam("id") @ApiParam(value = "O código de identificação do produto.") final Long idProduto) throws ValidacaoException, RecursoNaoEncontradoException;

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Cadastrar novo produto", tags = "Cadastrar novo produto.")
    void inserirProduto(@BeanParam @ApiParam(value = "Os dados do produto.") final ProdutoDto produtoDto) throws ValidacaoException;

}
