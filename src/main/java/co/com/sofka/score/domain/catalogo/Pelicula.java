package co.com.sofka.score.domain.catalogo;

import co.com.sofka.score.domain.catalogo.OV.Nombre;
import co.com.sofka.score.domain.catalogo.OV.Url;

import java.util.Objects;

public final class Pelicula {

    private final String id;
    private Nombre nombre;
    private Url url;

    public Pelicula(String id, Nombre nombre, Url url) {
        this.id = Objects.requireNonNull(id);
        this.nombre = Objects.requireNonNull(nombre);
        this.url = Objects.requireNonNull(url);
    }

    private Pelicula(String id){
        this.id = Objects.requireNonNull(id);
    }

}
