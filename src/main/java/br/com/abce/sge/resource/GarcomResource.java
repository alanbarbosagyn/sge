package br.com.abce.sge.resource;

import br.com.abce.sge.dto.GarcomDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.config.HTTPCodeRestDefinition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/garcom")
@Produces(value = MediaType.APPLICATION_JSON)
@Api(value = "/v1/garcom", produces = MediaType.APPLICATION_JSON,
        tags = "Serviços de Consulta e Operação de Garçom")
public interface GarcomResource extends HTTPCodeRestDefinition {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Consulta de garçom", tags = "Consulta de garçom pelo seu ID.")
    GarcomDto getGarcom(@PathParam("id") @ApiParam(value = "O id do garçom.") final Long idGarcom)
            throws ValidacaoException, RecursoNaoEncontradoException;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Consulta de garçons por estabelecimento", tags = "Consulta de garçom por ID do estabelecimento.")
    List<GarcomDto> getGarcomPorEstabelecimento(@QueryParam("id_estabelecimento")
                                                @ApiParam(value = "Id do estabelecimento") final Long idEstabelecimento)
            throws ValidacaoException, RecursoNaoEncontradoException;
}
