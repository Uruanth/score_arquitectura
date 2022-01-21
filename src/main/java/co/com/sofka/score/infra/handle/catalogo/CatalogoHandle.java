package co.com.sofka.score.infra.handle.catalogo;

import co.com.sofka.score.domain.catalogo.command.CrearCatalogoComando;
import co.com.sofka.score.infra.generic.UseCaseHandle;
import co.com.sofka.score.usecase.catalogo.CrearCatalogoUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CatalogoHandle extends UseCaseHandle {

    private final CrearCatalogoUseCase useCase;

    public CatalogoHandle(CrearCatalogoUseCase useCase){
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofkau.peliculas.creada")
    void consumeBlocking(CrearCatalogoComando command) {
        var events = useCase.apply(command);
        process(command.getCatalogoId(), events);
    }

}
