package br.com.abce.sge.resource.config;


import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = HTTPCodeRestDefinition.EXECUTADO_COM_SUCESSO),
        @ApiResponse(code = 201, message = HTTPCodeRestDefinition.RECURSO_CRIADO_COM_SUCESSO),
        @ApiResponse(code = 400, message = HTTPCodeRestDefinition.VALIDATION_ERROR),
        @ApiResponse(code = 403, message = HTTPCodeRestDefinition.TOKEN_NO_FOUND),
        @ApiResponse(code = 404, message = HTTPCodeRestDefinition.NO_FOUND_INFO),
        @ApiResponse(code = 500, message = HTTPCodeRestDefinition.INTERNAL_ERROR)})
public interface HTTPCodeRestDefinition {

    String EXECUTADO_COM_SUCESSO   = "Executado com sucesso.";
    String RECURSO_CRIADO_COM_SUCESSO = "Recurso criado com sucesso";
    String TOKEN_NO_FOUND          = "Token não foi informado ou inválido";
    String NO_FOUND_INFO           = "Não foram encontrado informações!";
    String VALIDATION_ERROR        = "Erro de validação de négocio. Mensagem de erro vem no corpo da resposta.";
    String INTERNAL_ERROR          = "Erro interno do servidor (Internal Server Error)";
}
