package co.com.sofka.score.domain.catalogo;

import co.com.sofka.score.domain.catalogo.events.CatalogoCreado;
import co.com.sofka.score.domain.catalogo.events.ScrapeandoWeb;
import co.com.sofka.score.domain.generic.EventChange;

import java.util.ArrayList;

public class CatalogoChange implements EventChange {

    public CatalogoChange(Catalogo catalogo) {

        listener((CatalogoCreado event) ->{
            catalogo.pagina = event.getPagina();
            catalogo.nombre = event.getNombre();
            catalogo.peliculas = new ArrayList<>();

        });

        listener((ScrapeandoWeb event) ->{
            catalogo.peliculas = event.getPelis();
        });

    }
}
