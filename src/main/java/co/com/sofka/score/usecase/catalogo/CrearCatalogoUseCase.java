package co.com.sofka.score.usecase.catalogo;

import co.com.sofka.score.domain.catalogo.Catalogo;
import co.com.sofka.score.domain.catalogo.OV.Nombre;
import co.com.sofka.score.domain.catalogo.OV.Url;
import co.com.sofka.score.domain.catalogo.PaginaWeb;
import co.com.sofka.score.domain.generic.DomainEvent;
import co.com.sofka.score.domain.generic.EventStoreRepository;
import co.com.sofka.score.domain.catalogo.command.CrearCatalogoComando;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Dependent
public class CrearCatalogoUseCase implements Function<CrearCatalogoComando, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public CrearCatalogoUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(CrearCatalogoComando command) {
        var catalogo = new Catalogo(command.getCatalogoId(), command.getNombre(), command.getPagina());

        return catalogo.getUncommittedChanges();
    }
}
