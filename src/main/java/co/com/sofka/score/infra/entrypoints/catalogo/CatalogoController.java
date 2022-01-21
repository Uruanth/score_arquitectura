package co.com.sofka.score.infra.entrypoints.catalogo;


import co.com.sofka.score.domain.catalogo.command.CrearCatalogoComando;
import co.com.sofka.score.domain.catalogo.command.ScrapingWebComando;
import io.vertx.core.eventbus.EventBus;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/catalogo")
public class CatalogoController {

    private final EventBus bus;

    public CatalogoController(EventBus bus) {
        this.bus = bus;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response executor(CrearCatalogoComando command){
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/scraping")
    public Response executor(ScrapingWebComando command){
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }


}
