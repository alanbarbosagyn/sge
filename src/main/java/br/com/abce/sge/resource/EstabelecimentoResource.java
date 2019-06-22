package br.com.abce.sge.resource;

import br.com.abce.sge.dto.EstabelecimentoDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.config.HTTPCodeRestDefinition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/estabelecimento")
@Produces(value = MediaType.APPLICATION_JSON)
@Api(value = "/v1/estabelecimento", produces = MediaType.APPLICATION_JSON,
        tags = "Serviços de Consulta e Operação de Estabelecimento")
public interface EstabelecimentoResource extends HTTPCodeRestDefinition {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Consulta de estabelecimento", tags = "Consulta de estabelecimento pelo seu ID.")
    EstabelecimentoDto getEstabelecimento(@PathParam("id") @ApiParam(value = "O id do estabelecimento.") final Long idEstabelecimento) throws ValidacaoException, RecursoNaoEncontradoException;
}
