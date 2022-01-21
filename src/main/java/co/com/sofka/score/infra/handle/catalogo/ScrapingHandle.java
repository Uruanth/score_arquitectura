package co.com.sofka.score.infra.handle.catalogo;

import co.com.sofka.score.domain.catalogo.command.ScrapingWebComando;
import co.com.sofka.score.infra.generic.UseCaseHandle;
import co.com.sofka.score.usecase.catalogo.ScrapingWeb;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ScrapingHandle extends UseCaseHandle {

    private final ScrapingWeb useCase;

    public ScrapingHandle(ScrapingWeb useCase){
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofkau.catalogo.scrapeando")
    void consumeBlocking(ScrapingWebComando command) {
        var events = useCase.apply(command);
        process(command.getCatalogoId(), events);
    }


}
