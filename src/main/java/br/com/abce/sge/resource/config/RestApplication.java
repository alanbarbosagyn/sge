package br.com.abce.sge.resource.config;

import br.com.abce.sge.exceptions.InfraestruturaException;
import br.com.abce.sge.exceptions.RecursoNaoEncontradoException;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.resource.impl.ProdutoResourceImpl;
import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestApplication extends Application {

    public RestApplication() {

        BeanConfig conf = new BeanConfig();
        conf.setTitle("API Garçom Eletrônico");
        conf.setDescription("Sistema de autoatendimento em restaurantes e bares");
        conf.setVersion("1.0.0");
        conf.setHost("localhost:8080");
        conf.setBasePath("/sge/rest");
        conf.setSchemes(new String[] { "http" });
        conf.setResourcePackage("br.com.abce.sge.resource");
        conf.setScan(true);
    }

    public Set<Class<?>> getClasses() {

        Set<Class<?>> resources = new HashSet<>();

        // Swagger API documentation
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        resources.add(ValidacaoException.class);
        resources.add(RecursoNaoEncontradoException.class);
        resources.add(InfraestruturaException.class);

        // Resources REST
        resources.add(ProdutoResourceImpl.class);

        return resources;
    }
}
