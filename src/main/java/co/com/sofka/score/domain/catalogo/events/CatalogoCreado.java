package co.com.sofka.score.domain.catalogo.events;

import co.com.sofka.score.domain.generic.DomainEvent;

public class CatalogoCreado extends DomainEvent {
    private final String catalogoId;
    private final String pagina;
    private final String nombre;

    @Override
    public String toString() {
        return "CatalogoCreado{" +
                "id='" + catalogoId + '\'' +
                ", pagina='" + pagina + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public CatalogoCreado(String catalogoId, String pagina, String nombre) {
        super("sofkau.peliculas.creada");
        this.catalogoId = catalogoId;
        this.pagina = pagina;
        this.nombre = nombre;
    }

    public String getCatalogoId() {
        return catalogoId;
    }

    public String getPagina() {
        return pagina;
    }

    public String getNombre() {
        return nombre;
    }
}
