package br.com.abce.sge.resource;

import br.com.abce.sge.dto.MesaDto;
import br.com.abce.sge.dto.MotivoAvaliacaoDto;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.config.HTTPCodeRestDefinition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by alan-bs on jul, 2019
 */

@Path("/v1/motivo-avaliacao")
@Produces(value = MediaType.APPLICATION_JSON)
@Api(value = "/v1/motivo-avaliacao", produces = MediaType.APPLICATION_JSON,
        tags = "Serviços de Consulta e Operação de Motivos de Avaliação")
public interface MotivoAvaliacaoResource extends HTTPCodeRestDefinition {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Listar motivos de avaliação", tags = "Listar os Motivos de Avaliação cadastrados.")
    List<MotivoAvaliacaoDto> listarMotivosAvaliacao() throws RecursoNaoEncontradoException;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Consulta de motivo de avaliação", tags = "Consulta o Motivo de Avaliação pelo seu ID.")
    MotivoAvaliacaoDto getMotivoAvaliacao(@PathParam("id") @ApiParam(value = "O código de identificação do motivo de avaliação.") final Long idMotivoAvaliacao) throws ValidacaoException, RecursoNaoEncontradoException;

}
