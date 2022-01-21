package co.com.sofka.score.domain.catalogo.events;

import co.com.sofka.score.domain.generic.DomainEvent;

import java.util.List;

public class ScrapeandoWeb extends DomainEvent {
    private final List pelis;

    public ScrapeandoWeb(List pelis) {
        super("sofkau.catalogo.scrapeando");
        this.pelis = pelis;
        System.out.println(getAggregateId());
    }

    public List getPelis() {
        return pelis;
    }


}
