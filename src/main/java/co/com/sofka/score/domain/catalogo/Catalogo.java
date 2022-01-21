package co.com.sofka.score.domain.catalogo;

import co.com.sofka.score.domain.catalogo.events.CatalogoCreado;
import co.com.sofka.score.domain.catalogo.events.ScrapeandoWeb;
import co.com.sofka.score.domain.generic.AggregateRoot;
import co.com.sofka.score.domain.generic.DomainEvent;

import java.util.List;

public class Catalogo extends AggregateRoot {

    protected List<String> peliculas;
    protected String pagina;
    protected String nombre;

    public Catalogo(String id,String pagina, String nombre) {
        super(id);
        subscribe(new CatalogoChange(this));
        appendChange(new CatalogoCreado(id, pagina, nombre)).apply();
    }

    private Catalogo(String id){
        super(id);
        subscribe(new CatalogoChange(this));
    }

    public static Catalogo from(String catalogoid, List<DomainEvent> events) {
        var catalogo = new Catalogo((catalogoid));
        events.forEach(catalogo::applyEvent);
        return catalogo;
    }

    public void agregarPelicula(String url){

    }

    public void scrapingWeb(List pelis){
        appendChange(new ScrapeandoWeb(pelis)).apply();

    }




}
